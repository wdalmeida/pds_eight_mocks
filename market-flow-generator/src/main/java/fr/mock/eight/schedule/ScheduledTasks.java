package fr.mock.eight.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private Date initialDate = new Date();
    private Date iterateDate = new Date();
    private Date currentDate;

    private int i = 0;
    private int moins = -1;

    @Scheduled(fixedDelay = 60000)
    public void reportCurrentTime() {

        currentDate = new Date();

        log.info("i : " +i);



        log.info("Initial Date : "+initialDate);
        log.info("current date : "+currentDate);


        //set date plus 1 minutes ago
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(iterateDate);
        calendar.add(Calendar.MINUTE, moins);

        iterateDate = calendar.getTime();

        log.info("moins 1min date : "+iterateDate);

        i++;




    }


}
