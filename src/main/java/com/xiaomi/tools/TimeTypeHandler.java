package com.xiaomi.tools;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.Date;

public class TimeTypeHandler implements TypeHandler<Timestamp> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Timestamp parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("TimeTypeHandler : setParameter()");
    }

    @Override
    public Timestamp getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("TimeTypeHandler : getResult  1()");
        Timestamp timestamp = rs.getTimestamp(columnName);
        System.out.println(timestamp);
        return timestamp;
    }

    @Override
    public Timestamp getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("TimeTypeHandler : getResult  2()");
        return null;
    }

    @Override
    public Timestamp getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("TimeTypeHandler : getResult  3()");
        return null;
    }

//    @Override
//    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
//        System.out.println("TimeTypeHandler : setParameter()");
//        ps.setDate(i,(java.sql.Date)parameter);
//    }
//
//    @Override
//    public Date getResult(ResultSet rs, String columnName) throws SQLException {
//        System.out.println("TimeTypeHandler : getResult  1()");
//        Date date = (Date) rs.getTime(columnName);
//        System.out.println("取出 : "+rs.getTime(columnName));
//        System.out.println("转化 : "+ date);
//        return rs.getTime(columnName);
//    }
//
//    @Override
//    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
//        System.out.println("TimeTypeHandler : getResult  2()");
//        Date date = (Date) rs.getTime(columnIndex);
//        System.out.println(date);
//        return rs.getTime(columnIndex);
//    }
//
//    @Override
//    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
//        System.out.println("TimeTypeHandler : getResult  3()");
//        Date date = (Date) cs.getTime(columnIndex);
//        System.out.println(date);
//        return cs.getTime(columnIndex);
//    }columnIndex
}
