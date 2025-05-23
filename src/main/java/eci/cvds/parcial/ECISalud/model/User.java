package eci.cvds.parcial.ECISalud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection = "Usuario")
public class User {

    @Id
    private String id;
    private String userName;
    private Integer cedula;
    private String email;

    public User() {}

    public User(String userName, Integer cedula, String email){
        this.userName = userName;
        this.cedula = cedula;
        this.email = email;
    }
}
