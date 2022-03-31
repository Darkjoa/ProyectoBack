/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
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
public class Experiencia {
    public Experiencia(){}
    @Id
    @GeneratedValue(strategy  =GenerationType.AUTO)
    private Long id;
    
    private String Empresa;
    private String Cargo;
    private Date Inicio;
    private Date Final;
        @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	@JsonBackReference // evita la referencia circular a la hora de hacer el json
	private Persona persona;
    
    public Experiencia(    
    Long id,
    
    String Empresa,
    String Cargo,
    Date Inicio,
    Date Final
    )
    {
        this.id= id;
        
        this.Empresa = Empresa;
        this.Cargo = Cargo;
        this.Inicio = Inicio;
        this.Final = Final;
    }
}
