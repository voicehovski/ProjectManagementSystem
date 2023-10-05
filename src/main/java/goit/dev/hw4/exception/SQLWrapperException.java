package goit.dev.hw4.exception;

import java.sql.SQLException;

public class SQLWrapperException extends RuntimeException {
    public SQLWrapperException (SQLException e) {
        super (e);
    }
    public SQLWrapperException (String msg) {
        super(msg);
    }
}
