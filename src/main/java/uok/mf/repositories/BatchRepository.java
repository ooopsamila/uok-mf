package uok.mf.repositories;

import uok.mf.domain.Batch;
import uok.mf.domain.impl.DataAccessException;

/**
 * Created by amila on 3/8/14.
 */
public interface BatchRepository {
    void create(Batch batch) throws DataAccessException;

    public boolean isNameExist(String name) throws DataAccessException;

    public boolean isYearExist(String year) throws DataAccessException;
}
