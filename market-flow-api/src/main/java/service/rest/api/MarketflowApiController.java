package service.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import service.rest.dto.Company;
import service.rest.dto.CompanyFlow;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.rest.repository.ICompanyFlowRepository;
import service.rest.service.CompanyFlowService;
import service.rest.service.CompanyService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

@RestController
public class MarketflowApiController implements MarketflowApi {

    private static final Logger log = LoggerFactory.getLogger(MarketflowApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private CompanyService companyService;

    //@Autowired
    //private CompanyFlowService companyFlowService;

    @Autowired
    private ICompanyFlowRepository companyFlowRepo;

    @Autowired
    public MarketflowApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public List<CompanyFlow> getCompanyCurrentMarketFlow(@ApiParam(value = "Company code",required=true)
                                                                            @PathVariable("companycode") String companyCode,
                                                                         @ApiParam(value = "initial currency code.",required=true)
                                                                            @PathVariable("fromcurrency") String fromcurrency,
                                                                         @ApiParam(value = "target currency code.",required=true)
                                                                            @PathVariable("tocurrency") String tocurrency) {

        List<CompanyFlow> listCompanyFlow = null;
        List<CompanyFlow> finalListCompanyFlow = new ArrayList<CompanyFlow>();

        if (fromcurrency.equals("USD") && tocurrency.equals("EUR")) {

            int companyId = this.getCompanyCode(companyCode);

            Company currentCompany = this.companyService.findOne(companyId);

            //listCompanyFlow = this.companyFlowService.findCompanyFlowByCompany(currentCompany);

            listCompanyFlow = companyFlowRepo.findByCompanyByOrderByDateDesc();


            for(int i = 0; i < listCompanyFlow.size(); i++) {

                if (currentCompany.equals(listCompanyFlow.get(i).getCompany())) {
                    finalListCompanyFlow.add(listCompanyFlow.get(i));
                }
            }



        }

        return finalListCompanyFlow;


    }

    public List<Company> getMarketCompanies() {

        log.debug("CONTROLLER : getCurrentMarketCompany");

        List<Company> listCompany = companyService.findAll();

        return listCompany;


    }


    @Override
    public Company getMarketCompany(@ApiParam(value = "Company code",required=true)
                                        @PathVariable("companycode") String companyCode) {

        int companyId = this.getCompanyCode(companyCode);

        return companyService.findOne(companyId);
    }


    private int getCompanyCode(String companyName) {

        int companyId = 0;
        if (companyName.equals("OR")) {
            companyId = 1;
        }
        else if (companyName.equals("GLE")) {
            companyId = 2;
        }
        else if (companyName.equals("CA")) {
            companyId = 3;
        }

        return companyId;

    }

}
