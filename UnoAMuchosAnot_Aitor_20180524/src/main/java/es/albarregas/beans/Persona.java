/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Daw2
 */
@Entity
@Table(name="persona1anAnot")
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idPersona")
    private int idPerso;
    @Column(name="nombre", length=40)
    private String nombre;
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="idPersona")
    @IndexColumn(name="orden")
    private List<Libro> libros;

    public Persona() {
    }

    public Persona(int idPerso, String nombre, List<Libro> libros) {
        this.idPerso = idPerso;
        this.nombre = nombre;
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public int getIdPerso() {
        return idPerso;
    }

    public void setIdPerso(int idPerso) {
        this.idPerso = idPerso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
