package est.day11.order.dto;

import est.day11.order.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddRequest {

    private String productName;
    private int productPrice;

    public Product toEntity() {
        return Product.builder()
            .name(productName)
            .price(productPrice)
            .build();
    }

}
