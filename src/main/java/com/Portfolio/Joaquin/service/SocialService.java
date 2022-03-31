/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.service;

import com.Portfolio.Joaquin.model.Social;
import com.Portfolio.Joaquin.repository.SocialRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SocialService implements Isocial {
    
    @Autowired
    public SocialRepository socRepo;
    
    @Override      
    public List<Social> verSocial(){
        return socRepo.findAll();
          }
    
    @Override
    public Social crearSocial(Social social){
        return socRepo.save(social);
    }
    
    @Override
    public void borrarSocial(Long id){
        
        socRepo.deleteById(id);
    }
    
    @Override
    public Social buscarSocial(Long id){
        return socRepo.findById(id).orElse(null);
    }
    
}
