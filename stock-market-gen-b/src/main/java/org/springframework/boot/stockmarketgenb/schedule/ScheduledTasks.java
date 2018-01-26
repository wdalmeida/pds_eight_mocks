package org.springframework.boot.stockmarketgenb.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Vyach on 26/01/2018.
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private int i = 0;

    @Scheduled(fixedRate = 5000)
    public void pushData() {

        log.info("boucle " + i);

        i++;

    }

}
