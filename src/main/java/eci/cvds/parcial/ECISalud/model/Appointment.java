package eci.cvds.parcial.ECISalud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document (collection = "Citas")
public class Appointment {

    @Id
    private String id;
    private LocalDate fechaCita;
    private Especialidad especialidad;
    private String doctorAsignado;
    private String ubicacion;

    public Appointment(){}

    public Appointment(LocalDate fechaCita, Especialidad especialidad, String doctorAsignado, String ubicacion){
        this.fechaCita = fechaCita;
        this.especialidad = especialidad;
        this.doctorAsignado = doctorAsignado;
        this.ubicacion = ubicacion;
    }


}
