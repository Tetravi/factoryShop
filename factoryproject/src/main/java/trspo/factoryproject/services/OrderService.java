package trspo.factoryproject.services;

import trspo.factoryproject.services.model.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    /*void addOrder(String type, double amount, int price,
                         String provider);*/
    public void addOrder(Order order);

    public List<Order> getAll();

    public Order getById(UUID id);

    public void deleteById(UUID id);
}
