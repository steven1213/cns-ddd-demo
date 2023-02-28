package com.steven.cns.ddd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dr.panda
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.steven"})
public class DemoDDDApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDDDApplication.class, args);
    }
}
