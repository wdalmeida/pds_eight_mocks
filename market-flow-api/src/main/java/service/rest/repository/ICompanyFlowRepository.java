package service.rest.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import service.rest.dto.Company;
import service.rest.dto.CompanyFlow;

import java.util.List;

@Repository
public interface ICompanyFlowRepository extends CrudRepository<CompanyFlow,Integer> {


    @Query("SELECT companyflow FROM companyflow companyflow order by companyflow.date desc")
    List<CompanyFlow> findByCompanyByOrderByDateDesc();

}
