/*
*  (C) Copyright 2010-2013 hSenid Mobile Solutions (Pvt) Limited.
*  All Rights Reserved.
*
*  These materials are unpublished, proprietary, confidential source code of
*  hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
*  of hSenid Mobile Solutions (Pvt) Limited.
*
*  hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
*  property rights in these materials.
*/
package diya.dahara.repositories.impl;

import diya.dahara.repositories.FoodRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class FoodRepositoryImpl extends JdbcDaoSupport implements FoodRepository{

   /* @Override
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

    @Override
    public void deleteByIndex(String indexNumber) throws DataAccessException {
        Object[] params = new Object[]{indexNumber};
        final String deleteByIndexSql = "delete from students where index_no=?";
        try {
            getJdbcTemplate().update(deleteByIndexSql, params);
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataAccessException("Error occurred while deleting", e);
        }
    }

    @Override
    public List<Students> getStudentsByBatch(String batch, int offset, int limit) throws DataAccessException {
        List<Students> studentsList = null;

        final String getStudentsByBatchSql =
                "SELECT * from students where batch = ? limit ?, ?";

        Object[] params = new Object[]{batch, offset, limit};

        try {
            studentsList = getJdbcTemplate().query(getStudentsByBatchSql,
                    params, new StudentsRowMapper());
            return studentsList;
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataAccessException("Error occurred while finding students by batch", e);
        }
    }

    @Override
    public int getNoOfStudentsByBatch(String batch) {
        Object[] params = new Object[]{batch};
        final String getNoOfStudentsByBatchSql = "SELECT count(index_no) from students where batch = ?";
        return getJdbcTemplate().queryForInt(getNoOfStudentsByBatchSql, params);
    }

    @Override
    public List<Students> getStudentsByIndex(String index, int offset, int limit) throws DataAccessException {
        List<Students> studentsList = null;

        final String getStudentsByIndexSql =
                "SELECT * from students where index_no = ? limit ?, ?";

        Object[] params = new Object[]{index, offset, limit};

        try {
            studentsList = getJdbcTemplate().query(getStudentsByIndexSql,
                    params, new StudentsRowMapper());
            return studentsList;
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataAccessException("Error occurred while finding students by index", e);
        }
    }

    @Override
    public int getNoOfStudentsByIndex(String index) {
        Object[] params = new Object[]{index};
        final String getNoOfStudentsByIndexSql = "SELECT count(index_no) from students where index_no = ?";
        return getJdbcTemplate().queryForInt(getNoOfStudentsByIndexSql, params);
    }

    @Override
    public List<Students> getStudentsByIndexAndBatch(String index, String batch, int offset, int limit) throws DataAccessException {
        List<Students> studentsList = null;

        final String getStudentsByIndexAndBatchSql =
                "SELECT * from students where index_no = ? and batch = ? limit ?, ?";

        Object[] params = new Object[]{index, batch, offset, limit};

        try {
            studentsList = getJdbcTemplate().query(getStudentsByIndexAndBatchSql,
                    params, new StudentsRowMapper());
            return studentsList;
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataAccessException("Error occurred while finding students by indexnd batch a", e);
        }
    }

    @Override
    public int getNoOfStudentsByIndexAndBatch(String index, String batch) {
        Object[] params = new Object[]{index, batch};
        final String getNoOfStudentsByIndexAndBatchSql = "SELECT count(index_no) from students where index_no = ? and batch = ?";
        return getJdbcTemplate().queryForInt(getNoOfStudentsByIndexAndBatchSql, params);
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
    }*/
}
