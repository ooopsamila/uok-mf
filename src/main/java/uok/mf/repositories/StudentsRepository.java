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
}
