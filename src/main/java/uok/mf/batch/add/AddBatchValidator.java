package uok.mf.batch.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uok.mf.common.CommonValidator;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.repositories.BatchRepository;

/**
 * Created by amila on 3/8/14.
 */
public class AddBatchValidator extends CommonValidator implements Validator {
    @Autowired
    private BatchRepository batchRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AddBatchForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        final AddBatchForm addBatchForm = (AddBatchForm)object;
        final String name = addBatchForm.getName();
        final String year = addBatchForm.getYear();

        if(isEmpty(name)){
            errors.rejectValue("name", "uok.mf.validation.batch.name.empty");
        }else try {
            if(batchRepository.isNameExist(name)){
                errors.rejectValue("name", "uok.mf.validation.batch.name.already.exist");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        if(isEmpty(year)){
            errors.rejectValue("year", "uok.mf.validation.batch.year.empty");
        }else try {
            if(batchRepository.isYearExist(year)){
                errors.rejectValue("year", "uok.mf.validation.batch.year.already.exist");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
}
