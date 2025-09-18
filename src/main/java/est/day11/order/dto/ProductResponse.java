package est.day11.order.dto;

import est.day11.order.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {
    private final String productName;
    private final int productPrice;

    @Builder
    public ProductResponse(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
            .productName(product.getName())
            .productPrice(product.getPrice())
            .build();
    }


}
