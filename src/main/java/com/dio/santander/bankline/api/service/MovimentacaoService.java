package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.santander.bankline.api.dto.MovimentacaoDto;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.MonvimentacaoTipo;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	public void save(MovimentacaoDto novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		Double valor  = novaMovimentacao.getTipo() == MonvimentacaoTipo.RECEITA? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		movimentacaoRepository.save(movimentacao);		
	}
}
