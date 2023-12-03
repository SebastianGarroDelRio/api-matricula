package com.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "matricula")
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmatricula")
	private Integer idmatricula;
	
	@Column(name = "correoalumno", unique = true, nullable = false)
	private String correoalumno;
	
	@Column(name = "curso")
	private String curso;
	
	@Column(name = "profesor")
	private String profesor;
	
	@Column(name = "horario")
	private String horario;
	
	@Column(name = "estado")
	private String estado; 
	//reservado, validado

}
