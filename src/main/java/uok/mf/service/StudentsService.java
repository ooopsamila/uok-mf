package uok.mf.service;

import org.springframework.beans.factory.annotation.Autowired;
import uok.mf.domain.Students;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.domain.impl.StudentsImpl;
import uok.mf.reporttemplate.ReportTemplate;
import uok.mf.reporttemplate.impl.ReportTemplateImpl;
import uok.mf.repositories.StudentsRepository;
import uok.mf.students.add.AddStudentForm;
import uok.mf.students.manage.ManageStudentsForm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amila on 2/22/14.
 */
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    private int limit;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    public Map generateReport(ManageStudentsForm manageStudentsForm, String type) throws DataAccessException {
        ReportTemplate studentReport = new ReportTemplateImpl();
        studentReport.setHeader("Manage Students Report");
        String index = manageStudentsForm.getIndexNumber();
        String batch = manageStudentsForm.getBatch();
        List<Students> studentsList = new ArrayList<Students>();
        if ((index == null || index.equals("")) && (batch == null || batch.equals(""))) {
            studentsList = studentsRepository.getAllStudents(0, limit);
            studentReport.setSubHeader("");
        } else if ((index == null || index.equals("")) && !(batch == null || batch.equals(""))) {
            studentsList = studentsRepository.getStudentsByBatch(batch, 0, limit);
            studentReport.setSubHeader("Batch - " + manageStudentsForm.getBatch());
        } else if (!(index == null || index.equals("")) && (batch == null || batch.equals(""))) {
            studentsList = studentsRepository.getStudentsByIndex(index, 0, limit);
            studentReport.setSubHeader("Index Number - " + manageStudentsForm.getIndexNumber());
        } else {
            studentsList = studentsRepository.getStudentsByIndexAndBatch(index, batch, 0, limit);
            studentReport.setSubHeader("Index Number- " + manageStudentsForm.getIndexNumber() + " , " + "Batch - " + manageStudentsForm.getBatch());
        }

        studentReport.setColHeaders(new String[]{"Index Number", "NIC", "Name", "Gender", "Batch"});
        List<String[]> dataStrings = new ArrayList<String[]>();
        String[] column;
        for (Students students : studentsList) {
            column = new String[5];
            column[0] = students.getIndexNumber();
            column[1] = students.getNic();
            column[2] = students.getName();
            column[3] = students.getGender();
            column[4] = students.getBatch();
            dataStrings.add(column);
        }
        studentReport.setData(dataStrings);
        Map model = new HashMap();
        model.put("type", type);
        model.put("reportHeader", studentReport.getHeader());
        model.put("reportParams", studentReport.getSubHeader());
        model.put("reportColumn", studentReport.getColHeaders());
        model.put("reportBeans", studentReport.getData());
        return model;
    }
}
