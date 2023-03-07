package scalable.solutions.producer.controller;

import scalable.solutions.producer.model.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<OrderDTO> findOrder(@PathVariable long orderId) {
        OrderDTO order = new OrderDTO(orderId, "order " + orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping(value = "/order")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order) {
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping(value = "/order")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO order) {
        order.setDescription("Spring Cloud Contact Test");
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable long orderId) {
        OrderDTO order = new OrderDTO(orderId, "order " + orderId);
        return ResponseEntity.ok(order);
    }
}
