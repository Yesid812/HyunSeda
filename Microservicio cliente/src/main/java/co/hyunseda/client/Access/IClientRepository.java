package co.hyunseda.client.Access;

import co.hyunseda.client.Domain.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface IClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByFirstName(String firstName);
}
