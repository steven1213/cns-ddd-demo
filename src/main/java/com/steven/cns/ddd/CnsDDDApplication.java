package com.steven.cns.ddd;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author steven.cao
 */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.steven.cns.ddd.domain"})
@ComponentScan(basePackages = {"com.steven"})
public class CnsDDDApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnsDDDApplication.class, args);
    }
}
