package org.springframework.boot.boursemarketgenerator.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.boursemarketgenerator.dao.CompanyDaoImpl;
import org.springframework.boot.boursemarketgenerator.generator.DoubleGenerator;
import org.springframework.boot.boursemarketgenerator.model.Company;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Component
public class TasksBourseMarket {

    private static final Logger log = LoggerFactory.getLogger(TasksBourseMarket.class);

    @Autowired
    private JdbcTemplate jdbc;

    private CompanyDaoImpl dao;

    @Scheduled(fixedRate = 1)
    public void pushData() {

        dao = new CompanyDaoImpl(jdbc);


        ArrayList entreprises = new ArrayList() {{
            add("ACCORHOTELS");
            add("AIR LIQUIDE");
            add("AIRBUS GROUP (EX-EADS)");
            add("ARCELORMITTAL");
            add("ATOS");
            add("AXA");
            add("BNP PARIBAS");
            add("BOUYGUES");
            add("CAPGEMINI");
            add("CARREFOUR");
            add("CREDIT AGRICOLE");
            add("DANONE");
            add("ENGIE (EX GDF SUEZ)");
            add("ESSILOR INTERNATIONAL");
            add("KERING (EX-PPR)");
            add("LAFARGEHOLCIM");
            add("LEGRAND");
            add("L'OREAL");
            add("LVMH MICHELIN");
            add("ORANGE");
            add("PERNOD RICARD");
            add("PSA GROUPE (EX-PEUGEOT)");
            add("PUBLICIS");
            add("RENAULT");
            add("SAFRAN");
            add("SAINT-GOBAIN");
            add("SANOFI");
            add("SCHNEIDER ELECTRIC");
            add("SOCIETE GENERALE");
            add("SODEXO");
            add("SOLVAY");
            add("STMICROELECTRONICS");
            add("TECHNIPFMC");
            add("TOTAL");
            add("UNIBAIL-RODAMCO");
            add("VALEO");
            add("VEOLIA ENVIRONNEMENT");
            add("VINCI");
            add("VIVENDI");
        }};

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        //définir le format de la date
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        //String dateStr = df.format(new Date());
        int annee = 2014;
        int incr = -1;

        while (calendar.YEAR != annee) {
            calendar.add(Calendar.DATE, incr);
            for (int i = 0; i < entreprises.size(); i++) {
                    double ouverture = DoubleGenerator.generateOuverture();
                    double bas = DoubleGenerator.generateBas(ouverture);
                    double haut = DoubleGenerator.generateHaut(ouverture, bas);
                    double cours = DoubleGenerator.generateCours(ouverture);
                    double variation = DoubleGenerator.generateVariation(ouverture, cours);
                    int volume = DoubleGenerator.generateVolume();
                    Date dateDonnee = calendar.getTime();
                    log.info("ouvertue" + ouverture);

                    Company company = new Company();
                    String name = entreprises.get(i).toString();

                    company.setName(name);
                    company.setCours(cours);
                    company.setOuverture(ouverture);
                    company.setHaut(haut);
                    log.info("haut" + haut);
                    company.setBas(bas);
                    log.info("bas" + bas);
                    company.setVariation(variation);
                    company.setDateDonnee(dateDonnee);
                    log.info("variation" + variation);

                    log.info("nom" + name);
                    company.setVolume(volume);
                    log.info("volume" + volume);

                    dao.insert(company);

            }
        }
    }
}
