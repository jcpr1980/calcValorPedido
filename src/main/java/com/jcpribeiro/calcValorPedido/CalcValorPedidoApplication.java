package com.jcpribeiro.calcValorPedido;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jcpribeiro.calcValorPedido.entities.Pedido;
import com.jcpribeiro.calcValorPedido.services.OrderService;
import com.jcpribeiro.calcValorPedido.services.ShippingService;

@SpringBootApplication
public class CalcValorPedidoApplication implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;	

	@Autowired
	private ShippingService shippingService;	

	public static void main(String[] args) {
		SpringApplication.run(CalcValorPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados do Pedido");
		System.out.print("Informe o código do pedido: ");
		int codePedido = sc.nextInt();
		System.out.print("Informe o Valor Básico: ");
		double basicPedido = sc.nextDouble(); 
		System.out.print("Informe o Desconto(%): ");
		double discountPedido = sc.nextDouble(); 
		
		Pedido pedido = new Pedido(codePedido, basicPedido, discountPedido);
		
		System.out.println("Pedido código: " + codePedido);
		System.out.println("Valor Total: R$" + orderService.total(pedido));
		
		
	}

}
