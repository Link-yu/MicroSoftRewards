package com.example.microsoftrewards.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {
    @Bean(value = "threadPoolInstance")
    public ExecutorService createThreadPoolInstance() {
        //通过guava类库的ThreadFactoryBuilder来实现线程工厂类并设置线程名称
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
    }
}
