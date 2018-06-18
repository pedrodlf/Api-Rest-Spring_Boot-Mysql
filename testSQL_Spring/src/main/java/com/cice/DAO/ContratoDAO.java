package com.cice.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cice.models.Contrato;
import com.cice.models.Entrenador;

public interface ContratoDAO extends JpaRepository<Contrato, Long>{

	List<Contrato> findByEntrenador(Entrenador entr);
	
}
