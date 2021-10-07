package com.company.visitor;

import com.company.visitor.annotation.VisitPoint;
import com.company.visitor.exception.UnsupportedNodeForVisitException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Visitor {

    private final Map<Class<?>, Method> methodMap;

    protected Visitor() {
        methodMap = getAllMethods().stream()
                .filter(m -> m.isAnnotationPresent(VisitPoint.class))
                .collect(Collectors.toMap(m -> m.getAnnotation(VisitPoint.class).forClass(), m -> m));
    }

    public final void visitNode(final Object node) throws UnsupportedNodeForVisitException {
        final Class<?> nodeClass = node.getClass();

        try {
            final var method = methodMap.get(nodeClass);
            method.setAccessible(true);
            method.invoke(this, node);
        } catch (NullPointerException | IllegalAccessException | InvocationTargetException e) {
            throw new UnsupportedNodeForVisitException("Cannot invoke method for type: " + nodeClass, e);
        }
    }

    private Set<Method> getAllMethods() {
        final var methods = new HashSet<Method>();

        for (Class<?> aClass = getClass(); aClass != null; aClass = aClass.getSuperclass()) {
            Collections.addAll(methods, aClass.getDeclaredMethods());
        }

        return methods;
    }

}
