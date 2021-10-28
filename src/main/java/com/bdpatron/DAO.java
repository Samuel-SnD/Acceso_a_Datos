package com.bdpatron;

import java.sql.Connection;
import java.util.List;

public interface DAO <T> {
    T get(long id, Connection con);
    List<T> getAll(Connection conn);
}
