package uok.mf.repositories.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import uok.mf.domain.Batch;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.repositories.BatchRepository;

/**
 * Created by amila on 3/8/14.
 */
public class BatchRepositoryImpl extends JdbcDaoSupport implements BatchRepository {

    @Override
    public void create(Batch batch) throws DataAccessException {
        String createSql = "INSERT INTO batch " +
                "(name, year) VALUES (?, ?)";
        Object[] params = new Object[]{batch.getName(),batch.getYear()};
        try {
            getJdbcTemplate().update(createSql, params);
        } catch (Exception e) {
            throw new DataAccessException("Error occurred in creating a batch ", e);
        }
    }

    @Override
    public boolean isNameExist(String name) throws DataAccessException {
        final String isNameExistSql = "select count(id) as COUNT from  batch  where name = ?";
        Object[] params = new Object[]{name};
        int count = 0;
        try {
            count = getJdbcTemplate().queryForInt(isNameExistSql, params);
        } catch (Exception e) {
            throw new DataAccessException("Error occurred in checking existence ", e);
        }
        return count > 0;
    }

    @Override
    public boolean isYearExist(String year) throws DataAccessException {
        final String isYearExistSql = "select count(id) as COUNT from  batch  where year = ?";
        Object[] params = new Object[]{year};
        int count = 0;
        try {
            count = getJdbcTemplate().queryForInt(isYearExistSql, params);
        } catch (Exception e) {
            throw new DataAccessException("Error occurred in checking existence ", e);
        }
        return count > 0;
    }

}
