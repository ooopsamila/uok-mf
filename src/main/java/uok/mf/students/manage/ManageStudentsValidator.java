package uok.mf.students.manage;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by amila on 2/23/14.
 */
public class ManageStudentsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ManageStudentsForm.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
