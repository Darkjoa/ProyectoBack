/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.repository.sobreMiRepository;
import java.util.List;
import com.Portfolio.Joaquin.model.SobreMi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobreMiService implements ISobreMiService   {
    @Autowired
    public sobreMiRepository sobreRepo;
    @Override
    public List<SobreMi> verSobreMi() {
        return sobreRepo.findAll();
        
    }

    @Override
    public SobreMi crearSobreMi(SobreMi sob) {
        return sobreRepo.save(sob);
    }

    @Override
    public void borrarSobreMi(Long id) {
        sobreRepo.deleteById(id);
    }

    @Override
    public SobreMi buscarSobreMi(Long id) {
        return sobreRepo.findById(id).orElse(null);
    }
}
