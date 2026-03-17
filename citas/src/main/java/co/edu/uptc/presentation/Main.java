package co.edu.uptc.presentation;

import java.util.Scanner;

import co.edu.uptc.model.Cita;
import co.edu.uptc.model.Medico;
import co.edu.uptc.model.Paciente;
import co.edu.uptc.service.CitaService;
import co.edu.uptc.service.MedicoService;
import co.edu.uptc.service.PacienteService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MedicoService medicoService = new MedicoService();
        PacienteService pacienteService = new PacienteService();
        CitaService citaService = new CitaService();
        int op = -1;
        while(op!=0) {

            System.out.println("\n--- SISTEMA CLINICA ---");
            System.out.println("1 Crear medico");
            System.out.println("2 Crear paciente");
            System.out.println("3 Crear cita");
            System.out.println("4 Listar medicos");
            System.out.println("5 Listar pacientes");
            System.out.println("6 Listar citas");
            System.out.println("0 Salir");
            System.out.println("Digite su opción:");

            op = sc.nextInt();
            sc.nextLine();

            switch(op) {

                case 1:
                    System.out.println("ID medico:");
                    String idM = sc.nextLine();

                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    System.out.println("Especialidad:");
                    String esp = sc.nextLine();

                    medicoService.crearMedico(new Medico(idM, nombre, esp));
                    break;

                case 2:
                    System.out.println("ID paciente:");
                    String idP = sc.nextLine();

                    System.out.println("Nombre:");
                    String nombreP = sc.nextLine();

                    System.out.println("Edad:");
                    int edad = sc.nextInt();

                    pacienteService.crear(new Paciente(idP, nombreP, edad));

                    break;

                case 3:
                    System.out.println("ID cita:");
                    String idC = sc.nextLine();

                    System.out.println("ID medico:");
                    String idMedico = sc.nextLine();

                    System.out.println("ID paciente:");
                    String idPaciente = sc.nextLine();

                    System.out.println("Fecha:");
                    String fecha = sc.nextLine();

                    Medico medico = medicoService.buscarPorId(idMedico);
                    Paciente paciente = pacienteService.buscarPorId(idPaciente);

                    if (medico == null || paciente == null) {

                        System.out.println("Medico o paciente no encontrado");

                    } else {

                        Cita cita = new Cita(idC, medico, paciente, fecha);

                        citaService.crear(cita);

                        System.out.println("Cita creada correctamente");
                    }

                    break;

                case 4:
                    medicoService.listar()
                            .forEach(m -> System.out.println(
                                    m.getId() + " - " + m.getNombre() + " - " + m.getEspecialidad()));
                    break;

                case 5:
                    pacienteService.listar()
                            .forEach(p -> System.out.println(
                                    p.getId() + " - " + p.getNombre() + " - " + p.getEdad()));

                    break;
                case 6:
                    citaService.listar()
                            .forEach(c -> System.out.println(
                                    c.getId() +
                                            " | Medico: " + c.getMedico().getNombre() +
                                            " | Paciente: " + c.getPaciente().getNombre() +
                                            " | Fecha: " + c.getFecha()));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    System.out.println("Gracias por usar el sistema de citas de la clínica.");
            }
        }
    }
}