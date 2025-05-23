package eci.cvds.parcial.ECISalud.mongoConection;

import eci.cvds.parcial.ECISalud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<User, String> {
}
