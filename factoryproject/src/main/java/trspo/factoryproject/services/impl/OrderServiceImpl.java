package trspo.factoryproject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trspo.factoryproject.repo.OrderRepository;
import trspo.factoryproject.services.OrderService;
import trspo.factoryproject.services.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository OrderRepository;

    @Transactional
    public void addOrder(Order order) {
        OrderRepository.save(order);
    }

    public List<Order> getAll() {
        return OrderRepository.findAll();
    }

    public Order getById(UUID id) {
        return OrderRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        OrderRepository.deleteById(id);
    }
}
