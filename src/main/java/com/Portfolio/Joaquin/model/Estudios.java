/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Joaquin.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
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
@Entity
@Getter @Setter
@Data
public class Estudios {
    
    public Estudios(){}
    @Id
    @GeneratedValue(strategy  =GenerationType.AUTO)
    private Long id;
    
    private String Titulo;
    private String Escuela; 
    private String Nivel;
    private LocalDate Inicio;
    private LocalDate Final;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	@JsonBackReference // evita la referencia circular a la hora de hacer el json
	private Persona persona;
}
