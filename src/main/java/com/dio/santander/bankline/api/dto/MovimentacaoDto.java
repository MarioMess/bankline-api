package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.model.MonvimentacaoTipo;

public class MovimentacaoDto {
	private String descricao;
	private Double valor;	
	private MonvimentacaoTipo tipo;	
	private Integer idConta;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public MonvimentacaoTipo getTipo() {
		return tipo;
	}
	public void setTipo(MonvimentacaoTipo tipo) {
		this.tipo = tipo;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	
}
