package scalable.solutions.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scalable.solutions.consumer.model.OrderDTO;

import java.util.List;

@FeignClient(name = "order", url = "http://localhost:8090")
public interface OrderClient {
    @GetMapping(value = "/order/{orderId}")
    ResponseEntity<OrderDTO> findOrder(@PathVariable long orderId);
    @GetMapping(value = "/orders")
    ResponseEntity<List<OrderDTO>> getOrders();
    @PostMapping(value = "/order")
    ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order);
    @PutMapping(value = "/order")
    ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO order);
    @DeleteMapping(value = "/order/{orderId}")
    ResponseEntity<OrderDTO> deleteOrder(@PathVariable long orderId);
}
