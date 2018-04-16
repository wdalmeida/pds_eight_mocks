package org.springframework.boot.boursemarketgenerator.model;

import java.math.BigInteger;
import java.util.Date;

public class Company {

  private String Name;

  private Date DateDonnee;

  private double Cours;

  private double Ouverture;

  private double Variation;

  private double Haut;

  private double Bas;

  private int Volume;


  public String getName() {
    return this.Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public Date getDateDonnee() {
    return this.DateDonnee;
  }

  public void setDateDonnee(Date dateDonnee) {
    this.DateDonnee = dateDonnee;
  }

  public double getCours() {
    return this.Cours;
  }

  public void setCours(double cours) {
    this.Cours = cours;
  }

  public double getOuverture() {
    return this.Ouverture;
  }

  public void setOuverture(double ouverture) {
    this.Ouverture = ouverture;
  }

  public double getVariation() {
    return this.Variation;
  }

  public void setVariation(double variation) {
    this.Variation = variation;
  }

  public double getHaut() {
    return this.Haut;
  }

  public void setHaut(double haut) {
    this.Haut = haut;
  }

  public double getBas() {
    return this.Bas;
  }

  public void setBas(double bas) {
    this.Bas = bas;
  }

  public int getVolume() {
    return this.Volume;
  }

  public void setVolume(int volume) {
    this.Volume = volume;
  }

  public Company(){

  }

  public Company(String name, double cours, double ouverture,  double haut, double bas,double variation,Date dateDonnee, int volume) {
    this.Name = name;
    this.Cours = cours;
    this.Ouverture = ouverture;
      this.Haut = haut;
      this.Bas = bas;
    this.Variation = variation;
      this.DateDonnee = dateDonnee;
    this.Volume = volume;
  }

}

