/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;

import com.Portfolio.Joaquin.model.Habilidades;
import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.service.IHabilidadesServices;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/habilidades")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadesController {
    private final long PERSONA_ID=1; 
    @Autowired
    private IHabilidadesServices habiServ;
    
    
    @PostMapping("/new")
    public ResponseEntity<Habilidades> agregarHabilidades(@RequestBody Habilidades habilidades)
    {
        Persona ps = new Persona();
	ps.setId(PERSONA_ID); // 
        habilidades.setPersona(ps);
        Habilidades newHabilidades = habiServ.crearHabilidades(habilidades);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHabilidades);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Habilidades> verHabilidadeses()
    {
        
        return habiServ.verHabilidades();
    }
    @DeleteMapping("/delete/{id}")
    public void borrarHabilidades (@PathVariable Long id)
    {
        habiServ.borrarHabilidades(id);
    }
    @PutMapping("/editar")
     public ResponseEntity<Habilidades> editHabilidades
        (
                @Valid
                @RequestBody Habilidades skill,
                Errors errors
        )
        {
              if (errors.hasErrors()) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
              	
		Persona ps = new Persona();
		ps.setId(PERSONA_ID); 
                skill.setPersona(ps);
                Habilidades h = this.habiServ.buscarHabilidades(skill.getId());
                 if (h==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                 
                 h.setHabilidad(skill.getHabilidad());
                 h.setPorcentaje(skill.getPorcentaje());
                 h.setTipo(skill.getTipo());
                 Habilidades newHabilidades= this.habiServ.crearHabilidades(h);
                 return ResponseEntity.status(HttpStatus.OK).body(newHabilidades);
                
        }
               @GetMapping("/buscar/{id}")
        public Habilidades filtrarHabilidades(@PathVariable Long id){
            return habiServ.buscarHabilidades(id);
        }
}
