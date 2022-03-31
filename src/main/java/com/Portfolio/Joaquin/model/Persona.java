/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class Persona {
    public Persona(){}
    @Id
    @GeneratedValue(strategy  =GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String imaUrl;
    private String portadaImaUrl;
    private int edad;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference // evita la referencia circular a la hora de hacer el json
    private List<Estudios> estudios;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference // evita la referencia circular a la hora de hacer el json
    private List<Experiencia> experiencia;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference // evita la referencia circular a la hora de hacer el json
    private List<Habilidades> habilidades;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference // evita la referencia circular a la hora de hacer el json
    private List<SobreMi> sobremi;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference // evita la referencia circular a la hora de hacer el json
    private List<Social> social;


    
    
}
