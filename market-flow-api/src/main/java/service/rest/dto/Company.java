package service.rest.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * Company
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T21:59:27.635+01:00")

@Entity(name = "company")
public class Company {

  @Id
  private int id;

  @Column(name = "name")
  private String name = null;

  @Column(name = "code")
  private String code = null;

  @Column(name = "siret")
  private String siret = null;

  public Company name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the company
   * @return name
  **/
  @ApiModelProperty(example = "L'Oreal", required = true, value = "Name of the company")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Company code(String code) {
    this.code = code;
    return this;
  }

   /**
   * company code
   * @return code
  **/
  @ApiModelProperty(example = "OR", required = true, value = "company code")
  @NotNull
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }



  public Company siret(String siret) {
    this.siret = siret;
    return this;
  }

   /**
   * siret number of the company
   * @return siret
  **/
  @ApiModelProperty(example = "88673234219", required = true, value = "siret number of the company")
  @NotNull


  public String getSiret() {
    return siret;
  }

  public void setSiret(String siret) {
    this.siret = siret;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(this.name, company.name) &&
        Objects.equals(this.code, company.code) &&
        Objects.equals(this.siret, company.siret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, code, siret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Company {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    siret: ").append(toIndentedString(siret)).append("\n");
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

