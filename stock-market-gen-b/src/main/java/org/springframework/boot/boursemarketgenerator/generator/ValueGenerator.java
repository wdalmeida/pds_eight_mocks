package org.springframework.boot.boursemarketgenerator.generator;

import java.util.Random;

/**
 * Created by Vyach on 27/11/2017.
 */
public class ValueGenerator {


    public static double generateMarketFlowValue(double value) {

        Random rn = new Random();

        double max = 0;
        double min = 0;

        double generatedValue = 0.00;

        int evolution = rn.nextInt(10 - 1 + 1) + 1;

        //positive
        if (evolution > 4) {

            max = value + 0.1;
            generatedValue = value + (max - value) * rn.nextDouble();
        }
        //negative
        else {

            min = value - 0.17;
            generatedValue = min + (value - min) * rn.nextDouble();

        }


        return generatedValue;
    }


}
