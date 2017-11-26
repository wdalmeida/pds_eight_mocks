package fr.mock.eight.schedule;

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

    private static final SimpleDateFormat dateHourFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private CompanyFlowService companyFlowService;

    private Date initialDate = new Date();
    private Date iterateDate = new Date();
    private Date currentDate;

    private int loop = 0;

    private int row = 0;


    @Scheduled(fixedDelay = 60000)
    public void reportCurrentTime() {

        CompanyFlow companyFlow = new CompanyFlow();
        currentDate = new Date();

        row++;

        companyFlow.setId(row);
        companyFlow.setDate(currentDate);
        companyFlow.setDateHour("22:42:22");
        companyFlow.setFromCurrency("USD");
        companyFlow.setToCurrency("EUR");
        companyFlow.setValue("88,32");
        companyFlow.setCompanyId(1);

        companyFlowService.insert(companyFlow);



        int moins = -1;



        loop++;

        log.info("loop no : " + loop);
        log.info("initial Date : "+initialDate);
        log.info("current date : "+currentDate);


        for (int j = 0; j < 1001; j++) {


            //set date plus 1 minutes ago
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(iterateDate);
            calendar.add(Calendar.MINUTE, moins);

            iterateDate = calendar.getTime();

            row++;

            companyFlow.setId(row);
            companyFlow.setDate(iterateDate);
            companyFlow.setDateHour("22:42:22");
            companyFlow.setFromCurrency("USD");
            companyFlow.setToCurrency("EUR");
            companyFlow.setValue("88,32");
            companyFlow.setCompanyId(1);

            companyFlowService.insert(companyFlow);



        }

    }


}
