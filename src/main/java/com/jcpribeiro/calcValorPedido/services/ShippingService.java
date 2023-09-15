package com.jcpribeiro.calcValorPedido.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {
	
	public double shipping(double valueBasic) {
		
		double valueShipping;
		
		if (valueBasic < 100.00) {
			valueShipping = 20.00;
		} else if (valueBasic >= 100.00 && valueBasic < 200.00) {
			valueShipping = 12.00;
		}else {
			valueShipping = 0.00;
		}
		return valueShipping;
	}

}
