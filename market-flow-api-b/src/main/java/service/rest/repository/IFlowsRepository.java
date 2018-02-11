package service.rest.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import service.rest.dto.Flows;

import java.util.List;

public interface IFlowsRepository extends CrudRepository<Flows,Integer> {

    @Query("SELECT flows FROM flows flows ORDER BY flows.date desc")
    List<Flows> findByCompanyByOrderByDateDesc();

}
