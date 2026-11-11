package com.company.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.concurrent.atomic.AtomicLong;

public class EmployeeIdGenerator {

    private static final AtomicLong SEQUENCE = new AtomicLong(1000);
    private final String emailFrom;

    public EmployeeIdGenerator(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    @PostConstruct
    public void init() {
        System.out.println("[EmployeeIdGenerator] Initialised (@PostConstruct, prototype bean)");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[EmployeeIdGenerator] Destroyed (@PreDestroy) -- "
                + "NOTE: for prototype beans this callback is not invoked by the container");
    }

    public String generateReferenceCode() {
        return "EMP-REF-" + SEQUENCE.incrementAndGet() + " (" + emailFrom + ")";
    }
}
