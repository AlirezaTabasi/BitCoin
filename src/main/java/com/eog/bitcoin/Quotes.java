package com.eog.bitcoin;

public class Quotes {
    Quote USD;
    Quote BTC;

    public Quote getUSD() {
        return USD;
    }

    public void setUSD(Quote USD) {
        this.USD = USD;
    }

    public Quote getBTC() {
        return BTC;
    }

    public void setBTC(Quote BTC) {
        this.BTC = BTC;
    }
}
