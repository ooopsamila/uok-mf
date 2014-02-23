package uok.mf.service;

import org.springframework.beans.factory.annotation.Autowired;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.domain.impl.StudentsImpl;
import uok.mf.repositories.StudentsRepository;
import uok.mf.students.add.AddStudentForm;

/**
 * Created by amila on 2/22/14.
 */
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public void createStudent(AddStudentForm addStudentForm) throws DataAccessException {
        StudentsImpl studentsImpl = new StudentsImpl();
        studentsImpl.setIndexNumber(addStudentForm.getIndexNumber());
        studentsImpl.setNic(addStudentForm.getNic());
        studentsImpl.setName(addStudentForm.getName());
        studentsImpl.setGender(addStudentForm.getGender());
        studentsImpl.setBatch(addStudentForm.getBatch());
        studentsRepository.create(studentsImpl);
    }
}
