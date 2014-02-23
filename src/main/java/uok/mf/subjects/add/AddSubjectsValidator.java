package uok.mf.subjects.add;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by amila on 2/23/14.
 */
public class AddSubjectsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AddSubjectsForm.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
