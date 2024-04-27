package co.hyunseda.client.presentation.rest;

import co.hyunseda.client.Domain.Entity.Client;
import co.hyunseda.client.Domain.Service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService clientService;


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean saveClient(@RequestBody Client client) {
        // Log para depurar el objeto Client recibido en la solicitud POST
        logger.debug("Cliente recibido en la solicitud POST: {}", client);

        return clientService.save(client);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

       @RequestMapping(method = RequestMethod.GET, produces = "application/json")
       public List<Client> findAllClients(){
        return clientService.findAll();
       }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client) {
        if (clientService.update(id, client)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long id) {
        if (clientService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}