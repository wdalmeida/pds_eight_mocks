package fr.mock.eight.schedule;

import fr.mock.eight.generator.ValueGenerator;
import fr.mock.eight.model.CompanyFlow;
import fr.mock.eight.service.CompanyFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vyach on 26/11/2017.
 */

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private double nextValueId1 = 187.90;
    private double previousValueId1 = 187.90;

    private double nextValueId2 = 43.94;
    private double previousValueId2 = 43.94;

    private double nextValueId3 = 17.85;
    private double previousValueId3 = 17.85;
    

    @Autowired
    private CompanyFlowService companyFlowService;

    private Date initialDate = new Date();
    private Date iterateDate = new Date();
    private Date currentDate;

    private int loop = 0;

    private int row = 1;

    private static final int moins = -1;

    private boolean needPastGeneration = true;


    @Scheduled(fixedDelay = 60000)
    public void reportCurrentTime() {

        CompanyFlow companyFlow1 = new CompanyFlow();
        CompanyFlow companyFlow2 = new CompanyFlow();
        CompanyFlow companyFlow3 = new CompanyFlow();
        currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String dateFormated = dateFormat.format(currentDate);

        //generation of past value one time
        if (needPastGeneration) {
            this.generatePastValue(dateFormat);

            needPastGeneration = false;
        }

        //generation de la valeur en cours
        nextValueId1 = ValueGenerator.generateMarketFlowValue(nextValueId1);
        nextValueId2 = ValueGenerator.generateMarketFlowValue(nextValueId2);
        nextValueId3 = ValueGenerator.generateMarketFlowValue(nextValueId3);

        //generation of value for current time for company id 1
        companyFlow1.setId(row);
        companyFlow1.setDate(currentDate);
        companyFlow1.setDateHour(dateFormated);
        companyFlow1.setFromCurrency("USD");
        companyFlow1.setToCurrency("EUR");
        companyFlow1.setValue(nextValueId1 +"");
        companyFlow1.setCompanyId(1);

        //generation of value for current time for company id 2
        row++;
        companyFlow2.setId(row);
        companyFlow2.setDate(currentDate);
        companyFlow2.setDateHour(dateFormated);
        companyFlow2.setFromCurrency("USD");
        companyFlow2.setToCurrency("EUR");
        companyFlow2.setValue(nextValueId2 +"");
        companyFlow2.setCompanyId(2);

        //generation of value for current time for company id 2
        row++;
        companyFlow3.setId(row);
        companyFlow3.setDate(currentDate);
        companyFlow3.setDateHour(dateFormated);
        companyFlow3.setFromCurrency("USD");
        companyFlow3.setToCurrency("EUR");
        companyFlow3.setValue(nextValueId3 +"");
        companyFlow3.setCompanyId(3);


        row++;

        companyFlowService.insert(companyFlow1);
        companyFlowService.insert(companyFlow2);
        companyFlowService.insert(companyFlow3);


        loop++;

        log.info("loop no : " + loop);
        log.info("initial Date : "+initialDate);
        log.info("current date : "+currentDate);



    }



    private void generatePastValue(SimpleDateFormat dateFormat) {

        CompanyFlow companyFlowId1 = new CompanyFlow();
        CompanyFlow companyFlowId2 = new CompanyFlow();
        CompanyFlow companyFlowId3 = new CompanyFlow();


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
            previousValueId3 = ValueGenerator.generateMarketFlowValue(previousValueId3);


            //mock value of id company 1
            companyFlowId1.setId(row);
            companyFlowId1.setDate(iterateDate);
            companyFlowId1.setDateHour(dateFormated);
            companyFlowId1.setFromCurrency("USD");
            companyFlowId1.setToCurrency("EUR");
            companyFlowId1.setValue(previousValueId1 +"");
            companyFlowId1.setCompanyId(1);

            row++;
            companyFlowId2.setId(row);
            companyFlowId2.setDate(iterateDate);
            companyFlowId2.setDateHour(dateFormated);
            companyFlowId2.setFromCurrency("USD");
            companyFlowId2.setToCurrency("EUR");
            companyFlowId2.setValue(previousValueId2 +"");
            companyFlowId2.setCompanyId(2);

            row++;
            companyFlowId3.setId(row);
            companyFlowId3.setDate(iterateDate);
            companyFlowId3.setDateHour(dateFormated);
            companyFlowId3.setFromCurrency("USD");
            companyFlowId3.setToCurrency("EUR");
            companyFlowId3.setValue(previousValueId3 +"");
            companyFlowId3.setCompanyId(3);

            row++;

            companyFlowService.insert(companyFlowId1);
            companyFlowService.insert(companyFlowId2);
            companyFlowService.insert(companyFlowId3);

        }

    }


}
