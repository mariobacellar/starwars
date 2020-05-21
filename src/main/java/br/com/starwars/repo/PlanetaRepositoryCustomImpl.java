package br.com.starwars.repo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.starwars.model.Planeta;

/**
 * @author mario.bacellar@gmail.com :: linkedin.com/in/mariobacellar
 *
 */
public class PlanetaRepositoryCustomImpl implements InitializingBean, PlanetaRepositoryCustom { 

	@Autowired
	private MongoTemplate mongoTemplate;

	private Planeta planeta;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public String findQtdFilmesById(String id) {
		planeta =  mongoTemplate.findById( new ObjectId(id), Planeta.class, "planeta");
		String qtd = ""+planeta.getFilmes().size();
		return "{\"nome\": \""+qtd+"\"}";
	}

}



