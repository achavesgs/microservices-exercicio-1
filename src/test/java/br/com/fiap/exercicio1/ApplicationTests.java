package br.com.fiap.exercicio1;

import br.com.fiap.exercicio1.dto.OrderDTO;
import br.com.fiap.exercicio1.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private OrderRepository repository;

	

	@Test
	public void findByIdTest() {

	}

}
