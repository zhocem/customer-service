package fr.dovi.customerservice;

import fr.dovi.customerservice.entities.Customer;
import fr.dovi.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner start(CustomerRepository customerRepository) {
    return args -> {
      customerRepository.save(new Customer(null, "Cristiano", "CR7@goat.com"));
      customerRepository.save(new Customer(null, "Messi", "Messi@goat.com"));
      customerRepository.save(new Customer(null, "Benzema", "KB9@goat.com"));

      customerRepository.findAll().forEach(c -> System.out.println(c.toString()));
    };
  }

}
