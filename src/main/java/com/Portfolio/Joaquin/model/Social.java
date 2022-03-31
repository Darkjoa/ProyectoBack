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

@Entity
@Getter @Setter
@Data
public class Social {
    public Social(){}
    @Id
    @GeneratedValue(strategy  =GenerationType.AUTO)
    private Long id;
    private String facebook; 
    private String instagram;
    private String linkedin;
    private String github;
    private String email;
        @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	@JsonBackReference // evita la referencia circular a la hora de hacer el json
	private Persona persona;

    public Social(Long id, String facebook, String instagram, String linkedin, String github, String email) {
        this.id = id;
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.github = github;
        this.email = email;
    }
    
}
