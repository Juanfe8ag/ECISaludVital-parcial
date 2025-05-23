package eci.cvds.parcial.ECISalud.mongoConection;

import eci.cvds.parcial.ECISalud.model.Appointment;
import eci.cvds.parcial.ECISalud.model.Especialidad;
import eci.cvds.parcial.ECISalud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {


    List<Appointment> findByEspecialidad(Especialidad especialidad);
}
