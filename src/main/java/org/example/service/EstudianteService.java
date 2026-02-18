package org.example.service;

// Importamos las clases del modelo que vamos a utilizar.

import org.example.model.Estudiante;
import org.example.model.ProgramaAcademico;
import java.util.*;
import java.util.regex.Pattern;

// Clase de servicio encargada de manejar la lógica
// relacionada con los estudiantes (CRUD y validaciones).

public class EstudianteService {

    // Lista que almacena los estudiantes en memoria.
    // Funciona como una base de datos temporal.

    private List<Estudiante> estudiantes = new ArrayList<>();

    // Contador para generar IDs automáticos.

    private int contadorId = 1;

    // Metodo privado para validar el formato del correo.
    // Usa una expresión regular (regex).

    private boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, correo);
    }

    // Metodo para registrar un nuevo estudiante.

    public Estudiante registrar(String nombre, String correo, String programa) {

        // Validación de campos vacíos.

        if (nombre.isEmpty() || correo.isEmpty() || programa.isEmpty()) {
            throw new IllegalArgumentException("No se permiten campos vacíos.");
        }

        // Validación del formato del correo.

        if (!validarCorreo(correo)) {
            throw new IllegalArgumentException("Formato de correo inválido.");
        }

        // Conversión del String recibido a un enum ProgramaAcademico.

        ProgramaAcademico programaEnum;
        try {
            programaEnum = ProgramaAcademico.valueOf(programa.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Si el programa no coincide con el enum, lanza error.
            throw new IllegalArgumentException("Programa académico no válido.");
        }

        // Se crea el objeto estudiante con ID automático.

        Estudiante estudiante = new Estudiante(contadorId++, nombre, correo, programaEnum);

        // Se agrega a la lista.

        estudiantes.add(estudiante);

        // Se retorna el estudiante registrado.

        return estudiante;
    }

    // Metodo para listar todos los estudiantes.

    public List<Estudiante> listar() {
        return estudiantes;
    }

    // Metodo para buscar un estudiante por su ID.

    public Estudiante buscarPorId(int id) {
        return estudiantes.stream()  // Se usa Stream API
                .filter(e -> e.getId() == id)  // Filtra por ID
                .findFirst()  // Obtiene el primero que coincida
                .orElse(null);  // Si no encuentra, retorna null
    }

    // Metodo para modificar un estudiante existente.

    public void modificar(int id, String nombre, String correo, String programa) {

        // Busca el estudiante.

        Estudiante estudiante = buscarPorId(id);

        // Si no existe, lanza excepción.

        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no encontrado.");
        }

        // Validaciones de campos vacíos.

        if (nombre.isEmpty() || correo.isEmpty() || programa.isEmpty()) {
            throw new IllegalArgumentException("No se permiten campos vacíos.");
        }

        // Validación del correo.

        if (!validarCorreo(correo)) {
            throw new IllegalArgumentException("Formato de correo inválido.");
        }

        // Conversión del programa a enum.

        ProgramaAcademico programaEnum;
        try {
            programaEnum = ProgramaAcademico.valueOf(programa.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Programa académico no válido.");
        }

        // Actualización de datos mediante setters.

        estudiante.setNombre(nombre);
        estudiante.setCorreo(correo);
        estudiante.setProgramaAcademico(programaEnum);
    }

    // Metodo para eliminar un estudiante por ID.
    public void eliminar(int id) {
        // removeIf elimina el elemento si la condición se cumple.
        estudiantes.removeIf(e -> e.getId() == id);
    }
}
