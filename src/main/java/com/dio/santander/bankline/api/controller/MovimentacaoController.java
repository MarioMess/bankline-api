package com.dio.santander.bankline.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.santander.bankline.api.dto.MovimentacaoDto;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Movimentacoes")
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return movimentacaoRepository.findAll();
		
	}
	
	@GetMapping("/{idConta}")
	public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
		return movimentacaoRepository.findByIdConta(idConta);
		
	}
	
	@PostMapping
	public void save(@RequestBody MovimentacaoDto movimentacao) {
	movimentacaoService.save(movimentacao);	
	}
}
