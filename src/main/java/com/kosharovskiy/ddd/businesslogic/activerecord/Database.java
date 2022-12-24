package com.kosharovskiy.ddd.businesslogic.activerecord;

public interface Database {
    void execute(String sql, Object... params);
    void startTransaction();
    void commitTransaction();
    void rollbackTransaction();
}
