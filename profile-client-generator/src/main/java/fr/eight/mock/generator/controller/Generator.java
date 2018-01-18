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
     * est genere
     */
    private int age;

    /**
     *  est genere :
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
     * est genere :
     *
     *  1 : celibataire
     *  2 : marie
     *  3 : veuf
     *  4 : pacse
     */
    private int statusFamilial;

    /**
     * est genere, 0 < x < 4
     */
    private int nbrEnfants;

    /**
     * est genere :
     *
     *  1 : courant
     *  2 : livret jeune
     *  3 : PEA
     *  4 : PEL
     */
    private int typeCompte;

    /**
     *  est genere :
     *
     *  1 : est proprietaire
     *  2 : nest pas proprietaire
     */
    private boolean estProprietaire;

    /**
     * est genere
     */
    private int solde;

    /**
     * est genere
     */
    private int revenu;

    /**
     * est genere
     */
    private int creaditHisto;

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
                    creaditHisto+"",
                    creditCourant+""
            });

            //incrémentation
            idCustomer++;idAccount++;idHistoricPurchase++;

        }

        csvWriter.close();

        response="Generation done !";

        return response;
    }
}
