package est.day11.order.service;

import est.day11.order.dto.OrderAddRequest;
import est.day11.order.dto.OrderResponse;
import est.day11.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse addOrder(OrderAddRequest orderAddRequest) {
        return OrderResponse.fromEntity(orderRepository.save(orderAddRequest.toEntity()));
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAllOrders().stream()
            .map(o -> OrderResponse.fromEntity(o))
            .toList();
    }

    public List<OrderResponse> findAllOnlyOrders() {
        return orderRepository.findAllOnlyOrders().stream()
            .map(o -> OrderResponse.fromEntity(o))
            .toList();
    }

    public OrderResponse findById(Long id) {
        return orderRepository.findById(id)
            .map(order -> OrderResponse.fromEntity(order))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "없는 주문번호 입니다."));
    }

}
