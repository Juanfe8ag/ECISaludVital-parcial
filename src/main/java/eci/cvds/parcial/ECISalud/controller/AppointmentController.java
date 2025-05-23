package eci.cvds.parcial.ECISalud.controller;


import eci.cvds.parcial.ECISalud.model.Appointment;
import eci.cvds.parcial.ECISalud.model.Especialidad;
import eci.cvds.parcial.ECISalud.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> postAppointment(
            @RequestParam Especialidad especialidad,
            @RequestParam String doctor,
            @RequestParam String ubicacion,
            @RequestParam LocalDate fechaCita,
            @RequestParam Integer cedula){

        try{
            Appointment appointment = AppointmentService.procesarCita(especialidad, doctor, ubicacion, fechaCita, cedula);
            return ResponseEntity.ok(appointment);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/appointments/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable boolean status){
        return ResponseEntity.ok(AppointmentService.obtenerCitasPorStatus(status));
    }
}
