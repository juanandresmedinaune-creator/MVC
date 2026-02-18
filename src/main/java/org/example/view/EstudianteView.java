
package org.example.view;

// Importamos el controlador, ya que la vista se comunica con él.

import org.example.controller.EstudianteController;

// Importamos Scanner para leer datos desde consola.

import java.util.Scanner;

// Clase encargada de mostrar el menú y capturar datos del usuario.

public class EstudianteView {

    // Referencia al controlador.
    // La vista nunca accede directamente al service o al model.

    private EstudianteController controller;

    // Scanner para entrada de datos por consola.

    private Scanner sc;

    // Constructor: recibe el controller desde la clase Main.

    public EstudianteView(EstudianteController controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    // Metodo que muestra el menú principal.
    // Usa un ciclo do-while para repetirse hasta que el usuario elija salir.

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== Sistema de Gestión de Estudiantes =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Modificar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // nextInt() lee solo el número

            opcion = sc.nextInt();

            // nextLine() limpia el salto de línea pendiente

            sc.nextLine();

            // Estructura switch para ejecutar la opción seleccionada

            switch (opcion) {
                case 1: registrar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: modificar(); break;
                case 5: eliminar(); break;
            }

        } while (opcion != 6); // Se repite hasta que el usuario elija salir
    }

    // Metodo para registrar un estudiante.

    private void registrar() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Programa (INGENIERIA, DERECHO, MEDICINA, ARQUITECTURA, ADMINISTRACION): ");
        String programa = sc.nextLine();

        // Se envían los datos al controller
        // y se imprime el objeto retornado.

        System.out.println(controller.registrar(nombre, correo, programa));
    }

    // Metodo para listar todos los estudiantes.

    private void listar() {
        // forEach con referencia a método para imprimir cada estudiante
        controller.listar().forEach(System.out::println);
    }

    // Metodo para buscar un estudiante por ID.

    private void buscar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println(controller.buscar(id));
    }

    // Metodo para modificar un estudiante.

    private void modificar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nuevo correo: ");
        String correo = sc.nextLine();

        System.out.print("Nuevo programa: ");
        String programa = sc.nextLine();

        controller.modificar(id, nombre, correo, programa);
        System.out.println("Estudiante modificado correctamente.");
    }

    // Metodo para eliminar un estudiante.

    private void eliminar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        controller.eliminar(id);
        System.out.println("Estudiante eliminado correctamente.");
    }
}
