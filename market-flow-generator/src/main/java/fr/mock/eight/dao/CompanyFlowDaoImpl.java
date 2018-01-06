package fr.mock.eight.dao;

import fr.mock.eight.Utils.Properties;
import fr.mock.eight.model.CompanyFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by Vyach on 26/11/2017.
 */
@Repository
public class CompanyFlowDaoImpl extends JdbcDaoSupport implements CompanyFlowDao{

    /*@Qualifier("dataSource")
    @Autowired
    DataSource dataSource;*/






    @PostConstruct
    private void initialize() {

        //Properties properties = new Properties();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://10.10.1.5:5432/marketapimock");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");


        setDataSource(dataSource);

    }

    @Override
    public void insert(CompanyFlow companyFlow) {

        String sql = "INSERT INTO COMPANYFLOW(" +
                "            id, date, hour_date, from_currency, to_currency, value, company_id) " +
                "    VALUES " +
                "(?, ?, ?, ?, ?, ?, ?)";


        getJdbcTemplate().update(sql, new Object[] {
                companyFlow.getId(), companyFlow.getDate(), companyFlow.getDateHour(),
                companyFlow.getFromCurrency(), companyFlow.getToCurrency(),
                companyFlow.getValue(), companyFlow.getCompanyId()
        });


    }

    @Override
    public void delete(CompanyFlow companyFlow) {

        String sql = "DELETE FROM COMPANYFLOW WHERE " +
                "id = ? " +
                "AND date = ? " +
                "AND hour_date = ?" +
                "AND from_currency = ?" +
                "AND to_currency = ? " +
                "AND value = ?" +
                "AND company_id = ?";



        /*getJdbcTemplate().queryForObject(
                sql,
                new Object[] {
                    companyFlow.getId(), companyFlow.getDate(), companyFlow.getDateHour(),
                    companyFlow.getFromCurrency(), companyFlow.getToCurrency(),
                    companyFlow.getValue(), companyFlow.getCompanyId()
                },
                new BeanPropertyRowMapper(CompanyFlow.class)
        );*/

        int result = getJdbcTemplate().update(
                sql,
                new Object[] {
                        companyFlow.getId(), companyFlow.getDate(), companyFlow.getDateHour(),
                        companyFlow.getFromCurrency(), companyFlow.getToCurrency(),
                        companyFlow.getValue(), companyFlow.getCompanyId()
                }
        );

        System.out.println("call delete query, result : " + result);

    }

    @Override
    public CompanyFlow getLastCompanyFlow() {


        String sql = "select * from companyflow order by date asc limit 1";


        CompanyFlow companyFlow = (CompanyFlow)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, new BeanPropertyRowMapper(CompanyFlow.class));


        return companyFlow;
    }

    @Override
    public void deleteLastCompanyFlow() {
        String sql = "delete from companyflow where id = " +
                "(select id from companyflow order by date asc limit 1)";

        getJdbcTemplate().update(sql);

    }


}
