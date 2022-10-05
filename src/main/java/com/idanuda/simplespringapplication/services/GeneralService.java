package com.idanuda.simplespringapplication.services;

import org.springframework.stereotype.Service;

@Service
public class GeneralService {

    public int getFibunachi (int num, int i, int prevValue, int currValue){

        if (i == num) {
            return currValue;
        }
        else {
            return getFibunachi(num, i+1 , currValue, prevValue + currValue);
        }

    }
}
