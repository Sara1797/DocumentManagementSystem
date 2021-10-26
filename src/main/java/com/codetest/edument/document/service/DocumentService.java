package com.codetest.edument.document.service;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    // Creating the Logger object to log info about the API
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Importing the document
    @Async
    public void importDocument() {
        // no-op Importing a document
        int randValue = Random(3, 15); // Generating a Random Value between 3 - 15
        sleep(randValue); // Thread sleeps for 3 to 15 seconds making the process 3 - 15 seconds long
    }

    // getting the status of operations
    @Async
    public void getStatus() {

        logger.info("getStatus : Thread name " + Thread.currentThread().getName()); // logging Current Thread Name
        logger.info("Status of the Thread " + Thread.currentThread().getState()); // logging Current Thread State : New,
                                                                                  // Runnable, Blocked, Terminated etc.
        logger.info("State of Internal Queue : " + Thread.activeCount() + " operations running"); // Number of
                                                                                                  // Operations present
                                                                                                  // in the queue
    }

    // Throwing the Interrupted Exception
    public void sleep(int args) {
        try {
            TimeUnit.SECONDS.sleep(args);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Generating Random Numbers Method
    public int Random(int min, int max) {
        int rand = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return rand;

    }

}