package uok.mf.results.add;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uok.mf.results.add.AddResultsForm;

/**
 * Created by amila on 2/23/14.
 */
public class AddResultsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AddResultsForm.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
