package br.com.fiap.exercicio1.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OrderDTO {

	@ApiModelProperty( notes = "User E-mail")
    private String email;
	
	@ApiModelProperty( notes = "User Name")
	private String nomeCompleto;
	
	@ApiModelProperty( notes = "User Shipping Address")
    private String shippingAdress;
	
	@ApiModelProperty(notes = "The database generated Order ID")
    private int idPedido;
	
	@ApiModelProperty(notes = "The order description")
    private String dsItemPedido;
	
	@ApiModelProperty(notes = "The order item quantity")
    private String qtdItemPedido;
	
	@ApiModelProperty( notes = "Item Amount")
    private BigDecimal vlPrecoItem;
	
	@ApiModelProperty( notes = "Total Amount")
    private BigDecimal vlPrecoTotal;
	
	@ApiModelProperty( notes = "Payment Gateway")
    private String formaPagto;
	
	@ApiModelProperty( notes = "Order Date")
    private String dtPedido;
	
	@ApiModelProperty( notes = "Order Status")
    private String statusPedido;

    @ApiModelProperty( notes = "Transaction ID")
    private String idTransacao;
    
    @ApiModelProperty( notes = "Credit card number")
    private String nroCartao;
    
    @ApiModelProperty( notes = "Credit card validity")
    private String validadeCartao;
    
    @ApiModelProperty( notes = "Card banner")
    private String bandeira;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDsItemPedido() {
        return dsItemPedido;
    }

    public void setDsItemPedido(String dsItemPedido) {
        this.dsItemPedido = dsItemPedido;
    }

    public String getQtdItemPedido() {
        return qtdItemPedido;
    }

    public void setQtdItemPedido(String qtdItemPedido) {
        this.qtdItemPedido = qtdItemPedido;
    }

    public BigDecimal getVlPrecoItem() {
        return vlPrecoItem;
    }

    public void setVlPrecoItem(BigDecimal vlPrecoItem) {
        this.vlPrecoItem = vlPrecoItem;
    }

    public BigDecimal getVlPrecoTotal() {
        return vlPrecoTotal;
    }

    public void setVlPrecoTotal(BigDecimal vlPrecoTotal) {
        this.vlPrecoTotal = vlPrecoTotal;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

    public String getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(String dtPedido) {
        this.dtPedido = dtPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getNroCartao() {
        return nroCartao;
    }

    public void setNroCartao(String nroCartao) {
        this.nroCartao = nroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
