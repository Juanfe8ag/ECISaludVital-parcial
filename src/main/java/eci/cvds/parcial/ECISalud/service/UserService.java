package eci.cvds.parcial.ECISalud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.cvds.parcial.ECISalud.mongoConection.UsuarioRepository;
import eci.cvds.parcial.ECISalud.model.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository userRepository;

    public User registrarUsuario(String nombre, Integer cedula, String email) {
        if (userRepository.findByEmail(email).isPresent() || userRepository.findByCedula(cedula).isPresent()) {
            throw new IllegalArgumentException("El email o la cedula ya estan registradas.");
        }
        User user = new User(nombre, cedula, email);
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByCedula(String email){
        return userRepository.findByEmail(email);
    }
}
