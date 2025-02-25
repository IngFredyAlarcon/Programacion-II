package co.edu.uptc.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import co.edu.uptc.model.Cita;
import co.edu.uptc.model.Medico;
import co.edu.uptc.model.Paciente;

import java.time.LocalDateTime;

public class CitaTest {
    @Test
    public void testCrearPaciente() {
        Paciente paciente = new Paciente("Juan Pérez", 30, "P001");
        assertEquals("Juan Pérez", paciente.getNombre());
        assertEquals(30, paciente.getEdad());
        assertEquals("P001", paciente.getId());
    }

    @Test
    public void testCrearMedico() {
        Medico medico = new Medico("Dra. González", "Cardiología", "M123");
        assertEquals("Dra. González", medico.getNombre());
        assertEquals("Cardiología", medico.getEspecialidad());
        assertEquals("M123", medico.getLicencia());
    }

    @Test
    public void testCrearCita() {
        Paciente paciente = new Paciente("Juan Pérez", 30, "P001");
        Medico medico = new Medico("Dra. González", "Cardiología", "M123");
        LocalDateTime fecha = LocalDateTime.of(2025, 5, 10, 10, 30);
        Cita cita = new Cita(fecha, paciente, medico);

        assertEquals(fecha, cita.getFecha());
        assertEquals(paciente, cita.getPaciente());
        assertEquals(medico, cita.getMedico());
    }
}
