package org.obicere.bytecode.core.objects.signature;

import org.obicere.bytecode.core.objects.Path;
import org.obicere.bytecode.core.objects.SuperTypeTarget;
import org.obicere.bytecode.core.objects.TypeAnnotation;
import org.obicere.bytecode.core.objects.TypeParameterBoundTarget;
import org.obicere.bytecode.core.objects.TypeParameterTarget;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class ClassSignature extends AnnotationTarget {

    public static final String IDENTIFIER = "ClassSignature";

    private final TypeParameters typeParameters;

    private final SuperclassSignature superclassSignature;

    private final SuperinterfaceSignature[] superinterfaceSignatures;

    private ClassSignature(final TypeParameters typeParameters, final SuperclassSignature superclassSignature, final SuperinterfaceSignature[] superinterfaceSignatures) {
        this.typeParameters = typeParameters;
        this.superclassSignature = superclassSignature;
        this.superinterfaceSignatures = superinterfaceSignatures;
    }

    public TypeParameters getTypeParameters() {
        return typeParameters;
    }

    public SuperclassSignature getSuperclassSignature() {
        return superclassSignature;
    }

    public SuperinterfaceSignature[] getSuperinterfaceSignatures() {
        return superinterfaceSignatures;
    }

    public static ClassSignature parse(final QueueString string) {
        if (!string.hasNext()) {
            return null;
        }
        final TypeParameters typeParameters = TypeParameters.parse(string);
        if (typeParameters == null) {
            return null;
        }
        final SuperclassSignature superclassSignature = SuperclassSignature.parse(string);
        if (superclassSignature == null) {
            return null;
        }
        final LinkedList<SuperinterfaceSignature> interfaceList = new LinkedList<>();
        while (string.hasNext()) {
            final SuperinterfaceSignature superinterfaceSignature = SuperinterfaceSignature.parse(string);
            if (superinterfaceSignature == null) {
                return null;
            }
            interfaceList.add(superinterfaceSignature);
        }
        final SuperinterfaceSignature[] superinterfaceSignatures = interfaceList.toArray(new SuperinterfaceSignature[interfaceList.size()]);
        return new ClassSignature(typeParameters, superclassSignature, superinterfaceSignatures);
    }

    public void addAnnotations(final TypeAnnotation[] annotations) {
        for (final TypeAnnotation annotation : annotations) {
            final List<Path> pathList = Arrays.asList(annotation.getTargetPath().getPath());
            walk(annotation, pathList.iterator());
        }
    }

    @Override
    public void walk(final TypeAnnotation annotation, final Iterator<Path> path) {
        final int targetType = annotation.getTargetType();
        switch (targetType) {
            case 0x00: // type_parameter_target
                walkTypeParameterTarget(annotation, path);
                return;
            case 0x10: // supertype_target
                walkSuperTypeTarget(annotation, path);
                return;
            case 0x11: // type_parameter_bound_target
                walkTypeParameterBoundTarget(annotation, path);
                return;
            default:
        }
    }

    private void walkTypeParameterTarget(final TypeAnnotation annotation, final Iterator<Path> path) {
        final TypeParameterTarget target = (TypeParameterTarget) annotation.getTargetInfo();
        final TypeParameter[] types = typeParameters.getTypeParameters();
        types[target.getTypeParameterIndex()].walk(annotation, path);
    }

    private void walkSuperTypeTarget(final TypeAnnotation annotation, final Iterator<Path> path) {
        final SuperTypeTarget target = (SuperTypeTarget) annotation.getTargetInfo();
        final int targetType = target.getTargetType();
        if (targetType == 0xFFFF) { // ushort max value - denotes super class
            superclassSignature.walk(annotation, path);
        } else {
            superinterfaceSignatures[targetType].walk(annotation, path);
        }
    }

    private void walkTypeParameterBoundTarget(final TypeAnnotation annotation, final Iterator<Path> path) {
        final TypeParameterBoundTarget target = (TypeParameterBoundTarget) annotation.getTargetInfo();
        final int typeParameterIndex = target.getTypeParameterIndex();
        final int boundIndex = target.getBoundIndex();
        final TypeParameter[] types = typeParameters.getTypeParameters();
        final TypeParameter type = types[typeParameterIndex];
        final ClassBound classBound = type.getClassBound();
        final InterfaceBound[] interfaceBounds = type.getInterfaceBounds();
        final boolean hasClassBound = classBound.getReferenceTypeSignature() != null;
        if (boundIndex == 0) {
            if (hasClassBound) {
                classBound.walk(annotation, path);
            } else {
                interfaceBounds[0].walk(annotation, path);
            }
        } else {
            final int fixedIndex;
            if (hasClassBound) {
                fixedIndex = boundIndex - 1;
            } else {
                fixedIndex = boundIndex;
            }
            interfaceBounds[fixedIndex].walk(annotation, path);
        }
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append(typeParameters);
        builder.append(' ');

        builder.append(superclassSignature);

        boolean first = true;
        for (final SuperinterfaceSignature signature : superinterfaceSignatures) {
            if (first) {
                builder.append(" & ");
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append(signature);
        }

        return builder.toString();
    }
}
