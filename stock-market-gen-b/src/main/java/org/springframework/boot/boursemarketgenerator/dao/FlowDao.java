package org.springframework.boot.boursemarketgenerator.dao;


import org.springframework.boot.boursemarketgenerator.model.Flows;

public interface FlowDao {


    void insert(Flows flow);
    void delete(Flows flow);

    Flows getLastFlow();
    void deleteLastFlow();

}
