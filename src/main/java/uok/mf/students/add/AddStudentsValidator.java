package uok.mf.students.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uok.mf.common.CommonValidator;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.repositories.StudentsRepository;

/**
 * Created by amila on 2/23/14.
 */
public class AddStudentsValidator extends CommonValidator implements Validator {
    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AddStudentForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        AddStudentForm addStudentForm = (AddStudentForm) object;
        String indexNumber = addStudentForm.getIndexNumber();
        String nic = addStudentForm.getNic();
        String name = addStudentForm.getName();
        String gender = addStudentForm.getGender();
        String batch = addStudentForm.getBatch();

        if (isEmpty(indexNumber)) {
            errors.rejectValue("indexNumber", "uok.mf.validation.students.index.number.empty");
        } else try {
            if (studentsRepository.isExistByIndex(indexNumber)) {
                errors.rejectValue("indexNumber", "uok.mf.validation.students.index.number.already.exist");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        if (isEmpty(nic)) {
            errors.rejectValue("nic", "uok.mf.validation.students.nic.empty");
        } else try {
            if (studentsRepository.isExistByNic(nic)) {
                errors.rejectValue("nic", "uok.mf.validation.students.nic.already.exist");

            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        if (isEmpty(name)) {
            errors.rejectValue("name", "uok.mf.validation.students.name.empty");
        }

        if (isEmpty(gender)) {
            errors.rejectValue("gender", "uok.mf.validation.students.gender.empty");
        }

        if (isEmpty(batch)) {
            errors.rejectValue("batch", "uok.mf.validation.students.batch.empty");
        }


    }
}
