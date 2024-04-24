package co.hyunseda.client.Domain.Service;


import co.hyunseda.client.Domain.Entity.Client;

import co.hyunseda.client.Access.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{

    private final IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean save(Client client) {
        try {
            clientRepository.save(client);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public boolean update(Long id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setClientId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
