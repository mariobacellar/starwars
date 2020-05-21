package br.com.starwars;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.com.starwars.repo.PlanetaRepository;

/**
 * @author mario.bacellar@gmail.com :: linkedin.com/in/mariobacellar
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsApplicationTests {

	private String _massaTatooineFilmes = " \"filmes\":[ \"http://swapi.dev/api/films/1/\", \"http://swapi.dev/api/films/3/\", \"http://swapi.dev/api/films/4/\", \"http://swapi.dev/api/films/5/\", \"http://swapi.dev/api/films/6/\"]";
	private String _massaAlderaanFilmes = " \"filmes\":[ \"http://swapi.dev/api/films/1/\", \"http://swapi.dev/api/films/6/\" ]";
	
	private String _massaTatooine = "{\"nome\": \"Tatooine\", \"clima\":\"arido\"    , \"terreno\":\"deserto\", " + _massaTatooineFilmes + "}";
	private String _massaAlderaan = "{\"nome\": \"Alderaan\", \"clima\":\"temperado\", \"terreno\":\"planicies, montanhas\","+_massaAlderaanFilmes +" }";
	
	private String _path="/planeta";
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PlanetaRepository planetaRepository;

	@BeforeEach
	public void deleteAllBeforeTests() throws Exception {
		planetaRepository.deleteAll();
	}
	
	@Test
	public void shouldReturnRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$._links.planeta").exists());
	}

	@Test
	public void shouldCreateEntity() throws Exception {
		System.out.println(_massaTatooine);
		mockMvc.perform(post(_path).content( _massaTatooine )).andExpect( status().isCreated()).andExpect( header().string("Location", containsString("planeta/")));
		
	}



	@Test
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post(_path).content( _massaTatooine )).andExpect( status().isCreated()).andReturn();

		String location =  mvcResult.getResponse().getHeader("Location");
		
		mockMvc.perform(get(location)).
				andExpect( status().isOk()).
				andExpect( jsonPath("$.nome")   .value("Tatooine")).
				andExpect( jsonPath("$.clima")  .value("arido"   )).
				andExpect( jsonPath("$.terreno").value("deserto" ));
		
	}

	@Test
	public void shouldQueryEntity() throws Exception {

		String _searchFindByNome = "/planeta/search/findByNome?nome={nome}";
		
		mockMvc.perform( post("/planeta").content( _massaTatooine )).andExpect( status().isCreated());

		mockMvc.perform( get(_searchFindByNome, "Tatooine")).
		                 andExpect( status().isOk()).
		                 andExpect( jsonPath("$._embedded.planeta[0].nome").value("Tatooine")).
		                 andExpect( jsonPath("$._embedded.planeta[0].clima").value("arido")).
		                 andExpect( jsonPath("$._embedded.planeta[0].terreno").value("deserto"));
	}
	
	

	@Test
	public void shouldQueryQtdFilmes() throws Exception {
		
		String _searchFindByNome        = "/planeta/search/findByNome?nome={nome}";
		String _searchFindQtdFilmesById = "/planeta/search/findQtdFilmesById?id={id}";
		
		MvcResult mvcResult = mockMvc.perform(post(_path).content( _massaTatooine )).andExpect( status().isCreated()).andReturn();
		String    location  =  mvcResult.getResponse().getHeader("Location");
		
		MvcResult mvcResult2 = mockMvc.perform( get(location)).andExpect(status().isOk()).andReturn();
		
		String pathInfo = mvcResult2.getRequest().getPathInfo();
		String _id= _id=pathInfo.substring(pathInfo.lastIndexOf('/')+1);
		
		MvcResult mvcResultId = mockMvc.perform( get(_searchFindQtdFilmesById,_id)).andExpect( status().isOk()).andReturn();
		
		
		String    contentId   = mvcResultId.getResponse().getContentAsString();
	}
	
	
	
	
	@Test
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post(_path).content( _massaTatooine )).andExpect( status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform( put(location).content(_massaAlderaan )).andExpect( status().isNoContent());
		mockMvc.perform( get(location)).andExpect(status().isOk());
	}

	@Test
	public void shouldPartiallyUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/planeta").content( _massaAlderaan )).andExpect( status().isCreated()).andReturn();
		String    location  = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform( patch(location).
				         content("{\"terreno\": \"pantanoso\"}")).
		                 andExpect( status().isNoContent());
		
		mockMvc.perform( get(location)).andExpect(status().isOk());
	}

	@Test
	public void shouldDeleteEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/planeta").content( _massaAlderaan )).andExpect( status().isCreated()).andReturn();
		String    location  = mvcResult.getResponse().getHeader("Location");
		
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get   (location)).andExpect(status().isNotFound());
	}
}
