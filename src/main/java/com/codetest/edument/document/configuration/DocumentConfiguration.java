package com.codetest.edument.document.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//Configuration Class for setting the thread configurations
@Configuration
public class DocumentConfiguration extends AsyncConfigurerSupport {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2); // Min Number of threads
        taskExecutor.setMaxPoolSize(5); // Max Number of Threads
        taskExecutor.setQueueCapacity(2);
        taskExecutor.setThreadNamePrefix("Document Thread-");
        taskExecutor.setThreadGroupName("Document Thread");
        taskExecutor.initialize();
        return taskExecutor;
    }
}