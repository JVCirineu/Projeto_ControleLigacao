package com.projetoControleDeLIgacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoControleDeLIgacoes.entities.Ligacao;
import com.projetoControleDeLIgacoes.repository.LigacaoRepository;



@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository;

	@Autowired
	public LigacaoService(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}

	public List<Ligacao>buscaTodosAgenda(){
		return ligacaoRepository.findAll();
	}

	public Ligacao buscaLigacaoId(Long id) {
		Optional<Ligacao> ligacao = ligacaoRepository.findById(id);
		return ligacao.orElse(null);
	}

	public Ligacao salvaAgenda(Ligacao ligacao) {
		return ligacaoRepository.save(ligacao);
	}

	public Ligacao alterarLigacao(Long id, Ligacao alterarLig) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if(existeLigacao.isPresent()) {
			alterarLig.setId(id);
			return ligacaoRepository.save(alterarLig);
		}
		return null;
	}

	public boolean apagarLigacao(Long id) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			ligacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}


}





