package service.rest.service;


import service.rest.dto.Flows;

import java.util.List;


public interface FlowsService {

    public Flows findOne(int id);

    public List<Flows> findAll();

    public List<Flows> findCompanyFlowByCompanyCode(String codeCompany);

}
