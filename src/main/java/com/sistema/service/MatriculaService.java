package com.sistema.service;

import java.util.List;

import com.sistema.entity.Matricula;

public interface MatriculaService {
	
	public abstract List<Matricula> listaTodos();
	public abstract Matricula insertaActualizaMatricula(Matricula matricula);
	public abstract void eliminaMatricula(int idmatricula);
	
	public List<Matricula>  listarMatriculaPorCorreo(String correoalumno);
	public List<Matricula>  listarMatriculaPorProfesor(String profesor);
	
}
