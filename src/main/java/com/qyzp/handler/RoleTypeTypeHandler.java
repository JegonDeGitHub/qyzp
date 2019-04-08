package com.qyzp.handler;

import com.qyzp.bean.enums.RoleType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleTypeTypeHandler extends BaseTypeHandler<RoleType> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, RoleType roleType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,roleType.getValue());
    }

    @Override
    public RoleType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return RoleType.valueOf(resultSet.getInt(s));
    }

    @Override
    public RoleType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return RoleType.valueOf(resultSet.getInt(i));
    }

    @Override
    public RoleType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return RoleType.valueOf(callableStatement.getInt(i));
    }
}
