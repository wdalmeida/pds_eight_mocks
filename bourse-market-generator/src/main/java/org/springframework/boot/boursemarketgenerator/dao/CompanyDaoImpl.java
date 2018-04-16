package org.springframework.boot.boursemarketgenerator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.boursemarketgenerator.model.Company;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class CompanyDaoImpl extends JdbcDaoSupport implements CompanyDao {


    protected final JdbcTemplate jdbc;

    @Autowired
    public CompanyDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Company company) {

        String sql = "INSERT INTO " + " company "+"("+
                " name , " +
                "cours , " +
                "ouverture , " +
                "haut , " +
                "bas , " +
                "volume , " +
                "datedonnee , " +
                "variation) " +
                "    VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?)";

        jdbc.update(sql, new Object[]{
                company.getName(),
                company.getCours(),
                company.getOuverture(),
                company.getHaut(),
                company.getBas(),
                company.getVolume(),
                company.getDateDonnee(),
                company.getVariation()
        });
    }

    @Override
    public Company getLastCompany() {
        String sql = "select * from Company order by date asc limit 1";
        Company company = (Company)jdbc.queryForObject(
                sql, new Object[] {  }, new BeanPropertyRowMapper(Company.class));
        return company;
    }
}
