package com.kosharovskiy.ddd.transactionscript;

public interface Database {
    void execute(String sql, Object... params);
    void startTransaction();
    void commitTransaction();
    void rollbackTransaction();
}
