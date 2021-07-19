package com.company;

import java.io.Serializable;

public class Card implements Serializable {
    private char value;
    private boolean prediction;

    public Card(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isPrediction() {
        return prediction;
    }

    public void setPrediction(boolean prediction) {
        this.prediction = prediction;
    }
}
