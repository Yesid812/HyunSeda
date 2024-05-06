package co.hyunseda.product.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity // Indica que esta clase es una entidad JPA
@Table(name="Product") // Define el nombre de la tabla en la base de datos
@Data // Genera automáticamente getters, setters, toString, hashCode y equals
@AllArgsConstructor // Constructor que incluye todos los campos como argumentos
@NoArgsConstructor // Constructor sin argumentos
@Builder // Patrón de diseño para construir objetos de manera más concisa
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // Indica que esta columna es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación de valor automático para la clave primaria
    private Long productId; // Identificador único del producto

    private String name; // Nombre del producto

    private String description; // Descripción del producto

    private int cantidad; // Cantidad disponible del producto

    private double price; // Precio del producto

    @ManyToOne(fetch = FetchType.EAGER) // Relación muchos a uno con la entidad Category, se carga ansiosamente (EAGER)
    @JoinColumn(name = "categoryId") // Nombre de la columna en la tabla de la base de datos para la clave externa
    private Category category; // Categoría a la que pertenece el producto
}
