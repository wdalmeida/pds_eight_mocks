package service.rest.dto;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CompanyFlow
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

@Entity(name = "companyflow")
public class CompanyFlow {

  @Id
  private int id;

  @ManyToOne
  private Company company = null;

  @Column(name = "date")
  private Date date = null;

  @Column(name = "hour_date")
  private String dateHour = null;

  @Column(name = "fromCurrency")
  private String fromCurrency = null;

  @Column(name = "toCurrency")
  private String toCurrency = null;

  @Column(name = "value")
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



  public CompanyFlow date(Date date) {
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  /**
   * hour of the generate flow
   * @return string
   **/
  @ApiModelProperty(example = "06:22:02", required = true, value = "hour of the generate flow")
  @NotNull

  @Valid
  public String getDateHour() {
    return dateHour;
  }

  public void setDateHour(String dateHour) {
    this.dateHour = dateHour;
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
        Objects.equals(this.date, companyFlow.date) &&
        Objects.equals(this.fromCurrency, companyFlow.fromCurrency) &&
        Objects.equals(this.toCurrency, companyFlow.toCurrency) &&
        Objects.equals(this.value, companyFlow.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, date, fromCurrency, toCurrency, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("CompanyFlow {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
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

