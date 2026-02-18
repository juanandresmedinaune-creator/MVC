package org.example.model;

public class Estudiante {


    // Identificador único del estudiante.
    // Nombre completo del estudiante
    // Correo electrónico del estudiante.
    // Tipo de dato enum (ProgramaAcademico).
    // Esto significa que el estudiante solo puede pertenecer
    // a uno de los programas definidos en el enum ProgramaAcademico.


    private int id;
    private String nombre;
    private String correo;
    private ProgramaAcademico programaAcademico;

    // Constructor completo
    public Estudiante(int id, String nombre, String correo, ProgramaAcademico programaAcademico) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.programaAcademico = programaAcademico;
    }

    // Constructor vacío

    public Estudiante() {}

    // Getters

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public ProgramaAcademico getProgramaAcademico() { return programaAcademico; }

    // Setters

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setProgramaAcademico(ProgramaAcademico programaAcademico) { this.programaAcademico = programaAcademico; }


    // tostring

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Correo: " + correo +
                ", Programa: " + programaAcademico;
    }
}
