package com.example.songscatalog.songsbands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SongsdetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongsdetailsApplication.class, args);
    }

}
