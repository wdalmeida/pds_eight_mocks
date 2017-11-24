package service.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rest.dto.Company;
import service.rest.repository.ICompanyRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public Company findOne(int id) {
        return companyRepository.findOne(id) ;
    }

    public List<Company> findAll(){
        return (List<Company>) companyRepository.findAll();
    }



}
