/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.0-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package service.rest.api;

import service.rest.dto.Company;
import service.rest.dto.CompanyFlow;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

@Api(value = "marketflow", description = "the marketflow API")
public interface MarketflowApi {

    @ApiOperation(value = "get the market flow of selected company each minutes from the begining of the year 2017", nickname = "getCompanyCurrentMarketFlow", notes = "", response = CompanyFlow.class, responseContainer = "List", tags={ "Market Flow", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CompanyFlow.class, responseContainer = "List") })
    @RequestMapping(value = "/marketflow/companies/{companyname}/fromcurrency/{fromcurrency}/tocurrency/{tocurrency}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    List<CompanyFlow> getCompanyCurrentMarketFlow(@ApiParam(value = "Company name",required=true) @PathVariable("companyname") String companyname, @ApiParam(value = "initial currency code.",required=true) @PathVariable("fromcurrency") String fromcurrency, @ApiParam(value = "target currency code.",required=true) @PathVariable("tocurrency") String tocurrency);


    @ApiOperation(value = "get the list of all companies on the market", nickname = "getCurrentMarketCompany", notes = "", response = Company.class, responseContainer = "List", tags={ "Market", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Company.class, responseContainer = "List") })
    @RequestMapping(value = "/marketflow/companies",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    List<Company> getCurrentMarketCompany();

}
