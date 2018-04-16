package org.springframework.boot.boursemarketgenerator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.boursemarketgenerator.model.Flows;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class FlowDaoImpl extends JdbcDaoSupport implements FlowDao {


    protected final JdbcTemplate jdbc;

    @Autowired
    public FlowDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public void insert(Flows flow) {



        String sql = "INSERT INTO FLOWS(" +
                "            id, date, hour_date, value, name_company, code_company, siret_company) " +
                "    VALUES " +
                "(?, ?, ?, ?, ?, ?, ?)";


        jdbc.update(sql, new Object[] {
                flow.getId(),
                flow.getDate(),
                flow.getDateHour(),
                flow.getValue(),
                flow.getNameCompany(),
                flow.getCodeCompany(),
                flow.getSiretCompany()

        });

    }

    @Override
    public void delete(Flows flow) {

        String sql = "DELETE FROM FLOWS WHERE " +
                "id = ? " +
                "AND date = ? " +
                "AND hour_date = ?" +
                "AND value = ?" +
                "AND name_company = ?" +
                "AND code_company = ?" +
                "AND siret_company = ?";


        int result = jdbc.update(
                sql,
                new Object[] {
                        flow.getId(),
                        flow.getDate(),
                        flow.getDateHour(),
                        flow.getValue(),
                        flow.getNameCompany(),
                        flow.getCodeCompany(),
                        flow.getSiretCompany()
                }
        );

        System.out.println("call delete query, result : " + result);

    }

    @Override
    public Flows getLastFlow() {


        String sql = "select * from flows order by date asc limit 1";


        Flows flow = (Flows)jdbc.queryForObject(
                sql, new Object[] {  }, new BeanPropertyRowMapper(Flows.class));


        return flow;
    }

    @Override
    public void deleteLastFlow() {
        String sql = "delete from flows where id = " +
                "(select id from flows order by date asc limit 1)";

        jdbc.update(sql);

    }



}
