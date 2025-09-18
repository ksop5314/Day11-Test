package est.day11.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Column(name = "DELIVERY_ADDRESS", nullable = false)
    private String address;

    @Column(name = "DELIVERY_ZIPCODE")
    private String zipcode;

    @Builder
    public Delivery(String address, String zipcode) {
        this.address = address;
        this.zipcode = zipcode;
    }

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
