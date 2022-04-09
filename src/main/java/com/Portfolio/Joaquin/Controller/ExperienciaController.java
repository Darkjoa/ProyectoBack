 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;


import com.Portfolio.Joaquin.model.Experiencia;
import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.service.IExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
           //Experiencia
    private final long PERSONA_ID=1; //fk hardcodeada
        @Autowired
        private IExperienciaService experienciaServ;
        
    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia()
    {
        
        return experienciaServ.verExperiencia();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<Experiencia> agregarExperiencia(@RequestBody Experiencia experiencia)
    {
        Persona ps = new Persona();
        ps.setId(PERSONA_ID); //
        experiencia.setPersona(ps);
        Experiencia newExperiencia = experienciaServ.crearExperiencia(experiencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExperiencia);
        
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia (@PathVariable Long id)
    {
        experienciaServ.borrarExperiencia(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Experiencia> editExperiencia
        (
                @Valid
                @RequestBody Experiencia xp,
                Errors errors
        )
        {
            if (errors.hasErrors()) // devolver mensaje de los errores en lugar de solo un 400
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
                Experiencia e= this.experienciaServ.buscarExperiencia(xp.getId());
                if (e==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                e.setCargo(xp.getCargo());
                e.setEmpresa(xp.getEmpresa());
                e.setInicio(xp.getInicio());
                e.setFinal(xp.getFinal());
                Experiencia newExperiencia = this.experienciaServ.crearExperiencia(e);
                return ResponseEntity.status(HttpStatus.OK).body(newExperiencia);
            
        }
        @GetMapping("/buscar/{id}")
        public Experiencia filtrarExperiencia(@PathVariable Long id){
            return experienciaServ.buscarExperiencia(id);
        }
        
        //final de experiencia
}
