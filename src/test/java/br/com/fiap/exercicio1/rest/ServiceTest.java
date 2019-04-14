package br.com.fiap.exercicio1.rest;
 
import br.com.fiap.exercicio1.dto.OrderDTO;
import br.com.fiap.exercicio1.repository.OrderRepository;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.containsString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
 
 
@RunWith(SpringRunner.class)
@WebMvcTest(OrderRepository.class)
public class ServiceTest {
   
	@Autowired
	private MockMvc mvc;
	
	@MockBean
      private OrderRepository repository;
    
    @InjectMocks
      private Service service = new Service();
 
    @Test
    public void notFoundOrder() throws Exception {
        int id = 1;
        mvc.perform(get("/findById/"+id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andExpect(content().string(containsString("Pedido não encontrado")));
    }
    
    @Test
    public void findById() {
        OrderDTO orderDTO = new OrderDTO();
 
        orderDTO.setIdPedido(1);
        
        when(this.service.findById(orderDTO.getIdPedido())).thenReturn(new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.valueOf(200)));
 
        service.findById(orderDTO.getIdPedido());
    }
 
    @Test
    public void save() {
        OrderDTO orderDTO = new OrderDTO();
 
        orderDTO.setIdPedido(1);
        orderDTO.setBandeira("Visa");
        orderDTO.setDsItemPedido("Teste");
        orderDTO.setEmail("teste@teste.com.br");
        orderDTO.setDtPedido("05/04/2019");
        orderDTO.setFormaPagto("Debito");
        orderDTO.setIdTransacao("1");
        orderDTO.setNomeCompleto("Aline Chaves");
        orderDTO.setNroCartao("1234567890");
        orderDTO.setQtdItemPedido("10");
 
        service.save(orderDTO);
    }
 
    @Test
    public void update() {
        OrderDTO orderDTO = new OrderDTO();
 
          orderDTO.setIdPedido(0);
          orderDTO.setBandeira("Visa");
          orderDTO.setDsItemPedido("Teste");
          orderDTO.setEmail("teste@teste.com.br");
          orderDTO.setDtPedido("05/04/2019");
          orderDTO.setFormaPagto("Debito");
          orderDTO.setIdTransacao("1");
          orderDTO.setNomeCompleto("Aline Chaves");
          orderDTO.setNroCartao("1234567890");
          orderDTO.setQtdItemPedido("10");
 
          service.update(orderDTO);
    }
 
    @Test
    public void delete() {
      service.delete(1);
    }
}
