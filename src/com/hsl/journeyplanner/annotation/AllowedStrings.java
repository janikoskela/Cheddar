package com.hsl.journeyplanner.annotation;

import com.hsl.journeyplanner.validation.AllowedStringsValidation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author  Koskela Jani
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@net.sf.oval.configuration.annotation.Constraint(checkWith = AllowedStringsValidation.class)
public @interface AllowedStrings {
  String[] value();
}