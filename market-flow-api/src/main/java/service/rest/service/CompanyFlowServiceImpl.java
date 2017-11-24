package service.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rest.dto.Company;
import service.rest.dto.CompanyFlow;
import service.rest.repository.ICompanyFlowRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CompanyFlowServiceImpl implements CompanyFlowService {

    private static final Logger log = LoggerFactory.getLogger(CompanyFlowServiceImpl.class);

    @Autowired
    private ICompanyFlowRepository companyFlowRepository;

    @Override
    public CompanyFlow findOne(int id) {
        return companyFlowRepository.findOne(id) ;
    }

    public List<CompanyFlow> findAll(){
        return (List<CompanyFlow>) companyFlowRepository.findAll();
    }

    @Override
    public List<CompanyFlow> findCompanyFlowByCompany(Company company) {


        List<CompanyFlow> companyFlows = new ArrayList<CompanyFlow>();

        List<CompanyFlow> companiesFlow = this.findAll();


        for (int i = 0; i < companiesFlow.size(); i++) {

            if (companiesFlow.get(i).getCompany().equals(company)) {

                companyFlows.add(companiesFlow.get(i));
            }

        }


        return companyFlows;
    }


}
