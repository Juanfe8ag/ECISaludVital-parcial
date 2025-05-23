package eci.cvds.parcial.ECISalud.mongoConection;

import eci.cvds.parcial.ECISalud.model.Appointment;
import eci.cvds.parcial.ECISalud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {


}
