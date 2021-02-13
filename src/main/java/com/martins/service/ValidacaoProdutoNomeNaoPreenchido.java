package com.martins.service;

import com.martins.dto.ProdutoRequest;

public class ValidacaoProdutoNomeNaoPreenchido implements ValidacaoProduto {

	public void valida(ProdutoRequest produto) throws Exception {
		if(produto.getNome().isEmpty()) {
			throw new IllegalArgumentException("Nome do produto é obrigatorio");
		}
	}

}
