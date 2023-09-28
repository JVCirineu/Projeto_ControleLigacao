package com.projetoControleDeLIgacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoControleDeLIgacoes.entities.Agenda;
import com.projetoControleDeLIgacoes.repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;

	@Autowired
	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

	public List<Agenda>buscaTodosAgenda(){
		return agendaRepository.findAll();
	}

	public Agenda buscaAgendaId(Long id) {
		Optional<Agenda> agenda = agendaRepository.findById(id);
		return agenda.orElse(null);
	}

	public Agenda salvaAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	public Agenda alterarAgenda(Long id, Agenda alterarProd) {
		Optional<Agenda> existeAgenda = agendaRepository.findById(id);
		if(existeAgenda.isPresent()) {
			alterarProd.setId(id);
			return agendaRepository.save(alterarProd);
		}
		return null;
	}

	public boolean apagarAgenda(Long id) {
		Optional<Agenda> existeAgenda = agendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			agendaRepository.deleteById(id);
			return true;
		}
		return false;
	}


}



