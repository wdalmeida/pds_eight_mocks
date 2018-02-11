package service.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rest.dto.Flows;
import service.rest.repository.IFlowsRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class FlowsServiceImpl implements FlowsService {

    private static final Logger log = LoggerFactory.getLogger(FlowsServiceImpl.class);

    @Autowired
    private IFlowsRepository flowRepository;

    @Override
    public Flows findOne(int id) {
        return flowRepository.findOne(id) ;
    }

    public List<Flows> findAll(){
        return (List<Flows>) flowRepository.findAll();
    }

    @Override
    public List<Flows> findCompanyFlowByCompanyCode(String codeCompany) {


        List<Flows> allFlows = new ArrayList<Flows>();

        List<Flows> companyFlows = this.findAll();


        for (int i = 0; i < allFlows.size(); i++) {

            if (allFlows.get(i).getCodeCompany().equals(codeCompany)) {

                companyFlows.add(allFlows.get(i));
            }

        }


        return companyFlows;
    }


}
