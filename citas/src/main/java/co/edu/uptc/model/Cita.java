package co.edu.uptc.model;

public class Cita {
    private String id;
    private Medico medico;
    private Paciente paciente;
    private String fecha;

    public Cita(String id, Medico medico, Paciente paciente, String fecha) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
    }
    public Cita() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Cita [id=" + id + ", medico=" + medico + ", paciente=" + paciente + ", fecha=" + fecha + "]";
    }
    
}
