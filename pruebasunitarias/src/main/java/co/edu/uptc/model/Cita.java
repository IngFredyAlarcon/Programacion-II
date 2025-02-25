package co.edu.uptc.model;

import java.time.LocalDateTime;

public class Cita {
    private LocalDateTime fecha;
    private Paciente paciente;
    private Medico medico;

    public Cita(LocalDateTime fecha, Paciente paciente, Medico medico) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.medico = medico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fecha=" + fecha +
                ", paciente=" + paciente +
                ", medico=" + medico +
                '}';
    }
}
