package uok.mf.repositories.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import uok.mf.domain.Students;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.domain.impl.StudentsImpl;
import uok.mf.repositories.StudentsRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by amila on 2/22/14.
 */
public class StudentsRepositoryImpl extends JdbcDaoSupport implements StudentsRepository {
    @Override
    public void create(Students students) throws DataAccessException {
        String createSql = "INSERT INTO students " +
                "(index_no, nic, name, gender, batch) VALUES (?, ?, ?,?,?)";
        Object[] params = new Object[]{students.getIndexNumber(),
                students.getNic(), students.getName(), students.getGender(), students.getBatch()};
        try {
            getJdbcTemplate().update(createSql, params);
        } catch (Exception e) {
            throw new DataAccessException("Error occurred in creating a student ", e);
        }
    }

    @Override
    public boolean isExistByIndex(String indexNumber) throws DataAccessException {
        final String isExistByIndexSql = "select count(index_no) as COUNT from  students  where index_no = ?";
        Object[] params = new Object[]{indexNumber};
        int count = 0;
        try {
            count = getJdbcTemplate().queryForInt(isExistByIndexSql, params);
        } catch (Exception e) {
            throw new DataAccessException("Error occurred in checking existence ", e);
        }
        return count > 0;
    }

    @Override
    public boolean isExistByNic(String nic) throws DataAccessException {
        final String isExistByNicSql = "select count(index_no) as COUNT from  students  where nic = ?";
        Object[] params = new Object[]{nic};
        int count = 0;
        try {
            count = getJdbcTemplate().queryForInt(isExistByNicSql, params);
        } catch (Exception e) {
            throw new DataAccessException("Error occurred in checking existence ", e);
        }
        return count > 0;
    }

    @Override
    public List<Students> getAllStudents(int offset, int limit) throws DataAccessException {
        List<Students> studentsList = null;

        final String getAllStudentsSql =
                "SELECT * from students limit ?, ?";

        Object[] params = new Object[]{offset, limit};

        try {
            studentsList = getJdbcTemplate().query(getAllStudentsSql,
                    params, new StudentsRowMapper());
            return studentsList;
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataAccessException("Error occurred while finding all students", e);
        }
    }

    @Override
    public int getTotalNoOfStudents() {
        final String getTotalNoOfStudentsSql = "SELECT count(index_no) from students";
        return getJdbcTemplate().queryForInt(getTotalNoOfStudentsSql);
    }

    private class StudentsRowMapper implements RowMapper {

        @Override
        public Students mapRow(ResultSet rs, int i) throws SQLException {
            StudentsImpl students = new StudentsImpl();
            students.setIndexNumber(rs.getString("index_no"));
            students.setNic(rs.getString("nic"));
            students.setName(rs.getString("name"));
            students.setGender(rs.getString("gender"));
            students.setBatch(rs.getString("batch"));
            return students;
        }
    }
}
