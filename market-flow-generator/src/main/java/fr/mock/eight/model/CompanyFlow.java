package fr.mock.eight.model;


import java.util.Date;
import java.util.Objects;


public class CompanyFlow {

  private static final long serialVersionUID = 1L;


  private int id;


  private int companyId = 0;

  private Date date = null;

  private String dateHour = null;

  private String fromCurrency = null;

  private String toCurrency = null;

  private String value = null;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCompanyId() {
    return companyId;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
  }



  public CompanyFlow date(Date date) {
    this.date = date;
    return this;
  }


  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


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


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompanyFlow companyFlow = (CompanyFlow) o;
    return Objects.equals(this.companyId, companyFlow.companyId) &&
        Objects.equals(this.date, companyFlow.date) &&
        Objects.equals(this.fromCurrency, companyFlow.fromCurrency) &&
        Objects.equals(this.toCurrency, companyFlow.toCurrency) &&
        Objects.equals(this.value, companyFlow.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId, dateHour, date, fromCurrency, toCurrency, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("CompanyFlow {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    company: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    dateHour: ").append(toIndentedString(dateHour)).append("\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

