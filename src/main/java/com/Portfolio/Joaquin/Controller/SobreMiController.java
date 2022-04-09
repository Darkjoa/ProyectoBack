/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;

import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.model.SobreMi;
import com.Portfolio.Joaquin.service.ISobreMiService;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joaqo
 */
@RestController
@RequestMapping("/sobremi")
@CrossOrigin(origins = "http://localhost:4200")
public class SobreMiController {
    private final long PERSONA_ID=1;
    @Autowired
    private ISobreMiService sobreServ;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<SobreMi> agregarSobreMi(@RequestBody SobreMi sobreMi)
    {
        Persona ps = new Persona();
        ps.setId(PERSONA_ID); 
        sobreMi.setPersona(ps);
        SobreMi newSobreMi = sobreServ.crearSobreMi(sobreMi);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSobreMi);
        
    }
    @GetMapping("/ver")
    @ResponseBody
    public List<SobreMi> verSobreMi()
    {
        return sobreServ.verSobreMi();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarSobreMi (@PathVariable Long id)
    {
        sobreServ.borrarSobreMi(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<SobreMi> editSobreMi
        (
                @Valid
                @RequestBody SobreMi sobremi,
                Errors errors
        )
        {
             if (errors.hasErrors()) 
                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                SobreMi s = this.sobreServ.buscarSobreMi(sobremi.getId());
                if(s ==null)
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                
                s.setNombreDato(sobremi.getNombreDato());
                s.setDato(sobremi.getDato());
                SobreMi newSobreMi = this.sobreServ.crearSobreMi(s);
                return ResponseEntity.status(HttpStatus.OK).body(newSobreMi);
                
                
        }
}
