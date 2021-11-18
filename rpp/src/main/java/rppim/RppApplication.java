package rppim;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RppApplication.class, args);
	}

	@Bean  //ovom anotacijom smo zadali da se kreira bean za commandLineRunner i da se ova metoda pokrene prilikom pokretanja aplikacije
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) { //ova metoda ce ispistati tekst od dole
		return args ->{
			System.out.println("Beans provided by Spring Boot:"); //ispisuje ovo
			String[] beanNames = ctx.getBeanDefinitionNames(); //ova metoda vraca sve beanove i smesta ih u niz stingova
			Arrays.sort(beanNames); //pozivamo sort iz klase arrays da sortiramo ih po abecedi
			for(String beanName: beanNames) { //sa petljom for prolazimo kroz niz
				System.out.println(beanName); //ispisujemo ovaj niz
			}
		};
	}
	
}
