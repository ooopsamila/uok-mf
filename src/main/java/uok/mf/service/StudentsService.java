package uok.mf.service;

import org.springframework.beans.factory.annotation.Autowired;
import uok.mf.domain.Students;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.domain.impl.StudentsImpl;
import uok.mf.repositories.StudentsRepository;
import uok.mf.students.add.AddStudentForm;
import uok.mf.students.manage.ManageStudentsForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by amila on 2/22/14.
 */
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    private int limit;

    public void createStudent(AddStudentForm addStudentForm) throws DataAccessException {
        StudentsImpl studentsImpl = new StudentsImpl();
        studentsImpl.setIndexNumber(addStudentForm.getIndexNumber());
        studentsImpl.setNic(addStudentForm.getNic());
        studentsImpl.setName(addStudentForm.getName());
        studentsImpl.setGender(addStudentForm.getGender());
        studentsImpl.setBatch(addStudentForm.getBatch());
        studentsRepository.create(studentsImpl);
    }

    public void populateManageStudentsForm(ManageStudentsForm manageStudentsForm, Map pageMap, int offset) throws DataAccessException {
        String index = manageStudentsForm.getIndexNumber();
        String batch = manageStudentsForm.getBatch();
        List<Students> studentsList = new ArrayList<Students>();
        int dataListSize = 0;
        if ((index == null || index.equals("")) && (batch == null || batch.equals(""))) {
            studentsList = studentsRepository.getAllStudents(offset, limit);
            dataListSize = studentsRepository.getTotalNoOfStudents();

        } else if ((index == null || index.equals("")) && !(batch == null || batch.equals(""))) {
            studentsList = studentsRepository.getStudentsByBatch(batch, offset, limit);
            dataListSize = studentsRepository.getNoOfStudentsByBatch(batch);
        } else if (!(index == null || index.equals("")) && (batch == null || batch.equals(""))) {
            studentsList = studentsRepository.getStudentsByIndex(index, offset, limit);
            dataListSize = studentsRepository.getNoOfStudentsByIndex(index);
        } else {
            studentsList = studentsRepository.getStudentsByIndexAndBatch(index, batch, offset, limit);
            dataListSize = studentsRepository.getNoOfStudentsByIndexAndBatch(index, batch);
        }


        manageStudentsForm.setStudentsList(studentsList);
        pageMap.put("dataListSize", dataListSize);
        pageMap.put("limit", limit);
        pageMap.put("offset", offset);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void deleteStudent(String indexNumber) throws DataAccessException {
        studentsRepository.deleteByIndex(indexNumber);
    }
}
