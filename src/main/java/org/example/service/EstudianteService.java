package org.example.service;

import org.example.model.Estudiante;
import java.util.List;

public interface EstudianteService {

    Estudiante registrar(String nombre, String correo, String programa);

    List<Estudiante> listar();

    Estudiante buscarPorId(int id);

    void modificar(int id, String nombre, String correo, String programa);

    void eliminar(int id);
}
