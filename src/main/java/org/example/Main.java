
package org.example;

// Importamos el Controller (capa intermedia).

import org.example.controller.EstudianteController;

// Importamos la Vista (interfaz con el usuario).

import org.example.view.EstudianteView;

// Clase principal donde inicia la ejecución del programa.

public class Main {

    // Metodo main: punto de entrada del programa en Java.

    public static void main(String[] args) {

        // Se crea el controlador.
        // Este se encargará de comunicar la vista con la lógica de negocio.

        EstudianteController controller = new EstudianteController();

        // Se crea la vista y se le pasa el controller como parámetro.
        // Esto permite que la vista pueda llamar a los métodos del controller.

        EstudianteView view = new EstudianteView(controller);

        // Se llama al metodo que muestra el menú principal.
        // Aquí comienza la interacción con el usuario.

        view.mostrarMenu(); // llama el menú
    }
}
