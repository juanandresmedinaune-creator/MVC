package org.example.service;

import org.example.model.Estudiante;
import org.example.model.ProgramaAcademico;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EstudianteServiceImpl implements EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private int contadorId = 1;

    private boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, correo);
    }

    @Override
    public Estudiante registrar(String nombre, String correo, String programa) {

        if (nombre.isEmpty() || correo.isEmpty() || programa.isEmpty()) {
            throw new IllegalArgumentException("No se permiten campos vacíos.");
        }

        if (!validarCorreo(correo)) {
            throw new IllegalArgumentException("Formato de correo inválido.");
        }

        ProgramaAcademico programaEnum;
        try {
            programaEnum = ProgramaAcademico.valueOf(programa.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Programa académico no válido.");
        }

        Estudiante estudiante = new Estudiante(contadorId++, nombre, correo, programaEnum);
        estudiantes.add(estudiante);

        return estudiante;
    }

    @Override
    public List<Estudiante> listar() {
        return estudiantes;
    }

    @Override
    public Estudiante buscarPorId(int id) {
        return estudiantes.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void modificar(int id, String nombre, String correo, String programa) {

        Estudiante estudiante = buscarPorId(id);

        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no encontrado.");
        }

        if (nombre.isEmpty() || correo.isEmpty() || programa.isEmpty()) {
            throw new IllegalArgumentException("No se permiten campos vacíos.");
        }

        if (!validarCorreo(correo)) {
            throw new IllegalArgumentException("Formato de correo inválido.");
        }

        ProgramaAcademico programaEnum;
        try {
            programaEnum = ProgramaAcademico.valueOf(programa.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Programa académico no válido.");
        }

        estudiante.setNombre(nombre);
        estudiante.setCorreo(correo);
        estudiante.setProgramaAcademico(programaEnum);
    }

    @Override
    public void eliminar(int id) {
        estudiantes.removeIf(e -> e.getId() == id);
    }
}
