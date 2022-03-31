/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Estudios;
import java.util.List;
public interface IEstudiosService {
 
    public List<Estudios> verEstudios();
    public Estudios crearEstudios(Estudios estudios);
    public boolean borrarEstudios(Long id);
    public Estudios buscarEstudios(Long id);
}
