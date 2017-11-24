package service.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rest.dto.CompanyFlow;
import service.rest.repository.ICompanyFlowRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CompanyFlowServiceImpl implements CompanyFlowService {

    @Autowired
    private ICompanyFlowRepository companyFlowRepository;

    @Override
    public CompanyFlow findOne(int id) {
        return companyFlowRepository.findOne(id) ;
    }

    public List<CompanyFlow> findAll(){
        return (List<CompanyFlow>) companyFlowRepository.findAll();
    }



}
