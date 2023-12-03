package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

	// Listar por correo alumno
	@Query("select m from Matricula m where m.correoalumno like ?1 ")
	List<Matricula> listarMatriculaPorCorreo(String correoalumno);

	// Listar por profesor
	@Query("select m from Matricula m where m.profesor like ?1 ")
	List<Matricula> listarMatriculaPorProfesor(String profesor);
}
