package eci.cvds.parcial.ECISalud.mongoConection;

import eci.cvds.parcial.ECISalud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    Optional<User> findByCedula(Integer cedula);

}
