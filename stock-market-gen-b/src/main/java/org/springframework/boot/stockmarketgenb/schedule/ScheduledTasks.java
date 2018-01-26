package org.springframework.boot.stockmarketgenb.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.stockmarketgenb.dao.FlowDaoImpl;
import org.springframework.boot.stockmarketgenb.model.Flows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Vyach on 26/01/2018.
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    JdbcTemplate jdbc;

    private int i = 0;

    @Scheduled(fixedRate = 5000)
    public void pushData() {

        log.info("boucle " + i);




        FlowDaoImpl dao = new FlowDaoImpl(jdbc);

        Flows flow = new Flows();
        flow.setId(i);
        flow.setDateHour("datehour");
        flow.setDate(new Date());
        flow.setCodeCompany("CDE");
        flow.setNameCompany("Nom_company");
        flow.setSiretCompany("siret");
        flow.setValue("12,3");

        dao.insert(flow);

        i++;



    }

}
