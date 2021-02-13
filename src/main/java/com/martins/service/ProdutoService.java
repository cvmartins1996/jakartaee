package com.martins.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.martins.dto.ProdutoRequest;
import com.martins.dto.ProdutoResponse;

@Stateless
public class ProdutoService {
	
	private static Map<String, ProdutoResponse> produtosRepositorio = new HashMap<>();
	
	static {
		produtosRepositorio.put("1", new ProdutoResponse("xpto", "descricao qualquer"));
		produtosRepositorio.put("2", new ProdutoResponse("segundo produto", "descricao qualquer"));
	}
	
	public ProdutoResponse getProdutoPeloId(String id) {
		return produtosRepositorio.get(id);
	}
	
	public List<ProdutoResponse> getProdutos(){
		return new ArrayList<>(produtosRepositorio.values());
	}
	
	public void criarProduto(ProdutoRequest produto) throws Exception {
		List<ValidacaoProduto> validacoes = Arrays.asList(new ValidacaoProdutoNulo(), new ValidacaoProdutoNomeNaoPreenchido());
		
		for (ValidacaoProduto validacaoProduto : validacoes) {
			validacaoProduto.valida(produto);
		}
		
		ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(), produto.getDescricao());
		produtosRepositorio.put("3", produtoResponse);
	}

}
