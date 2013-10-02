package com.urhola.cheddar.validation;

import com.urhola.cheddar.annotation.AllowedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

/**
 *
 * @author janikoskela
 */
public class AllowedValuesValidation extends AbstractAnnotationCheck<AllowedValues> {
    
    private List<String> allowedValues;
    
    @Override
    public void configure(AllowedValues constraintAnnotation) {
        this.allowedValues = new ArrayList<String>();
        this.allowedValues.addAll(Arrays.asList(constraintAnnotation.value()));
        super.configure(constraintAnnotation);
    }
    
    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {
        if (valueToValidate != null) {
            List<String> valuesToBeValidated = (List)valueToValidate;
            for (String str : valuesToBeValidated) {
                if (!this.allowedValues.contains(str))
                    return false;
            }
        }
        return true;
    }

}
