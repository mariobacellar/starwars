package br.com.starwars;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mario.bacellar@gmail.com :: linkedin.com/in/mariobacellar
 *
 */
@SpringBootApplication
public class StarWarsApplication {
	
	private static final Log log = LogFactory.getLog(StarWarsApplication.class);
	
	public static void main(String[] args) {
		log.debug("-> Stat StarWarsB2wApplication service...");
		SpringApplication.run(StarWarsApplication.class, args);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		log.debug("<-Shutting down StarWarsB2wApplication service");
	}
	
	
}
