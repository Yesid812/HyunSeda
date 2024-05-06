package co.hyunseda.client.Domain.Service;

import co.hyunseda.client.Domain.Entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Anotación que marca esta interfaz como un servicio de Spring
public interface IClientService {

    // Método para guardar un cliente en la base de datos
    boolean save(Client client);

    // Método para buscar un cliente por su ID
    Client findById(Long id);

    // Método para obtener todos los clientes
    List<Client> findAll();

    // Método para actualizar un cliente existente
    boolean update(Long id, Client client);

    // Método para eliminar un cliente por su ID
    boolean deleteById(Long id);
}
