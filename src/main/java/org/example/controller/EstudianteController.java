
package org.example.controller;

// Importamos la capa de servicio (lógica de negocio).

import org.example.service.EstudianteService;

// Importamos la clase del modelo.

import org.example.model.Estudiante;
import org.example.service.EstudianteServiceImpl;

// Importamos List para manejar listas de estudiantes.

import java.util.List;

// Clase controladora.
// Actúa como intermediaria entre la vista (UI)
// y la lógica de negocio (Service).

public class EstudianteController {

    // Se crea una instancia del servicio.
    // El controller delega en el service toda la lógica.

    private EstudianteService service = new EstudianteServiceImpl();

    // Metodo para registrar un estudiante.
    // Recibe datos desde la vista y los envía al service.

    public Estudiante registrar(String nombre, String correo, String programa) {
        return service.registrar(nombre, correo, programa);
    }

    // Metodo para listar todos los estudiantes.

    public List<Estudiante> listar() {
        return service.listar();
    }

    // Metodo para buscar un estudiante por ID.

    public Estudiante buscar(int id) {
        return service.buscarPorId(id);
    }

    // Metodo para modificar un estudiante.

    public void modificar(int id, String nombre, String correo, String programa) {
        service.modificar(id, nombre, correo, programa);
    }

    // Metodo para eliminar un estudiante por ID.

    public void eliminar(int id) {
        service.eliminar(id);
    }
}
