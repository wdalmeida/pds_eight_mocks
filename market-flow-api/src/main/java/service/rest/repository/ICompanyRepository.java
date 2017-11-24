package service.rest.repository;


import org.springframework.data.repository.CrudRepository;
import service.rest.dto.Company;

public interface ICompanyRepository extends CrudRepository<Company,Integer> {



}
