package fr.eight.mock.generator.controller;

import com.opencsv.CSVWriter;
import fr.eight.mock.generator.service.ValuesGenerator;
import fr.eight.mock.generator.utils.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class Generator {

    private static final Logger log = LoggerFactory.getLogger(Generator.class);

    @Autowired
    private Options options;

    private int idCustomer = 1, idAccount = 1, idHistoricPurchase = 1;



    @RequestMapping("/launch")
    public String generateProfils() throws IOException {

        String row = "";

        CSVWriter csvWriter = new CSVWriter(new FileWriter(this.options.getFileName()));
        csvWriter.writeNext(new String[]{"id_customer", "id_account", "id_historic_purchase", "age", "social_cat",
                "familial_status", "childs", "account_type", "is_owner", "balance", "income", "loan_histo", "Y"});
        for (int i = 0; i < options.getProfilsNombre(); i++) {

            int age = ValuesGenerator.generateAge();
            int statusFamilial = ValuesGenerator.generateFamilialStatus();
            int nbrEnfants = ValuesGenerator.generateChilds(age);
            int typeCompte = ValuesGenerator.generateTypeAccount(age);
            int estProprietaire = ValuesGenerator.genereateIsOwner();
            int catSocial = ValuesGenerator.generateSocialCategory(age);
            int solde = ValuesGenerator.generateBalance(catSocial);
            int creditHisto = ValuesGenerator.generateLoanHistory(age);
            int creditCourant = ValuesGenerator.generateCurrentLoan(creditHisto);
            int revenu = ValuesGenerator.generateRevenue(catSocial);


            if (age > 63) { catSocial = 6; }



            //writing in csv process
            csvWriter.writeNext(new String[]{
                    idCustomer+"",
                    idAccount+"",
                    idHistoricPurchase+"",
                    age +"",
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

            //incrementation
            idCustomer++;idAccount++;idHistoricPurchase++;

        }

        csvWriter.close();

        String response = "Generation done !";

        return response;
    }

}
