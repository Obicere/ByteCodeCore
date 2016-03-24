package org.obicere.bytecode.core.objects.signature;

import org.obicere.bytecode.core.objects.Path;
import org.obicere.bytecode.core.objects.TypeAnnotation;

import java.util.Iterator;

/**
 */
public class ClassBound extends AnnotationTarget {

    public static final String IDENTIFIER = "ClassBound";

    private final ReferenceTypeSignature referenceTypeSignature;

    private ClassBound(final ReferenceTypeSignature referenceTypeSignature) {
        this.referenceTypeSignature = referenceTypeSignature;
    }

    public ReferenceTypeSignature getReferenceTypeSignature() {
        return referenceTypeSignature;
    }

    public static ClassBound parse(final QueueString string) {
        if (!string.hasNext() || string.next() != ':') {
            return null;
        }
        final char peek = string.peek();
        if (peek != ':' && peek != '>') {
            final ReferenceTypeSignature referenceTypeSignature = ReferenceTypeSignature.parse(string);
            if (referenceTypeSignature != null) {
                return new ClassBound(referenceTypeSignature);
            }
            return null;
        }
        // either the RefTypeSig was not declared (it is optional)
        // or we saw a ':', so an interface bound is ahead
        // or we saw a '>', so the TypeParameters are done
        return new ClassBound(null);
    }

    @Override
    public void walk(final TypeAnnotation annotation, final Iterator<Path> path) {
        referenceTypeSignature.walk(annotation, path);
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public String toString() {
        if (referenceTypeSignature == null) {
            return "";
        } else {
            return referenceTypeSignature.toString();
        }
    }
}
