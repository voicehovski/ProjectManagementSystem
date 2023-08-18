package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public abstract class AbstractUpdateQuery extends AbstractQuery {
    public AbstractUpdateQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }
}
