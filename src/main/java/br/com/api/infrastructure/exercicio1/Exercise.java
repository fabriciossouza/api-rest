package br.com.api.infrastructure.exercicio1;

import java.util.*;

public class Exercise {

    public static int NUMBER_MAX = 100000000;

    public static Integer getBiggestBrother(Integer number){
        Iterator<String> iterator = new StringPermutation(String.valueOf(number)).iterator();

        Integer biggerValue = 0;
        while (iterator.hasNext()){
            Integer value = Integer.valueOf(iterator.next());
            if(value > biggerValue){
                biggerValue = value;
            }
        }
        if(biggerValue > NUMBER_MAX){
            return -1;
        }
        return biggerValue;
    }
}
