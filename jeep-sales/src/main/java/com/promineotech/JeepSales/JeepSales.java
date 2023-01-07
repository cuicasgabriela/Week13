package com.promineotech.JeepSales;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})

public class JeepSales {

	public static void main(String[] args) {
		// start spring boot
		SpringApplication.run(JeepSales.class, args);
	}

}
