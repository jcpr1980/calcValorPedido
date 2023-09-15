package com.jcpribeiro.calcValorPedido.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcpribeiro.calcValorPedido.entities.Pedido;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double total(Pedido pedido) {
		
		return pedido.getBasic() - (pedido.getBasic() * pedido.getDiscount()/100) 
				+ shippingService.shipping(pedido.getBasic());

	}

}
