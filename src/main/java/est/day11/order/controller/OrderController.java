package est.day11.order.controller;

import est.day11.order.dto.OrderAddRequest;
import est.day11.order.dto.OrderResponse;
import est.day11.order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> addOrder(@RequestBody OrderAddRequest orderAddRequest) {
        OrderResponse orderResponse = orderService.addOrder(orderAddRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<OrderResponse> orderList = orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
            .body(orderList);
    }

    @GetMapping("/only_orders")
    public ResponseEntity<List<OrderResponse>> onlyOrders() {
        List<OrderResponse> orderList = orderService.findAllOnlyOrders();
        return ResponseEntity.status(HttpStatus.OK)
            .body(orderList);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        OrderResponse orderResponse = orderService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(orderResponse);
    }

}
