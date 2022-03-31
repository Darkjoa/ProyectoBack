/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Persona;
import java.util.List;

public interface IPersonaService {
    //Traemos a todas las personas
    public List<Persona> verPersona();
    //Damos de alta a una persona
    public Persona crearPersona(Persona per);
    //Borramos a una persona
    public void borrarPersona(Long id);
    //Traemos a una persona por su id
    public Persona buscarPersona(Long id);
}
