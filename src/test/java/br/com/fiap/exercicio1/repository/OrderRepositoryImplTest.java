package br.com.fiap.exercicio1.repository;

import br.com.fiap.exercicio1.dto.OrderDTO;
import br.com.fiap.exercicio1.rest.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderDTO.class)
public class OrderRepositoryImplTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private OrderRepository repository;


    @Test
    public void findById() {
        OrderDTO orderDTO = mock(OrderDTO.class);

        orderDTO.setIdPedido(1);
        when(this.repository.findById(orderDTO.getIdPedido())).thenReturn(orderDTO);

        verify(orderDTO).setIdPedido(1);
    }

    @Test
    public void findById2() throws Exception {
        OrderDTO orderDTO = mock(OrderDTO.class);

        orderDTO.setIdPedido(1);
        when(this.repository.findById(orderDTO.getIdPedido())).thenReturn(orderDTO);

        mvc.perform(get("/findbyid/"+orderDTO.getIdPedido())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(response -> {
                    String json = response.getResponse().getContentAsString();
                    OrderDTO orderFounded = new ObjectMapper().readValue(json, OrderDTO.class);
                    assertNotNull("Order null", orderFounded);
                });


        verify(orderDTO).setIdPedido(1);
    }

    @Test
    public void save() {
        OrderDTO orderDTO = mock(OrderDTO.class);

        orderDTO.setIdPedido(1);
        orderDTO.setNomeCompleto("Aline");
        orderDTO.setBandeira("Cielo");
        orderDTO.setFormaPagto("Debito");
        when(this.repository.save(orderDTO)).thenReturn(orderDTO);

        verify(orderDTO).setIdPedido(1);
        verify(orderDTO).setNomeCompleto("Teste");
        verify(orderDTO).setBandeira("Teste");
        verify(orderDTO).setFormaPagto("Teste");
    }

    @Test
    public void update() {
        OrderDTO orderDTO = mock(OrderDTO.class);

        orderDTO.setIdPedido(1);
        orderDTO.setNomeCompleto("Aline");
        orderDTO.setBandeira("Master");
        orderDTO.setFormaPagto("Credito");
        when(this.repository.update(orderDTO)).thenReturn(orderDTO);

        verify(orderDTO).setIdPedido(1);
        verify(orderDTO).setNomeCompleto("Teste");
        verify(orderDTO).setBandeira("Teste");
        verify(orderDTO).setFormaPagto("Teste");
    }

    @Test
    public void delete() {
        OrderDTO orderDTO = mock(OrderDTO.class);

        orderDTO.setIdPedido(1);
        assertEquals("Sucesso ao Excluir.", this.repository.delete(orderDTO.getIdPedido()));

    }
}
