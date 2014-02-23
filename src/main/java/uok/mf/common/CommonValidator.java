package uok.mf.common;

/**
 * Created by amila on 2/23/14.
 */
public class CommonValidator{
    private static final String NOT_SELECTED = "-1";

    public boolean isEmpty(String value){
        return value == null || value.equals("") || value.equals(NOT_SELECTED);
    }
}
