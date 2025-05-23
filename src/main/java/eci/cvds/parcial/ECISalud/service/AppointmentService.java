package eci.cvds.parcial.ECISalud.service;


import eci.cvds.parcial.ECISalud.model.Appointment;
import eci.cvds.parcial.ECISalud.model.Especialidad;
import eci.cvds.parcial.ECISalud.model.User;
import eci.cvds.parcial.ECISalud.mongoConection.AppointmentRepository;
import eci.cvds.parcial.ECISalud.mongoConection.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    static UsuarioRepository userRepository;

    @Autowired
    static AppointmentRepository appointmentRepository;

    public static Appointment procesarCita(Especialidad especialidad, String doctor, String ubicacion, LocalDate fechaCita, Integer cedula){
        Optional<User> paciente = userRepository.findByCedula(cedula);

        if(paciente.isEmpty()){
            throw new IllegalArgumentException("No existe un usuario con esdta cedula.");
        }

        List<Appointment> appointments = appointmentRepository.findByEspecialidad(especialidad);

        for(Appointment ap: appointments){
            if (ap.getFechaCita().equals(fechaCita)){
                throw new IllegalArgumentException("Este horario no esta disponible.");
            }
        }

        Appointment newAppointment = new Appointment(fechaCita,especialidad,paciente.get(),doctor,ubicacion);

        appointmentRepository.save(newAppointment);

        return newAppointment;
    }

    public static List<Appointment> obtenerCitasPorStatus(boolean stautus){

        return null;
    }
}
