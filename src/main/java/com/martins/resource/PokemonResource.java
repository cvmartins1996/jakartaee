package com.martins.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.martins.dto.Pokemon;

@Path("pokemon")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource {
	
	private Client client;

	public PokemonResource() {
		this.client = ClientBuilder.newClient();
	}
	
	@GET
	public Response getPokemonPeloNome() throws URISyntaxException {
		WebTarget target = client.target(new URI("https://pokeapi.co/api/v2/"));
		String response = target.path("pokemon/ditto").request().get(String.class);
		Pokemon pokemon = JsonbBuilder.create().fromJson(response, Pokemon.class);
		return Response.ok(pokemon).build();
	}
	
	
}
