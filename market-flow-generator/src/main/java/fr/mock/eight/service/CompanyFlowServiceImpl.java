package fr.mock.eight.service;

import fr.mock.eight.dao.CompanyFlowDao;
import fr.mock.eight.model.CompanyFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vyach on 26/11/2017.
 */
@Service
public class CompanyFlowServiceImpl implements CompanyFlowService{


    @Autowired
    CompanyFlowDao companyFlowDao;

    @Override
    public void insert(CompanyFlow companyFlow) {
        companyFlowDao.insert(companyFlow);
    }

    @Override
    public void delete(CompanyFlow companyFlow) {
        companyFlowDao.delete(companyFlow);
    }

    @Override
    public CompanyFlow getLastCompanyFlow() {

        CompanyFlow companyFlow = companyFlowDao.getLastCompanyFlow();

        return companyFlow;
    }

    @Override
    public void deleteLastCompanyFlow() {

        companyFlowDao.deleteLastCompanyFlow();

    }
}
