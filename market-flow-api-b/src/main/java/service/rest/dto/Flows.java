package service.rest.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity(name = "flows")
public class Flows {

  private static final long serialVersionUID = 1L;

  @Id
  private int id;

  @Column(name = "date")
  private Date date;

  @Column(name = "hour_date")
  private String dateHour;

  @Column(name = "value")
  private String value;

  @Column(name = "name_company")
  private String nameCompany;

  @Column(name = "code_company")
  private String codeCompany;

  @Column(name = "siret_company")
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
    sb.append("    siretCompany: ").append(toIndentedString(siretCompany)).append("\n");
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

