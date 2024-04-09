package com.bankaya.bankayasoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages ={"com.bankaya.core","com.bankaya.bankayasoap" +
        ""})
public class BankayaSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankayaSoapApplication.class, args);
    }

}
