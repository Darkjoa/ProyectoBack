/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;



import com.Portfolio.Joaquin.model.Persona;

import com.Portfolio.Joaquin.service.IPersonaService;





import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")


public class PersonaController {
    //Persona
    @Autowired
    private IPersonaService persoServ;
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Persona> verPersonas(@PathVariable long id)
    {
        Persona p = this.persoServ.buscarPersona(id);
        return ResponseEntity.ok(p);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona pers)
    {
        Persona p = this.persoServ.crearPersona(pers);
        return ResponseEntity.ok(p);
    }
    
    

    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Persona> editPersona
        (
                @Valid
                @RequestBody Persona persona,
                Errors errors
        )
        {
            if (errors.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            Persona p = this.persoServ.buscarPersona(persona.getId());
            if(p==null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            p.setEdad(persona.getEdad());
            p.setImaUrl(persona.getImaUrl());
            p.setPortadaImaUrl(persona.getPortadaImaUrl());
            Persona newPersona =this.persoServ.crearPersona(p);
            return ResponseEntity.status(HttpStatus.OK).body(newPersona);
        }
        
        //final de persona
 
}
