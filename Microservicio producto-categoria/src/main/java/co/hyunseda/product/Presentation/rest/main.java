package co.hyunseda.product.Presentation.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // Anotación que indica que esta clase es la clase principal de la aplicación Spring Boot
@ComponentScan(basePackages = {"co.hyunseda.product"}) // Escanea y registra los componentes (controladores, servicios, etc.) en el paquete especificado
@EntityScan(basePackages = "co.hyunseda.product.domain.entity") // Escanea y registra las entidades JPA en el paquete especificado
@EnableJpaRepositories(basePackages = "co.hyunseda.product.access") // Habilita los repositorios JPA en el paquete especificado
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // Inicia la aplicación Spring Boot
    }
}
