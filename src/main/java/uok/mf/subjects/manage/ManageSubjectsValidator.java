package uok.mf.subjects.manage;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by amila on 2/23/14.
 */
public class ManageSubjectsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ManageSubjectsForm.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
