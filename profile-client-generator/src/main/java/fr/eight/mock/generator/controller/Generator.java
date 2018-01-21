package fr.eight.mock.generator.controller;

import com.opencsv.CSVWriter;
import fr.eight.mock.generator.utils.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Vyach on 18/01/2018.
 */
@RestController
public class Generator {

    private static final Logger log = LoggerFactory.getLogger(Generator.class);

    @Autowired
    private Options options;

    /**
     * Incrementale
     */
    private int idCustomer = 1;

    /**
     * Incrementale
     */
    private int idAccount = 1;

    /**
     * a definir mais semble incrementale
     */
    private int idHistoricPurchase = 1;

    /**
     * est genere : OK
     */
    private int age;

    /**
     *  est genere OK :
     *
     *  1 : sans emploi
     *  2 : etudiant
     *  3 : employe
     *  4 : ouvriers
     *  5 : cadres
     *  6 : retraite
     */
    private int catSocial;

    /**
     * est genere : OK
     *
     *  1 : celibataire
     *  2 : marie
     *  3 : veuf
     *  4 : pacse
     */
    private int statusFamilial;

    /**
     * est genere, 0 < x < 4 : OK
     */
    private int nbrEnfants;

    /**
     * est genere : OK
     *
     *  1 : courant
     *  2 : livret jeune
     *  3 : PEA
     *  4 : PEL
     */
    private int typeCompte;

    /**
     *  est genere : OK
     *
     *  1 : est proprietaire
     *  2 : nest pas proprietaire
     */
    private int estProprietaire;



    /**
     * est genere : OK
     */
    private int solde;

    /**
     *  1 : sans emploi
     *  2 : etudiant
     *  3 : employe
     *  4 : ouvriers
     *  5 : cadres
     *  6 : retraite
     * @return
     */


    /**
     * est genere : OK
     */
    private int revenu;

    /**
     * est genere
     */
    private int creditHisto;



    /**
     * est genere
     */
    private int creditCourant;




    @RequestMapping("/launch")
    public String generateProfils() throws IOException {

        String response = "The generator is running...";
        String row = "";

        CSVWriter csvWriter = new CSVWriter(new FileWriter(this.options.getFileName()));
        csvWriter.writeNext(new String[]{"id_customer", "id_account", "id_historic_purchase", "age", "social_cat",
                "familial_status", "childs", "account_type", "is_owner", "balance", "income", "loan_histo", "Y"});
        for (int i = 0; i < options.getProfilsNombre(); i++) {

            //generation of age
            this.age = this.ageGeneration();
            //generation of familial status
            this.statusFamilial = this.setFamilialStatus();
            //generation of childs
            this.nbrEnfants = this.setChilds();
            //generation of type account
            this.typeCompte = this.getTypeAccount();

            this.estProprietaire = this.setOwner();

            this.catSocial = this.genSocialCat();

            this.solde = this.setSolde();

            this.creditHisto = this.generateHistoCredit();

            this.creditCourant = this.generateCurrentCredit();


            if (age > 63) { catSocial = 6; }
            revenu = this.calculateRevenu();


            //writing in csv process
            csvWriter.writeNext(new String[]{
                    idCustomer+"",
                    idAccount+"",
                    idHistoricPurchase+"",
                    age+"",
                    catSocial+"",
                    statusFamilial+"",
                    nbrEnfants+"",
                    typeCompte+"",
                    estProprietaire+"",
                    solde+"",
                    revenu+"",
                    creditHisto+"",
                    creditCourant+""
            });

            //incrémentation
            idCustomer++;idAccount++;idHistoricPurchase++;

        }

        csvWriter.close();

        response="Generation done !";

        return response;
    }


    private int ageGeneration() {

        Random rn = new Random();

        int nextAge = rn.nextInt(88 - 18 + 1) + 18;

        return nextAge;
    }

    /**
     *  est genere :
     *
     *  1 : sans emploi  11%
     *  2 : etudiant  22%
     *  3 : employe  24%
     *  4 : ouvriers 17%
     *  5 : cadres 9%
     *  6 : retraite 16%
     */
    private int genSocialCat() {

        Random rn = new Random();

        int ratio = rn.nextInt(100 - 0 + 1) + 0;

        log.info("ratio : " + ratio);

        int catSocial = 6;

        if (ratio < 100) {
            catSocial = 6;
        }
        if (ratio < 83) {
            catSocial = 5;
        }
        if (ratio < 74) {
            catSocial = 4;
        }
        if (ratio < 57) {
            catSocial = 3;
        }
        if (ratio < 33) {
            catSocial = 2;
        }
        if (ratio < 11) {
            catSocial = 1;
        }


        return catSocial;

    }

