package com.mycompany.tarea9xlsx;

public class Timer {
    private long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public long stop() {
        return System.currentTimeMillis() - startTime;
    }
}