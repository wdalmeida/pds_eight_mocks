package org.springframework.boot.stockmarketgenb.model;

import java.util.Date;
import java.util.Objects;

public class Flows {

  private static final long serialVersionUID = 1L;


  private int id;

  private Date date;

  private String dateHour;

  private String value;

  private String nameCompany;

  private String codeCompany;

  private String siretCompany;

  public String getSiretCompany() {
    return siretCompany;
  }

  public void setSiretCompany(String siretCompany) {
    this.siretCompany = siretCompany;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public Flows date(Date date) {
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

  public Flows nameCompany(String nameCompany) {
    this.nameCompany = nameCompany;
    return this;
  }



  public String getNameCompany() {
    return nameCompany;
  }

  public void setNameCompany(String nameCompany) {
    this.nameCompany = nameCompany;
  }

  public Flows codeCompany(String codeCompany) {
    this.codeCompany = codeCompany;
    return this;
  }




  public String getCodeCompany() {
    return codeCompany;
  }

  public void setCodeCompany(String codeCompany) {
    this.codeCompany = codeCompany;
  }

  public Flows value(String value) {
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
    Flows companyFlow = (Flows) o;
    return
        Objects.equals(this.date, companyFlow.date) &&
        Objects.equals(this.nameCompany, companyFlow.nameCompany) &&
        Objects.equals(this.codeCompany, companyFlow.codeCompany) &&
        Objects.equals(this.value, companyFlow.value) &&
        Objects.equals(this.siretCompany, companyFlow.siretCompany)
            ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateHour, date, nameCompany, codeCompany, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Flows {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    dateHour: ").append(toIndentedString(dateHour)).append("\n");
    sb.append("    nameCompany: ").append(toIndentedString(nameCompany)).append("\n");
    sb.append("    codeCompany: ").append(toIndentedString(codeCompany)).append("\n");
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

