package uok.mf.repositories.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import uok.mf.domain.Students;
import uok.mf.repositories.StudentsRepository;

/**
 * Created by amila on 2/22/14.
 */
public class StudentsRepositoryImpl extends JdbcDaoSupport implements StudentsRepository {
    @Override
    public void create(Students students) {
        String createSql = "INSERT INTO students " +
                "(index_no, nic, name, gender, batch) VALUES (?, ?, ?,?,?)";

        getJdbcTemplate().update(createSql, new Object[]{students.getIndexNumber(),
                students.getNic(), students.getName(), students.getGender(), students.getBatch()
        });
    }
}
