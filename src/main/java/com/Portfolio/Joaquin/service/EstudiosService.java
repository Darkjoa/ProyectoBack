/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Estudios;
import com.Portfolio.Joaquin.repository.EstudiosRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosService implements IEstudiosService {
    @Autowired
    public EstudiosRepository estuRepo;
    @Override
    public List<Estudios> verEstudios()
    {
        return estuRepo.findAll();
    }
@Override
    public Estudios crearEstudios(Estudios est)
    {
        return estuRepo.save(est);
    }
    @Override
    public boolean borrarEstudios(Long id)
    {
        if(this.estuRepo.existsById(id)){
            estuRepo.deleteById(id);
            return true;
        }
        return false;
    }
@Override
    public Estudios buscarEstudios(Long id){
        return estuRepo.findById(id).orElse(null);
    }
}
