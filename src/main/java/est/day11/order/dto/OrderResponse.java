package est.day11.order.dto;

import est.day11.order.entity.Order;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {

    private String orderNumber;
    private int totalPrice;
    private List<ProductResponse> productList;
    private DeliveryResponse delivery;

    @Builder
    public OrderResponse(String orderNumber, int totalPrice, List<ProductResponse> productList, DeliveryResponse delivery) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.productList = productList;
        this.delivery = delivery;
//        this.orderNumber = order.getOrderNumber();
//        this.totalPrice = order.getProducts().stream()
//            .mapToInt(p -> p.getPrice())
//            .sum();
//        this.productList = order.getProducts().stream()
//            .map(p -> {
//                return ProductResponse.of(p);
//            }).toList();
//        this.delivery = order.getDelivery();
    }

    public static OrderResponse fromEntity(Order order) {
        return OrderResponse.builder()
            .orderNumber(order.getOrderNumber())
            .totalPrice(order.getTotalPrice())
            .productList(order.getProducts().stream()
                .map(p -> ProductResponse.of(p))
                .toList())
            .delivery(new DeliveryResponse(order.getDelivery()))
            .build();

    }

}
