package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ExamenBase.Persona;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@PostMapping("/ExamenBase")
	public String nombre(@RequestParam(value = "nombre", defaultValue = "NoNombre") String name,
			@RequestParam(value = "edad", defaultValue = "NoEdad") String edad,
			@RequestParam(value = "sexo", defaultValue = "NoSexo") Character sexo,
			@RequestParam(value = "peso", defaultValue = "NoPeso") String peso,
			@RequestParam(value = "estatura", defaultValue = "NoEst") String estatura) {
		Integer edadInt = Integer.parseInt(edad);
		Double pesoDouble = Double.parseDouble(peso);
		Double estaturaDouble = Double.parseDouble(estatura);
		Persona persona = new Persona(name, edadInt, sexo, pesoDouble, estaturaDouble);
		String mayorDeEdad = (persona.esMayorDeEdad() ? "si":"no");
		return " <ul>\n" + 
				"<li>El IMC de la persona: " + persona.calcularIMC()+"</li>"+
				"<li>Es mayor de edad: " + mayorDeEdad +"</li>"+
				"<li>Información de la persona: " + persona.toString()+"</li>"+
				"</ul>";

	}

	

}
