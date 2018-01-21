package fr.eight.mock.generator.controller;

import com.opencsv.CSVWriter;
import fr.eight.mock.generator.service.ValuesGenerator;
import fr.eight.mock.generator.utils.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TestValuesGenerator {

    @Autowired
    private Options options;

    private int idCustomer = 1, idAccount = 1, idHistoricPurchase = 1;

    @RequestMapping("/createTestValues")
    public String generateProfils() throws IOException {

        String row = "";

        CSVWriter csvWriter = new CSVWriter(new FileWriter(this.options.getTestFileName()));
        csvWriter.writeNext(new String[]{"id_customer", "id_account", "id_historic_purchase", "age", "social_cat",
                "familial_status", "childs", "account_type", "is_owner", "balance", "income", "loan_histo", "Y", "futur_loan"});
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

            int futurLoan = ValuesGenerator.generateFuturLoan(creditHisto, creditCourant, catSocial, revenu, statusFamilial, nbrEnfants, estProprietaire);


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
                    creditCourant+"",
                    futurLoan+""
            });

            //incrementation
            idCustomer++;idAccount++;idHistoricPurchase++;

        }

        csvWriter.close();


        return "Generation is done!";
    }


}
