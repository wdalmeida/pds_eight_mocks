package service.rest.service;

import service.rest.dto.Company;

import java.util.List;


public interface CompanyService {

    public Company findOne(int id);

    public List<Company> findAll();

}
