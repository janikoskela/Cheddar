package com.urhola.cheddar.annotation;

import com.urhola.cheddar.validation.AllowedValuesValidation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author janikoskela
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@net.sf.oval.configuration.annotation.Constraint(checkWith = AllowedValuesValidation.class)
public @interface AllowedValues {
  String[] value();
}