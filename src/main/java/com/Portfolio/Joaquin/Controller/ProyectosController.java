/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;

import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.model.Proyectos;
import com.Portfolio.Joaquin.service.IProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://joaquincornelatti-f320d.web.app")
public class ProyectosController {
        private final long PERSONA_ID=1; 
	
   @Autowired
   private IProyectosService proyectServ;
   @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("/new")
   public ResponseEntity<Proyectos> agregarProyectos(@RequestBody Proyectos proyectos)
   {
        Persona ps = new Persona();
        ps.setId(PERSONA_ID); // 
        proyectos.setPersona(ps);
        Proyectos newProyectos = proyectServ.crearProyectos(proyectos);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProyectos); 
   }
   
   @GetMapping("/ver")
   @ResponseBody
   public List<Proyectos> verProyectos(){
       return proyectServ.verProyectos();
   }
   @PreAuthorize("hasRole('ADMIN')")
   @DeleteMapping("/delete/{id}")
   public void borrarProyectos (@PathVariable Long id)
   {
       proyectServ.borrarProyectos(id);
   }
   @PreAuthorize("hasRole('ADMIN')")
   @PutMapping("/editar")
   public ResponseEntity<Proyectos> editProyectos
        (
                @Valid
                @RequestBody Proyectos proyectos,
                Errors errors
        ){
            if (errors.hasErrors()) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            Proyectos p = this.proyectServ.buscarProyectos(proyectos.getId());
            
            if(p==null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            p.setNombre(proyectos.getNombre());
            p.setImagenProyectoUrl(proyectos.getImagenProyectoUrl());
            p.setUrl(proyectos.getUrl());
            
            Proyectos newProyectos = this.proyectServ.crearProyectos(p);
            return ResponseEntity.status(HttpStatus.OK).body(newProyectos);
        }
   @GetMapping("/buscar/{id}")
   public ResponseEntity<Proyectos> filtrarProyectos(@PathVariable Long id){
       Proyectos p=this.proyectServ.buscarProyectos(id);
       if(p!=null){
           return ResponseEntity.ok(p);
       }
       return ResponseEntity.notFound().build();
   }
   
   
}
