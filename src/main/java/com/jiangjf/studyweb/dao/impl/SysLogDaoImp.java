package com.jiangjf.studyweb.dao.impl;

import com.jiangjf.studyweb.dao.SysLogDao;
import com.jiangjf.studyweb.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysLogDaoImp implements SysLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog syslog) {
        StringBuffer sb = new StringBuffer("insert into sys_log ");
        sb.append("(username,operation,time,method,params,ip,create_time) ");
        sb.append("values(:username,:operation,:time,:method,:params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        npjt.update(sb.toString(), new BeanPropertySqlParameterSource(syslog));
    }
}
