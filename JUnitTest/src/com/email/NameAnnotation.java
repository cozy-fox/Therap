package com.email;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface NameAnnotation {
    int minValue() default 2;

    int maxValue() default 5;

}
