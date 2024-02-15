package com.alexandre.oliveira.totalorder;

import com.alexandre.oliveira.totalorder.entities.Order;
import com.alexandre.oliveira.totalorder.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TotalOrderApplication implements CommandLineRunner {

	private final OrderService orderService;

    public TotalOrderApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
		SpringApplication.run(TotalOrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Código: ");
		Integer numeroPedido = scanner.nextInt();

		System.out.print("Valor básico: ");
		Double valorBasico = scanner.nextDouble();

		System.out.print("Porcentagem de desconto: ");
		Double percentualDesconto = scanner.nextDouble();

		Order order = new Order(numeroPedido, valorBasico, percentualDesconto);
		Double total = orderService.total(order);
		System.out.println("Pedido código " + numeroPedido);
		System.out.printf("Valor total: R$ %.2f%n", total);
		scanner.close();
	}
}
