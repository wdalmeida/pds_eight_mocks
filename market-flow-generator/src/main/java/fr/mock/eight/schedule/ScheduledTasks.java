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

    private double nextValue = 187.90;
    private  double previousValue = 187.90;

    

    @Autowired
    private CompanyFlowService companyFlowService;

    private Date initialDate = new Date();
    private Date iterateDate = new Date();
    private Date currentDate;

    private int loop = 0;

    private int row = 0;

    private static final int moins = -1;


    @Scheduled(fixedDelay = 60000)
    public void reportCurrentTime() {

        CompanyFlow companyFlow = new CompanyFlow();
        currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String dateFormated = dateFormat.format(currentDate);

        row++;

        companyFlow.setId(row);
        companyFlow.setDate(currentDate);
        companyFlow.setDateHour(dateFormated);
        companyFlow.setFromCurrency("USD");
        companyFlow.setToCurrency("EUR");

        nextValue = ValueGenerator.generateMarketFlowValue(nextValue);

        companyFlow.setValue(nextValue+"");
        companyFlow.setCompanyId(1);

        companyFlowService.insert(companyFlow);

        loop++;

        log.info("loop no : " + loop);
        log.info("initial Date : "+initialDate);
        log.info("current date : "+currentDate);

        if (row < 44000) {

            for (int j = 0; j < 1001; j++) {


                //set date plus 1 minutes ago
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(iterateDate);
                calendar.add(Calendar.MINUTE, moins);

                dateFormated = dateFormat.format(iterateDate);

                iterateDate = calendar.getTime();

                row++;

                companyFlow.setId(row);
                companyFlow.setDate(iterateDate);
                companyFlow.setDateHour(dateFormated);
                companyFlow.setFromCurrency("USD");
                companyFlow.setToCurrency("EUR");

                previousValue = ValueGenerator.generateMarketFlowValue(previousValue);

                companyFlow.setValue(previousValue+"");
                companyFlow.setCompanyId(1);

                companyFlowService.insert(companyFlow);

            }

        }


    }


}
