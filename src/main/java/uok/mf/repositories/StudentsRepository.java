package uok.mf.repositories;

import uok.mf.domain.Students;
import uok.mf.domain.impl.DataAccessException;

import java.util.List;

/**
 * Created by amila on 2/22/14.
 */
public interface StudentsRepository {

    public void create(Students students) throws DataAccessException;

    public boolean isExistByIndex(String indexNumber) throws DataAccessException;

    boolean isExistByNic(String nic) throws DataAccessException;

    public List<Students> getAllStudents(int offset, int limit) throws DataAccessException;

    public int getTotalNoOfStudents();

    public void deleteByIndex(String indexNumber) throws DataAccessException;

    public List<Students> getStudentsByBatch(String batch, int offset, int limit) throws DataAccessException;

    public int getNoOfStudentsByBatch(String batch);

    public List<Students> getStudentsByIndex(String index, int offset, int limit) throws DataAccessException;

    public int getNoOfStudentsByIndex(String index);

    public List<Students> getStudentsByIndexAndBatch(String index, String batch, int offset, int limit) throws DataAccessException;

    public int getNoOfStudentsByIndexAndBatch(String index, String batch);
}
