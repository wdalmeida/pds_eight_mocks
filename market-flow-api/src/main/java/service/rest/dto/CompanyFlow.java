package service.rest.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CompanyFlow
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

public class CompanyFlow {
  @JsonProperty("company")
  private Company company = null;

  @JsonProperty("idFlow")
  private String idFlow = null;

  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("fromCurrency")
  private String fromCurrency = null;

  @JsonProperty("toCurrency")
  private String toCurrency = null;

  @JsonProperty("value")
  private String value = null;

  public CompanyFlow company(Company company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public CompanyFlow idFlow(String idFlow) {
    this.idFlow = idFlow;
    return this;
  }

   /**
   * unique id of the flow
   * @return idFlow
  **/
  @ApiModelProperty(example = "123456789", required = true, value = "unique id of the flow")
  @NotNull


  public String getIdFlow() {
    return idFlow;
  }

  public void setIdFlow(String idFlow) {
    this.idFlow = idFlow;
  }

  public CompanyFlow date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * date of the generate flow
   * @return date
  **/
  @ApiModelProperty(example = "01/03/17 hh:mm:ss", required = true, value = "date of the generate flow")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public CompanyFlow fromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
    return this;
  }

   /**
   * initial currency code.
   * @return fromCurrency
  **/
  @ApiModelProperty(example = "USD", required = true, value = "initial currency code.")
  @NotNull


  public String getFromCurrency() {
    return fromCurrency;
  }

  public void setFromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
  }

  public CompanyFlow toCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
    return this;
  }

   /**
   * target currency code.
   * @return toCurrency
  **/
  @ApiModelProperty(example = "EUR", required = true, value = "target currency code.")
  @NotNull


  public String getToCurrency() {
    return toCurrency;
  }

  public void setToCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
  }

  public CompanyFlow value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(example = "1.1791", required = true, value = "")
  @NotNull


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompanyFlow companyFlow = (CompanyFlow) o;
    return Objects.equals(this.company, companyFlow.company) &&
        Objects.equals(this.idFlow, companyFlow.idFlow) &&
        Objects.equals(this.date, companyFlow.date) &&
        Objects.equals(this.fromCurrency, companyFlow.fromCurrency) &&
        Objects.equals(this.toCurrency, companyFlow.toCurrency) &&
        Objects.equals(this.value, companyFlow.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, idFlow, date, fromCurrency, toCurrency, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompanyFlow {\n");
    
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    idFlow: ").append(toIndentedString(idFlow)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    fromCurrency: ").append(toIndentedString(fromCurrency)).append("\n");
    sb.append("    toCurrency: ").append(toIndentedString(toCurrency)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

