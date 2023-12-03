package com.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.entity.Matricula;
import com.sistema.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	MatriculaRepository repository;

	@Override
	public List<Matricula> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Matricula insertaActualizaMatricula(Matricula matricula) {
		return repository.save(matricula);
	}

	@Override
	public void eliminaMatricula(int idmatricula) {
		repository.deleteById(idmatricula);
	}

	@Override
	public List<Matricula> listarMatriculaPorCorreo(String correoalumno) {
		return repository.listarMatriculaPorCorreo(correoalumno);
	}

	@Override
	public List<Matricula> listarMatriculaPorProfesor(String profesor) {
		return repository.listarMatriculaPorProfesor(profesor);
	}
	
	
	
}
