/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.repository.PersonaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository persoRepo;
    @Override
    public List<Persona> verPersona() {
        return persoRepo.findAll();
        
    }

    @Override
    public Persona crearPersona(Persona per) {
        return persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
}
