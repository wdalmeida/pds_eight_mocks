package service.rest.repository;


import org.springframework.data.repository.CrudRepository;
import service.rest.dto.Flows;

public interface IFlowsRepository extends CrudRepository<Flows,Integer> {



}
