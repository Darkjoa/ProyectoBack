/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Social;
import java.util.List;

/**
 *
 * @author joaqo
 */
public interface Isocial {
    public List<Social> verSocial();
    
    public Social crearSocial(Social social);
    
    public void borrarSocial(Long id);
    
    public Social buscarSocial(Long id);
}
