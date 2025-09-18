package est.day11.order.dto;

import est.day11.order.entity.Delivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponse {

    private String address;
    private String zipcode;

    public DeliveryResponse(Delivery delivery) {
        this.address = delivery.getAddress();
        this.zipcode = delivery.getZipcode();
    }

    public Delivery toEntity() {
        return Delivery.builder()
            .address(address)
            .zipcode(zipcode)
            .build();
    }

}
