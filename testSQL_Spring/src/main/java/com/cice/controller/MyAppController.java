package com.cice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cice.DAO.ContratoDAO;
import com.cice.DAO.EntrenadorDAO;
import com.cice.models.Contrato;
import com.cice.models.Entrenador;


@RestController
@RequestMapping("/")
public class MyAppController {
	
	@Autowired
	private EntrenadorDAO entrenadorDAO;
	
	@Autowired 
	private ContratoDAO contratoDao;
	
	
	/**
	 * RECUPERAMOS TODOS LOS ENTRENADORES
	 * */
	@GetMapping("/entrenadores")
	public ResponseEntity<List<Entrenador>> getEntrenadores() {
		
		List<Entrenador> entrenadores = new ArrayList<>();
		try {
			entrenadores = entrenadorDAO.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Entrenador>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Entrenador>>(entrenadores, HttpStatus.OK);
	}
	/**
	 * GUARDAMOS UN ENTRENADOR
	 * */
	@PostMapping("/entrenadores")
	public ResponseEntity<Entrenador> postEntrenadores(@Valid @RequestBody Entrenador entrenador) {
		
		
		try {
		entrenadorDAO.saveAndFlush(entrenador);
		} catch (Exception e) {
			return new ResponseEntity<Entrenador>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Entrenador>(entrenador, HttpStatus.OK);
	}
	/**
	 * RECUPERAMOS TODOS LOS CONTRATPOS
	 * */
	@GetMapping("/contratos")
	public ResponseEntity<List<Contrato>> getContratos() {
		
		List<Contrato> contratos = new ArrayList<>();
		try {
			contratos = contratoDao.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Contrato>>(contratos, HttpStatus.OK);
	}
	/**
	 * RECUPERAMOS TODOS LOS CONTRATOS que pertenecen a un mismo Entrenador
	 * */
	@GetMapping("/contratos/{idEntrenador}")
	public ResponseEntity<List<Contrato>> getContratosporEntrenador(@PathVariable(value = "idEntrenador") Long noteId) {
		
		List<Contrato> contratos = new ArrayList<>();
		try {
			Optional<Entrenador> entrenador = entrenadorDAO.findById(noteId);
			if(entrenador.isPresent())contratos = contratoDao.findByEntrenador(entrenador.get());
			else return new ResponseEntity<List<Contrato>>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Contrato>>(contratos, HttpStatus.OK);
	}
	/**
	 * GUARDAMOS UN CONTRATO
	 * */
	@PostMapping("/contratos")
	public ResponseEntity<Contrato> postContratos(@Valid @RequestBody Contrato contrato) {
		
		
		try {
			contratoDao.saveAndFlush(contrato);
		} catch (Exception e) {
			return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
	}
	

}
