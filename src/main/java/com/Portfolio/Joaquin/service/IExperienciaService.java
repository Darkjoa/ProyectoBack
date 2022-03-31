/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    
    public Experiencia crearExperiencia(Experiencia Xp);
    
    public void borrarExperiencia(Long id);
    
    public Experiencia buscarExperiencia(Long id);
}
