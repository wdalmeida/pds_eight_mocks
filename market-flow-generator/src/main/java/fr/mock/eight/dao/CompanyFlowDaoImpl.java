package fr.mock.eight.dao;

import fr.mock.eight.model.CompanyFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by Vyach on 26/11/2017.
 */
@Repository
public class CompanyFlowDaoImpl extends JdbcDaoSupport implements CompanyFlowDao{

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);

    }

    @Override
    public void insert(CompanyFlow companyFLow) {

        String sql = "INSERT INTO COMPANYFLOW(" +
                "            id, date, hour_date, from_currency, to_currency, value, company_id) " +
                "    VALUES " +
                "(?, ?, ?, ?, ?, ?, ?)";

        getJdbcTemplate().update(sql, new Object[] {
           companyFLow.getId(), companyFLow.getDate(), companyFLow.getDateHour(),
                companyFLow.getFromCurrency(), companyFLow.getToCurrency(),
                companyFLow.getValue(), companyFLow.getCompanyId()
        });

    }
}
