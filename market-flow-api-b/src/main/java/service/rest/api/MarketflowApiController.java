package service.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.rest.dto.Flows;
import service.rest.repository.IFlowsRepository;
import service.rest.service.FlowsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

@RestController
public class MarketflowApiController implements MarketflowApi {

    private static final Logger log = LoggerFactory.getLogger(MarketflowApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private FlowsService companyService;

    //@Autowired
    //private FlowsService companyFlowService;

    @Autowired
    private IFlowsRepository flowsRepo;

    @Autowired
    public MarketflowApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public List<Flows> getCompanyCurrentMarketFlow(
            @ApiParam(value = "Company code",required=true)
            @PathVariable("companycode")
                    String companyCode) {

        List<Flows> listCompanyFlows = null;
        List<Flows> finalListCompanyFlow = new ArrayList<Flows>();

        log.info("company code : " + companyCode);
        //on verifie que le code envoye est traite par l'api
        //if (CodeCompany.contains(companyCode)) {


        listCompanyFlows = flowsRepo.findByCompanyByOrderByDateDesc();


        for(int i = 0; i < listCompanyFlows.size(); i++) {

            log.info("company flow no" + i + " is : " + listCompanyFlows.get(i));

            if (listCompanyFlows.get(i).getCodeCompany().equals(companyCode)) {
                finalListCompanyFlow.add(listCompanyFlows.get(i));
            }
        }
        return finalListCompanyFlow;

    }
}
