package com.company.visitor.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface VisitPoint {
    Class<?> forClass();
}
