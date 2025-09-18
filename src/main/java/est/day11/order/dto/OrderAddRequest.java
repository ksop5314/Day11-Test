package est.day11.order.dto;

import static java.util.stream.Collectors.toList;

import est.day11.order.entity.Delivery;
import est.day11.order.entity.Order;
import est.day11.order.entity.Product;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddRequest {

    private String orderNumber;
    private int totalPrice;
    private List<Product> productList;
    private Delivery delivery;

    public Order toEntity() {
        return Order.builder()
            .orderNumber(orderNumber)
            .totalPrice(productList.stream()
                .mapToInt(p -> p.getPrice())
                .sum())
            .productList(productList.stream().toList())
            .delivery(delivery)
            .build();
    }

}
