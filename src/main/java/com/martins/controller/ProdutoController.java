package com.martins.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.martins.dto.ProdutoRequest;
import com.martins.dto.ProdutoResponse;
import com.martins.service.ProdutoService;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProdutoController {
	
	@Inject
	private ProdutoService produtoService;
	
	@GET
	public Response getProdutos() {
		return Response.ok(produtoService.getProdutos()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getProdutoPeloId(@PathParam("id") String id) {
		ProdutoResponse produtoPeloId = produtoService.getProdutoPeloId(id);
		
		if(produtoPeloId == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
		}
		
		return Response.ok(produtoPeloId).build();
	}
	
	@POST
	public Response criaProduto(ProdutoRequest produto) {
		try {
			produtoService.criarProduto(produto);
			return Response.status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
		}
		
	}
}
