package com.suntech.stapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamApiImplementationProApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamApiImplementationProApplication.class, args);
	}
 @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            System.out.println("In CommandLineRunnerImpl ");

            for (String arg : args) {
                System.out.println(arg);
            }
        };
    }
}
