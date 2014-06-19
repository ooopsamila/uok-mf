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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Created by amila on 2/22/14.
 */
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    private int limit;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
        final String index = manageStudentsForm.getIndexNumber();
        final String batch = manageStudentsForm.getBatch();
        List<Students> studentsList = new ArrayList();
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
        final String index = manageStudentsForm.getIndexNumber();
        final String batch = manageStudentsForm.getBatch();
        List<Students> studentsList = new ArrayList();
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
        List<String[]> dataStrings = new ArrayList();
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
    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 1; i < sheet.getRows(); i++) {

                    Cell cell = sheet.getCell(map.get("studentNumber"), i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        System.out.println("I got a label "
                                + cell.getContents());
                    }

                    if (type == CellType.NUMBER) {
                        System.out.println("I got a number "
                                + cell.getContents());
                    }

                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
