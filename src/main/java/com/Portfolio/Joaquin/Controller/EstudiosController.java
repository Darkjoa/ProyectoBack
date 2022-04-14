/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;

import com.Portfolio.Joaquin.model.Estudios;
import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.service.IEstudiosService;

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

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {
    private final long PERSONA_ID=1; //fk hardcodeada
	
   @Autowired
    private IEstudiosService estudiosServ;
    @GetMapping("/ver")
    @ResponseBody
    public List<Estudios> verEstudios()
    {
        
        return estudiosServ.verEstudios();
    }
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping("/new")
    public ResponseEntity<Estudios> agregarEstudios(@RequestBody Estudios estudios)
    {			
		Persona ps = new Persona();
		ps.setId(PERSONA_ID); // 
                estudios.setPersona(ps);
                Estudios newEstudios = estudiosServ.crearEstudios(estudios);
                return ResponseEntity.status(HttpStatus.CREATED).body(newEstudios);   
    }
    

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarEstudios (@PathVariable Long id)
    {
        estudiosServ.borrarEstudios(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Estudios> editEstudios
        (
                @Valid
                @RequestBody Estudios estudios,
                Errors errors
        )
        {
            if (errors.hasErrors()) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            Estudios e = this.estudiosServ.buscarEstudios(estudios.getId());
            
            if(e==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            e.setEscuela(estudios.getEscuela());
            e.setTitulo(estudios.getTitulo());
            e.setNivel(estudios.getNivel());
            e.setInicio(estudios.getInicio());
            e.setFinal(estudios.getFinal());
            Estudios newEstudios = this.estudiosServ.crearEstudios(e);
            return ResponseEntity.status(HttpStatus.OK).body(newEstudios);
        }
        
        
        
        @GetMapping("/buscar/{id}")
        public ResponseEntity<Estudios> filtrarEstudios(@PathVariable Long id){
            Estudios e = this.estudiosServ.buscarEstudios(id);
            if(e!=null){
             return ResponseEntity.ok(e);
            }
               return ResponseEntity.notFound().build();
        }
        
        //final de estudios
 
}
