package com.company;

import java.sql.SQLException;
import java.sql.Statement;

public interface SQLObject {
    public void add_to_DB(Statement stmt);

}
