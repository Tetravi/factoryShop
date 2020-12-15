package trspo.factoryproject.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trspo.factoryproject.services.OrderService;
import trspo.factoryproject.services.impl.OrderServiceImpl;
import trspo.factoryproject.services.model.Order;
import trspo.factoryproject.services.model.dto.createOrderDTO;

import java.util.UUID;

@RestController
@RequestMapping("/my_order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    /*@GetMapping(path="/getAll")
    public List<Order> index() { return orderService.getAll(); }

    @GetMapping("{orderId}")
    public Order getById(@PathVariable(value = "orderId") UUID id) {
        return orderService.getById(id);
    }*/

    /*@PostMapping(path="/crOrder")
    public ResponseEntity<Void> createOrder(@RequestBody createOrderDTO orderDto){
        Order order = new Order(orderDto.getType(), orderDto.getAmount(),
                orderDto.getPrice(), orderDto.getProvider());
        order.setId();
        orderService.addOrder(order);
        return ResponseEntity.ok().build();
    }*/

    @DeleteMapping("{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(value = "orderId") UUID id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
