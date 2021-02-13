package com.martins.service;

import com.martins.dto.ProdutoRequest;

public class ValidacaoProdutoNulo implements ValidacaoProduto {

	public void valida(ProdutoRequest produto) throws Exception {
		if(produto == null) {
			throw new IllegalAccessException("Produto deve estar preenchido");
		}
	}

}
