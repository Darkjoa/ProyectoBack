/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.SobreMi;
import java.util.List;

public interface ISobreMiService {
    public List<SobreMi> verSobreMi();
    
    public SobreMi crearSobreMi(SobreMi sobreMi);
    
    public void borrarSobreMi(Long id);
    
    public SobreMi buscarSobreMi(Long id);
}
