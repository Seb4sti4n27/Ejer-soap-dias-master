
package com.example.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.wsdl.GetDiasResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(DiasClient quoteClient) {
		return args -> {
			String dia = "lunes";

			if (args.length > 0) {
				dia = args[0];
			}
			GetDiasResponse response = quoteClient.getDia(dia);
			System.err.println("===================================");
			System.err.println("===================================");
			System.err.println(response.getDia().getName());
			System.err.println(response.getDia().getTraduccion());
			System.err.println("===================================");
			System.err.println("===================================");
		};
	}

}
