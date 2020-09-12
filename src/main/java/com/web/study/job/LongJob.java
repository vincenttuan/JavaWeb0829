package com.web.study.job;

import javax.servlet.AsyncContext;

public class LongJob implements Runnable {
    private AsyncContext ctx;

    public LongJob(AsyncContext ctx) {
        this.ctx = ctx;
    }
    
    @Override
    public void run() {
        
    }
    
}
