package com.sistema.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.entity.Matricula;
import com.sistema.service.MatriculaService;
import com.sistema.util.Constantes;

@RestController
@RequestMapping("/api/matricula")
@CrossOrigin(origins = "*")
public class MatriculaController {
	
	
	/*
	 * GET http://localhost:8093/api/matricula POST
	 * http://localhost:8093/api/matricula/RegistraMatricula PUT
	 * http://localhost:8093/api/matricula/ActualizaMatricula DELETE
	 * http://localhost:8093/api/matricula/EliminaMatricula/1 GET
	 * http://localhost:8093/api/matricula/listaPorCorreo?correoalumno=correo_ejemplo
	 * http://localhost:8093/api/matricula/listaPorProfesor?profesor=nombre_profesor
	 */	
	
	
	@Autowired
	private MatriculaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaMatriculas() {
		List<Matricula> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Matricula>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraMatricula")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMatricula(@RequestBody Matricula matricula) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Matricula objSalida = service.insertaActualizaMatricula(matricula);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/ActualizaMatricula")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaMatricula(@RequestBody Matricula matricula) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Matricula objSalida = service.insertaActualizaMatricula(matricula);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/EliminaMatricula/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaMatricula(@PathVariable("id") int idmatricula) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaMatricula(idmatricula);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaPorCorreo")
	public ResponseEntity<?>  listaPorCorreo(
		@RequestParam(name = "correoalumno", defaultValue = "%", required = false ) String correoalumno) {
		List<Matricula> lstMatricula = service.listarMatriculaPorCorreo("%"+correoalumno+"%");
		return ResponseEntity.ok(lstMatricula);
	}
	
	@GetMapping("/listaPorProfesor")
	public ResponseEntity<?>  listaPorProfesor(
		@RequestParam(name = "profesor", defaultValue = "%", required = false ) String profesor) {
		List<Matricula> lstMatricula = service.listarMatriculaPorProfesor("%"+profesor+"%");
		return ResponseEntity.ok(lstMatricula);
	}

}
