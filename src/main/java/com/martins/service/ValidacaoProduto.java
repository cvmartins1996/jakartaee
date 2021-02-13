package com.martins.service;

import com.martins.dto.ProdutoRequest;

public interface ValidacaoProduto {
	
	public void valida(ProdutoRequest produto) throws Exception;

}
