package trspo.factoryproject.services.model.dto;

import trspo.factoryproject.services.model.Order;


public class OrdersDTO {
    private Order order;

    public OrdersDTO(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
