package br.com.fiap.exercicio1.rest;

import br.com.fiap.exercicio1.dto.OrderDTO;
import br.com.fiap.exercicio1.exception.InvalidOrderException;
import br.com.fiap.exercicio1.exception.OrderNotFoundException;
import br.com.fiap.exercicio1.repository.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Api(value = "Order", description = "Order Service REST API")
public class Service {

    @Autowired
    OrderRepository orderRepository;
    
    
    @ApiOperation(httpMethod = "GET", value = "Get Order By Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Returns Order and Success Status", response = OrderDTO.class)
    })
    @RequestMapping(value="findById/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> findById(@PathVariable(value="idPedido") int idPedido) {
        OrderDTO order = new OrderDTO();
        order = orderRepository.findById(idPedido);
        if(order == null){
            throw new OrderNotFoundException("Pedido não encontrado. Id - "+idPedido);
        }
        return new ResponseEntity<OrderDTO>(order, HttpStatus.valueOf(200));
    }

    @ApiOperation(httpMethod = "POST", value = "Post Order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns generated Order and Created Status", response = OrderDTO.class)
    })
    @RequestMapping(value="save", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> save(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrder = orderRepository.save(orderDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idPedido}")
                .buildAndExpand(savedOrder.getIdPedido()).toUri();
        return ResponseEntity.created(location).build();
    }


    @ApiOperation(httpMethod = "PATCH", value = "Update Order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns success Status")
    })
    @RequestMapping(value="update", method = RequestMethod.PUT)
    public ResponseEntity<OrderDTO> update(@Valid @RequestBody OrderDTO orderDTO) {
        if(orderDTO.getIdPedido() == 0){
            throw new InvalidOrderException("Registro inválido");
        }
        return new ResponseEntity<OrderDTO>(orderRepository.update(orderDTO), HttpStatus.valueOf(200));
    }

    @ApiOperation(httpMethod = "DELETE", value = "Delete Order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retuns Success Status")
    })
    @RequestMapping(value="delete/{idPedido}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable(value="idPedido")@Valid @RequestBody int idPedido) {
        return new ResponseEntity<String>(orderRepository.delete(idPedido), HttpStatus.valueOf(200));
    }
}
