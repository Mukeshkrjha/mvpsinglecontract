package com.example.mvpsinglecontract.model;

import android.os.Handler;

import com.example.mvpsinglecontract.presenter.MainContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GetNextPriceInteractorImpl implements MainContract.GetNextPriceInteractor {

    List<String> prices = Arrays.asList("1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000");

    @Override
    public void getNextPrice(final OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFinish("Current Price: "+getPrice());
            }
        }, 1000);
    }

    private String getPrice(){
        Random rand = new Random();
        int index = rand.nextInt(prices.size());
        return prices.get(index);
    }
}
