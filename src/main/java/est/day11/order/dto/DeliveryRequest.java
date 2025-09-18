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
public class DeliveryRequest {

    private String address;
    private String zipcode;

}
