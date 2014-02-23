package uok.mf.students.manage;

import uok.mf.domain.Students;

import java.util.List;

/**
 * Created by amila on 2/22/14.
 */
public class ManageStudentsForm {
    private String indexNumber;
    private String batch;
    private List<Students> studentsList;

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
