package scalable.solutions.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scalable.solutions.consumer.client.OrderClient;
import scalable.solutions.consumer.model.OrderDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "scalable.solutions:producer:+:stubs:8090")
public class ConsumerApplicationTests {

    @Autowired
    private OrderClient client;

    @Test
    void contextLoads() {
        // empty test that would fail if our Spring configuration does not load correctly
    }

    @Test
    public void findOrder() {
        ResponseEntity<OrderDTO> response = client.findOrder(2);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(new OrderDTO(2, "order 2")).isEqualTo(response.getBody());
    }

    @Test
    public void getOrders() {
        ResponseEntity<List<OrderDTO>> response = client.getOrders();
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void createOrder() {
        OrderDTO newOrder = new OrderDTO(100, "Laptop Dell Latitude 5330");
        ResponseEntity<OrderDTO> response = client.createOrder(newOrder);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(newOrder);
    }

    @Test
    public void updateOrder() {
        OrderDTO order = new OrderDTO(100, "Laptop Dell Latitude 5330");
        ResponseEntity<OrderDTO> response = client.updateOrder(order);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(new OrderDTO(100, "Spring Cloud Contact Test"));
    }

    @Test
    public void deleteOrder() {
        OrderDTO order = new OrderDTO(100, "order 100");
        ResponseEntity<OrderDTO> response = client.deleteOrder(100);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(order);
    }
}