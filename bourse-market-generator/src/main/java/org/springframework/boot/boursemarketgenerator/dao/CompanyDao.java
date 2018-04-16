package org.springframework.boot.boursemarketgenerator.dao;


import org.springframework.boot.boursemarketgenerator.model.Company;

public interface CompanyDao {


    void insert(Company company);
    Company getLastCompany();


}
