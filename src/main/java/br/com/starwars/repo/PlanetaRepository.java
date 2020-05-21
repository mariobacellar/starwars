package br.com.starwars.repo;
 import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.starwars.model.Planeta;

/**
 * @author mario.bacellar@gmail.com :: linkedin.com/in/mariobacellar
 *
 */
@RepositoryRestResource(collectionResourceRel = "planeta", path = "planeta")
public interface PlanetaRepository extends MongoRepository<Planeta, String> , PlanetaRepositoryCustom{

	public List<Planeta> findByNome(@Param("nome") String nome);
	
}
