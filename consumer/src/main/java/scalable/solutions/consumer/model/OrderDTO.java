package scalable.solutions.consumer.model;

import java.util.Objects;

public class OrderDTO {
    private long id;
    private String description;

    public OrderDTO() {
        // nop
    }

    public OrderDTO(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return id == orderDTO.id && Objects.equals(description, orderDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
