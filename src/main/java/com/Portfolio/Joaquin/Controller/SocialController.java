/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.Controller;


import com.Portfolio.Joaquin.model.Persona;
import com.Portfolio.Joaquin.model.Social;
import com.Portfolio.Joaquin.service.Isocial;
import com.Portfolio.Joaquin.service.SocialService;



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
@RequestMapping("/social")
@CrossOrigin(origins = "*")
public class SocialController {
    private final long PERSONA_ID=1; 
    @Autowired
    private Isocial socServ;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<Social> agregarSocial(@RequestBody Social social)
    {
        Persona ps = new Persona();
        ps.setId(PERSONA_ID); //
        social.setPersona(ps);
        Social newSocial= socServ.crearSocial(social);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSocial); 
    }
    @GetMapping("/ver")
    @ResponseBody
    public List<Social> verSocial()
    {
        
        return socServ.verSocial();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarSobreMi (@PathVariable Long id)
    {
        socServ.borrarSocial(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Social> editSobreMi
        (
                @Valid
                @RequestBody Social social,
                Errors errors
        )
        {
            if (errors.hasErrors()) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            Social s = this.socServ.buscarSocial(social.getId());
            if(s==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            s.setFacebook(social.getFacebook());
            s.setEmail(social.getEmail());
            s.setGithub(social.getGithub());
            s.setInstagram(social.getInstagram());
            s.setLinkedin(social.getLinkedin());
            Social newSocial = this.socServ.crearSocial(s);
            return ResponseEntity.status(HttpStatus.OK).body(newSocial);
        }
}