    private int getTypeAccount() {

        int nextAccountType = this.typeCompte;

        Random rn = new Random();


        if (age < 26) {
            int ratio = rn.nextInt(10 - 0 + 1) + 10;

            if (ratio > 4) {
                nextAccountType = 2;
            }

        }
        else {
            int ratio = rn.nextInt(101);

            if (ratio < 101) {
                nextAccountType = 1;
            }
            if (ratio < 56) {
                nextAccountType = 3;
            }
            if (ratio < 39) {
                nextAccountType = 4;
            }
        }

        return nextAccountType;
    }

    /**
     *  1 : sans emploi
     *  2 : etudiant
     *  3 : employe
     *  4 : ouvriers
     *  5 : cadres
     *  6 : retraite
     * @return
     */
    private int calculateRevenu() {

        Random rn = new Random();

        int revenue = 0;

        if (catSocial == 2) {
            revenue = rn.nextInt(1200 - 600 + 1) + 600;
            revenue = revenue - 100;
        }
        else if (catSocial == 3) {
            revenue = rn.nextInt(2000 - 1200 + 1) + 1200;
            revenue = revenue + 300;
        }
        else if (catSocial == 4) {
            revenue = rn.nextInt(1900 - 1000 + 1) + 1000;
            revenue = revenue - 150;
        }
        else if (catSocial == 5) {
            revenue = rn.nextInt(2600 - 1800 + 1) + 1800;
            revenue = revenue + 600;
        }
        else if (catSocial == 6) {
            revenue = rn.nextInt(1200 - 700 + 1) + 700;
            revenue = revenue - 200;
        }

        return revenue;

    }

    private int setFamilialStatus() {

        int familialStatus = 1;

        Random rn = new Random();

        int ratio = rn.nextInt(100 - 0 + 1) + 0;

        if(ratio < 100) {
            familialStatus = 4;
        }
        if(ratio < 86) {
            familialStatus = 3;
        }
        if(ratio < 79) {
            familialStatus = 2;
        }
        if (ratio < 33) {
            familialStatus = 1;
        }

        return familialStatus;
    }


    private int setChilds() {

        Random rn = new Random();

        int childs = rn.nextInt(4 - 0 + 1) + 1;

        return childs;
    }

    private int setOwner() {

        int isOwner = 1;
        Random rn = new Random();

        int ratio = rn.nextInt(101);

        if (ratio > 39) {
            isOwner = 0;
        }

        return isOwner;
    }

    private int setSolde() {

        Random rn = new Random();
        int solde = 0;

        if (catSocial == 1 || catSocial == 2 || catSocial == 6) {

            int ratio = rn.nextInt(10 - 0 + 1) + 0;

            if (ratio < 3) {
                solde = rn.nextInt(2001);
                solde = -solde;
            }
            else {
                solde = rn.nextInt(3000 - 0 + 1) + 0;
            }
        }
        else if(catSocial == 3 ||catSocial == 4) {
            int ratio = rn.nextInt(10 - 0 + 1) + 0;

            if (ratio < 2) {
                solde = rn.nextInt(2001);
                solde = -solde;
            }
            else {
                solde = rn.nextInt(5000 - 0 + 1) + 0;
            }
        }
        else if(catSocial == 5) {
            solde = rn.nextInt(7000 - 1500 + 1) + 1500;
        }

        return solde;
    }

    private int  generateHistoCredit() {
        Random rn = new Random();

        int histoCredit = 0;
        int ratio = histoCredit = rn.nextInt(101);

        if (ratio > 95) {
            histoCredit = 0;
        }
        else {
            histoCredit = rn.nextInt(1001);
        }

        return  histoCredit;
    }

    private int generateCurrentCredit() {

        int credit = 0;

        Random rn = new Random();

        int ratio = rn.nextInt(101);

        if (ratio > 88) {
            credit = 0;
        }
        else {
            credit = (this.creditHisto / 2) + 100;
        }

        return credit;

    }
}
