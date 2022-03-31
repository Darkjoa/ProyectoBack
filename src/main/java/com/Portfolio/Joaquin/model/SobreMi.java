/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Data
public class SobreMi {
    public SobreMi(){}
    
    @Id
    @GeneratedValue(strategy  =GenerationType.AUTO)
    private Long id;
    
    private String NombreDato;
    private String Dato;
        @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	@JsonBackReference // evita la referencia circular a la hora de hacer el json
	private Persona persona;
    public SobreMi
        ( 
                Long id,
                
                String NombreDato,
                String Dato
    
        )
    
        {
            this.id=id;
            
            this.NombreDato = NombreDato;
            this.Dato = Dato;
    
        }
}
