package co.hyunseda.client.Domain.Service;

import co.hyunseda.client.Domain.Entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {

    boolean save(Client client);

    Client findById(Long id);

    List<Client> findAll();

    boolean update(Long id, Client client);

    boolean deleteById(Long id);
}
