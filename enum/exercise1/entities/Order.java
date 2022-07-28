package entities;

import enums.OrderStatus;

import java.util.Date;

public class Order {

    private int id;
    private Date moment;
    private OrderStatus status;

    public Order (int id, Date moment, OrderStatus status){
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public int getId (){
        return id;
    }
    public Date getMoment (){
        return moment;
    }
    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    @Override
    public String toString(){
        return "Order [id=" + id +
                ", moment=" + moment +
                ", status=" + status + "]";
    }

}