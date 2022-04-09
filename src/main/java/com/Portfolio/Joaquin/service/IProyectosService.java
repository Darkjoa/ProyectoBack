/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Proyectos;
import java.util.List;

/**
 *
 * @author joaqo
 */
public interface IProyectosService {
    public List<Proyectos> verProyectos();
    public Proyectos crearProyectos(Proyectos proyectos);
    public boolean borrarProyectos(Long id);
    public Proyectos buscarProyectos(Long id);
}
