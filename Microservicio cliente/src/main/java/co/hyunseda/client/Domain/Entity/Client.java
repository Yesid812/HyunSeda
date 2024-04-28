package co.hyunseda.client.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    private static  final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID clientId;
    private String firstName;
    private String lastName;


}
