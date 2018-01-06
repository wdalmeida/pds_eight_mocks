package fr.mock.eight.service;

import fr.mock.eight.model.CompanyFlow;

/**
 * Created by Vyach on 26/11/2017.
 */
public interface CompanyFlowService {


    void insert(CompanyFlow companyFlow);
    void delete(CompanyFlow companyFlow);

    CompanyFlow getLastCompanyFlow();

    void deleteLastCompanyFlow();
}
