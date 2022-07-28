package application;

import entities.Order;
import enums.OrderStatus;

import java.util.Date;

public class Program {
    public static void main (String [] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);


        OrderStatus os1 = OrderStatus.DELIVERED;

        // valueOf é para quando eu recebi uma String e converto em enum (útil quando recebo o dado de um  formulário)
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);

    }
}
