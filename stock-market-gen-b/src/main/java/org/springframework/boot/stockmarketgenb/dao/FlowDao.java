package org.springframework.boot.stockmarketgenb.dao;


import org.springframework.boot.stockmarketgenb.model.Flows;

/**
 * Created by Vyach on 26/01/2018.
 */
public interface FlowDao {


    void insert(Flows flow);
    void delete(Flows flow);

    Flows getLastFlow();
    void deleteLastFlow();

}
