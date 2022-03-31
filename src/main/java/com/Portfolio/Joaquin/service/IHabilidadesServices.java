/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Habilidades;
import java.util.List;
public interface IHabilidadesServices {
    
    public List<Habilidades> verHabilidades();
    
    public Habilidades crearHabilidades(Habilidades habilidades);
    
    public void borrarHabilidades(Long id);
    
    public Habilidades buscarHabilidades(Long id);
}
