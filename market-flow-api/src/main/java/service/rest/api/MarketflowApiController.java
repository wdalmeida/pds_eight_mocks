package service.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.rest.dto.Company;
import service.rest.dto.CompanyFlow;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.rest.service.CompanyService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

@RestController
public class MarketflowApiController implements MarketflowApi {

    private static final Logger log = LoggerFactory.getLogger(MarketflowApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private CompanyService companyService;

    @Autowired
    public MarketflowApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<CompanyFlow>> getCompanyCurrentMarketFlow(@ApiParam(value = "Company name",required=true)
                                                                            @PathVariable("companyname") String companyname,
                                                                         @ApiParam(value = "initial currency code.",required=true)
                                                                            @PathVariable("fromcurrency") String fromcurrency,
                                                                         @ApiParam(value = "target currency code.",required=true)
                                                                            @PathVariable("tocurrency") String tocurrency) {

        if (companyname.equals("OR") && fromcurrency.equals("USD") && tocurrency.equals("EUR")) {
            try {
                return new ResponseEntity<List<CompanyFlow>>(objectMapper.readValue("[ {  \"date\" : \"01/03/17 hh:mm:ss\",  \"toCurrency\" : \"EUR\",  \"idFlow\" : \"123456789\",  \"company\" : {    \"code\" : \"OR\",    \"name\" : \"L'Oreal\",    \"siret\" : \"88673234219\"  },  \"fromCurrency\" : \"USD\",  \"value\" : \"1.1791\"}, {  \"date\" : \"01/03/17 hh:mm:ss\",  \"toCurrency\" : \"EUR\",  \"idFlow\" : \"123456789\",  \"company\" : {    \"code\" : \"OR\",    \"name\" : \"L'Oréal\",    \"siret\" : \"88673234219\"  },  \"fromCurrency\" : \"USD\",  \"value\" : \"1.1791\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CompanyFlow>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CompanyFlow>>(HttpStatus.BAD_REQUEST);


    }

    public List<Company> getCurrentMarketCompany() {

        log.debug("CONTROLLER : getCurrentMarketCompany");

        List<Company> listCompany = companyService.findAll();

        return listCompany;


    }

}
