package br.com.starwars.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author mario.bacellar@gmail.com :: linkedin.com/in/mariobacellar
 *
 */
@Document(collection= "planeta")
public class Planeta {

	@Id
	private String id;
	
	private String nome;
    private String clima;
    private String terreno;
    private List<String> filmes;
 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public List<String> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<String> filmes) {
		this.filmes = filmes;
	}

	public int qtdFilmes() {
		return ( (this.filmes==null) ? 0  : this.filmes.size() );
	}
	

	@Override
	public String toString() {
		return "Planeta [id=(" + id + "), nome=(" + nome + "), clima=(" + clima + "), terreno=("+terreno+"), filmes=["+filmes+"]]";
	}

}