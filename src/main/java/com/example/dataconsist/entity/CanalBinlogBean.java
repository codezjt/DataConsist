package com.example.dataconsist.entity;



import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.SQLType;
import java.util.List;

@Data
public class CanalBinlogBean {
    private List<UserEntity> data;

    private String database;

    private long es;

    private  int id;

    private boolean isDdl;

    private MysqlType mysqlType;

    private String old;

    private List<String> pkNames;

    private SQLType sqlType;

    private String table;

    private long ts;

    private String type;

    public List<UserEntity> getData() {
        return data;
    }

    public void setData(List<UserEntity> data) {
        this.data = data;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public long getEs() {
        return es;
    }

    public void setEs(long es) {
        this.es = es;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDdl() {
        return isDdl;
    }

    public void setDdl(boolean ddl) {
        isDdl = ddl;
    }

    public MysqlType getMysqlType() {
        return mysqlType;
    }

    public void setMysqlType(MysqlType mysqlType) {
        this.mysqlType = mysqlType;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public List<String> getPkNames() {
        return pkNames;
    }

    public void setPkNames(List<String> pkNames) {
        this.pkNames = pkNames;
    }

    public SQLType getSqlType() {
        return sqlType;
    }

    public void setSqlType(SQLType sqlType) {
        this.sqlType = sqlType;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
