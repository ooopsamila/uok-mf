package uok.mf.domain.impl;

import uok.mf.domain.Batch;

/**
 * Created by amila on 3/8/14.
 */
public class BatchImpl implements Batch{
    private long id;
    private String name;
    private String year;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
