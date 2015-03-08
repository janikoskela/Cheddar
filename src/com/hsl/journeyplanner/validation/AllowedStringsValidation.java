package com.hsl.journeyplanner.validation;

import com.hsl.journeyplanner.annotation.AllowedStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

/**
 *
 * @author  Koskela Jani
 */
public class AllowedStringsValidation extends AbstractAnnotationCheck<AllowedStrings> {
    
    private List<String> allowedStrings;
    
    @Override
    public void configure(AllowedStrings constraintAnnotation) {
        this.allowedStrings = new ArrayList<>();
        this.allowedStrings.addAll(Arrays.asList(constraintAnnotation.value()));
        super.configure(constraintAnnotation);
    }
    
    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {
        if (valueToValidate != null) {
            List<String> valuesToBeValidated = (List)valueToValidate;
            for (String str : valuesToBeValidated) {
                if (!this.allowedStrings.contains(str))
                    return false;
            }
        }
        return true;
    }

}
