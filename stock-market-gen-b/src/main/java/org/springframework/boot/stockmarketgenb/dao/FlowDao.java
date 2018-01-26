package org.springframework.boot.stockmarketgenb.dao;


import org.springframework.boot.stockmarketgenb.model.Flows;

public interface FlowDao {


    void insert(Flows flow);
    void delete(Flows flow);

    Flows getLastFlow();
    void deleteLastFlow();

}
