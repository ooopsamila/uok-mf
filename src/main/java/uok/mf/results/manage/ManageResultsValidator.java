package uok.mf.results.manage;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by amila on 2/23/14.
 */
public class ManageResultsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ManageResultsForm.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
