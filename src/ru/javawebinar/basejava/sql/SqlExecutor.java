package ru.javawebinar.basejava.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
//это для эксепшина
public interface SqlExecutor<T> {
    T execute(PreparedStatement st) throws SQLException;
}