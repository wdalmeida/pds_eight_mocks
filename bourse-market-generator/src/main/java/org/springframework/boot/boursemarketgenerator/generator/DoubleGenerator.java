package org.springframework.boot.boursemarketgenerator.generator;


import java.util.Random;

public class DoubleGenerator {

    public static double generateOuverture(){
        Random rn = new Random();
        //Valeurs max et min (inclus)
        double max=20.00;
        double min=500.00;
        //Ton nombre aléatoire
        double ouverture = (double)(Math.random()*(max-min))+ min;
        return ouverture;
    }

    public static double generateBas(double ouverture){
        Random rn = new Random();
        //Valeurs max et min (inclus)
        double max=-12.99;
        double min=-0.1;
        //Ton nombre aléatoire
        double nbalea = (double)(Math.random()*(max-min))+min;
        double bas= ouverture-nbalea;
        return bas;
    }

    public static double  generateHaut(double ouverture, double bas){
        Random rn = new Random();
        //Valeurs max et min (inclus)
        double max=12.99;
        double min=0.1;
        //Ton nombre aléatoire
        double nbalea = (double)(Math.random()*(max-min))+min;
        double haut1= ouverture-nbalea;
        if (haut1 >=bas){
            double haut= haut1;
            return haut;
        }
        else{
           double haut2= bas-haut1;
          double haut= haut1+haut2+1.1;
          return haut;
        }



    }

    public static double generateCours(double ouverture){
        Random rn = new Random();
        //Valeurs max et min (inclus)
        double max=2.00;
        double min=-2.00;
        //Ton nombre aléatoire
        double nbalea = (double)(Math.random()*(max-min))+min;
        if (nbalea >0){
           double cours=ouverture+nbalea;
            return cours;
        }
        double cours=ouverture-nbalea;
        return cours;
    }

    public static double generateVariation(double ouverture, double cours){
        double variation = ((cours-ouverture)/ouverture)*100;
        return variation;
    }

    public  static int generateVolume(){
        //Valeurs max et min (inclus)
       int max=100000;
        int min=1000;
        //Ton nombre aléatoire
        int nbAlea = (int)(Math.random()*(max-min))+min;
       int valuevolume= nbAlea;

        return valuevolume;
    }
}
