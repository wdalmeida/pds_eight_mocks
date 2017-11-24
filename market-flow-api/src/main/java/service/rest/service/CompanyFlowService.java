package service.rest.service;

import service.rest.dto.CompanyFlow;

import java.util.List;


public interface CompanyFlowService {

    public CompanyFlow findOne(int id);

    public List<CompanyFlow> findAll();

}
