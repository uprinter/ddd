package com.kosharovskiy.ddd.activerecord;

import java.util.Map;

public interface Database {
    void execute(String sql, Object... params);
    void startTransaction();
    void commitTransaction();
    void rollbackTransaction();
    Map<String, String> query(String sql, Object... params);
}
