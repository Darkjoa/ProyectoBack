/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Proyectos;
import com.Portfolio.Joaquin.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService {

    @Autowired
    public ProyectosRepository proRepo;
    @Override
    public List<Proyectos> verProyectos() {
        return proRepo.findAll();
    }

    @Override
    public Proyectos crearProyectos(Proyectos proyectos) {
        return proRepo.save(proyectos);
    }

    @Override
    public boolean borrarProyectos(Long id) {
        if(this.proRepo.existsById(id)){
            proRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proRepo.findById(id).orElse(null);
    }
   
}
