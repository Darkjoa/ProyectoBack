/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

/**
 *
 * @author joaqo
 */
import com.Portfolio.Joaquin.model.Habilidades;
import com.Portfolio.Joaquin.repository.HabilidadesRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HabilidadesService implements IHabilidadesServices {
    
    @Autowired
    public HabilidadesRepository habilidadesRepo;
    @Override
    public List<Habilidades> verHabilidades() {
        return habilidadesRepo.findAll();
        
    }

    @Override
    public Habilidades crearHabilidades(Habilidades hab) {
        return habilidadesRepo.save(hab);
    }

    @Override
    public void borrarHabilidades(Long id) {
        habilidadesRepo.deleteById(id);
    }

    @Override
    public Habilidades buscarHabilidades(Long id) {
        return habilidadesRepo.findById(id).orElse(null);
    }
    
}
