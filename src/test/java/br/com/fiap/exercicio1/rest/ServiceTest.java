package br.com.fiap.exercicio1.rest;
 
import br.com.fiap.exercicio1.dto.OrderDTO;
import br.com.fiap.exercicio1.repository.OrderRepository;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
 
 
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(OrderRepository.class)
public class ServiceTest {
   
    @Mock
      private OrderRepository repository;
    
    @InjectMocks
      private Service service = new Service();
 
    @Test
    public void findById() {
        OrderDTO orderDTO = new OrderDTO();
 
        orderDTO.setIdPedido(1);
 
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
