package co.hyunseda.product.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, hashCode y equals
@Entity // Indica que esta clase es una entidad JPA
@Table(name="Category") // Define el nombre de la tabla en la base de datos
@AllArgsConstructor // Constructor que incluye todos los campos como argumentos
@NoArgsConstructor // Constructor sin argumentos
@Builder // Patrón de diseño para construir objetos de manera más concisa
public class Category {

    @Id // Indica que esta columna es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación de valor automático para la clave primaria
    private long categoryId; // Identificador único de la categoría

    private String name; // Nombre de la categoría
}
