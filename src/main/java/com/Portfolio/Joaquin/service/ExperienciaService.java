/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Experiencia;
import com.Portfolio.Joaquin.repository.ExperienciaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExperienciaService implements IExperienciaService {
        
    @Autowired
    public ExperienciaRepository XpRepo;
    @Override
    public List<Experiencia> verExperiencia() {
        return XpRepo.findAll();
        
    }

    @Override
    public Experiencia crearExperiencia(Experiencia XP) {
       return XpRepo.save(XP);
    }

    @Override
    public void borrarExperiencia(Long id) {
        XpRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return XpRepo.findById(id).orElse(null);
    }
    
    
}
