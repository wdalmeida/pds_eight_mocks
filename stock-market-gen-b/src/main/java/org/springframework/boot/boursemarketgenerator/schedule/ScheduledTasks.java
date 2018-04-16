package org.springframework.boot.boursemarketgenerator.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.boursemarketgenerator.dao.FlowDaoImpl;
import org.springframework.boot.boursemarketgenerator.generator.ValueGenerator;
import org.springframework.boot.boursemarketgenerator.model.Flows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private JdbcTemplate jdbc;

    private FlowDaoImpl dao;

    private double nextValueId1 = 187.90;
    private double previousValueId1 = 187.90;

    private double nextValueId2 = 43.94;
    private double previousValueId2 = 43.94;

    private Date initialDate = new Date();
    private Date iterateDate = new Date();
    private Date currentDate;

    private int loop = 0;

    private int row = 1;

    private static final int moins = -1;

    private boolean needPastGeneration = true;

    @Scheduled(fixedRate = 60000)
    public void pushData() {


        dao = new FlowDaoImpl(jdbc);

        Flows flowA = new Flows();
        Flows flowB = new Flows();

        currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String dateFormated = dateFormat.format(currentDate);

        //generation of past value one time
        if (needPastGeneration) {
            this.generatePastValue(dateFormat, dao);

            needPastGeneration = false;
        }

        //generation de la valeur en cours
        nextValueId1 = ValueGenerator.generateMarketFlowValue(nextValueId1);
        nextValueId2 = ValueGenerator.generateMarketFlowValue(nextValueId2);

        //generation of value for current time for company a
        flowA.setId(row);
        flowA.setDate(currentDate);
        flowA.setDateHour(dateFormated);
        flowA.setValue(nextValueId1 +"");
        flowA.setNameCompany("LVMH MOET VUITTON");
        flowA.setCodeCompany("MC");
        flowA.setSiretCompany("77567041700051");

        //generation of value for current time for company b
        row++;
        flowB.setId(row);
        flowB.setDate(currentDate);
        flowB.setDateHour(dateFormated);
        flowB.setValue(nextValueId2 +"");
        flowB.setNameCompany("KERING");
        flowB.setCodeCompany("KER");
        flowB.setSiretCompany("55207502000594");

        row++;

        dao.insert(flowA);
        dao.insert(flowB);


        loop++;

        log.info("loop no : " + loop);
        log.info("initial Date : "+initialDate);
        log.info("current date : "+currentDate);


        /* delete 2 last company flow entry */

        dao.deleteLastFlow();
        dao.deleteLastFlow();

    }

    private void generatePastValue(SimpleDateFormat dateFormat, FlowDaoImpl dao) {

        Flows flowA = new Flows();
        Flows flowB = new Flows();


        //generation de de donnees sur les 60 minutes passees
        for (int j = 0; j < 60; j++) {


            //set date plus 1 minutes ago
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(iterateDate);
            calendar.add(Calendar.MINUTE, moins);

            String dateFormated = dateFormat.format(iterateDate);

            iterateDate = calendar.getTime();

            previousValueId1 = ValueGenerator.generateMarketFlowValue(previousValueId1);
            previousValueId2 = ValueGenerator.generateMarketFlowValue(previousValueId2);


            //mock value of id company 1
            flowA.setId(row);
            flowA.setDate(iterateDate);
            flowA.setDateHour(dateFormated);
            flowA.setValue(previousValueId1 +"");
            flowA.setNameCompany("LVMH MOET VUITTON");
            flowA.setCodeCompany("MC");
            flowA.setSiretCompany("77567041700051");

            row++;
            flowB.setId(row);
            flowB.setDate(iterateDate);
            flowB.setDateHour(dateFormated);
            flowB.setValue(previousValueId2 +"");
            flowB.setNameCompany("KERING");
            flowB.setCodeCompany("KER");
            flowB.setSiretCompany("55207502000594");

            row++;

            dao.insert(flowA);
            dao.insert(flowB);

        }

    }

}
