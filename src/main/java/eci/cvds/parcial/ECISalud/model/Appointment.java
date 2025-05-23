package eci.cvds.parcial.ECISalud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document (collection = "Citas")
public class Appointment {

    @Id
    private String id;
    private LocalDate fechaCita;
    private User paciente;
    private Especialidad especialidad;
    private String doctorAsignado;
    private String ubicacion;

    public boolean status;

    public Appointment(){}

    public Appointment(LocalDate fechaCita, Especialidad especialidad,User paciente, String doctorAsignado, String ubicacion){
        this.fechaCita = fechaCita;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.doctorAsignado = doctorAsignado;
        this.ubicacion = ubicacion;
        this.status = true;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void changeStatus(){
        if(this.status){
            this.status = false;
        }else{
            this.status = true;
        }
    }
}
