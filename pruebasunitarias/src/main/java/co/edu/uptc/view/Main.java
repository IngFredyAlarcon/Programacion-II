package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.controller.PacienteController;
import co.edu.uptc.model.Paciente;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacienteController pacienteController = new PacienteController();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Buscar Paciente");
            System.out.println("4. Actualizar Paciente");
            System.out.println("5. Eliminar Paciente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    pacienteController.crearPaciente(nombre, edad, id);
                    System.out.println("Paciente creado con éxito.");
                    break;

                case 2:
                    System.out.println("Lista de Pacientes:");
                    for (Paciente p : pacienteController.listarPacientes()) {
                        System.out.println("ID: " + p.getId() + " - Nombre: " + p.getNombre() + " - Edad: " + p.getEdad());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese ID: ");
                    String buscarId = scanner.nextLine();
                    Paciente encontrado = pacienteController.buscarPaciente(buscarId);
                    if (encontrado != null) {
                        System.out.println("Paciente encontrado: " + encontrado.getNombre());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese ID: ");
                    String actualizarId = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nueva edad: ");
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine();
                    if (pacienteController.actualizarPaciente(actualizarId, nuevoNombre, nuevaEdad)) {
                        System.out.println("Paciente actualizado.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese ID: ");
                    String eliminarId = scanner.nextLine();
                    if (pacienteController.eliminarPaciente(eliminarId)) {
                        System.out.println("Paciente eliminado.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}