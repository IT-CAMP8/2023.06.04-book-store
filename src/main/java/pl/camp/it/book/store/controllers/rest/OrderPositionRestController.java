package pl.camp.it.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.model.OrderPosition;
import pl.camp.it.book.store.model.dto.OrderPositionDTO;
import pl.camp.it.book.store.model.dto.OrderPositionListResponse;
import pl.camp.it.book.store.model.dto.OrderPositionResponseDTO;
import pl.camp.it.book.store.services.IOrderPositionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/order-position")
public class OrderPositionRestController {
    @Autowired
    IOrderPositionService orderPositionService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderPositionResponseDTO> getById(@PathVariable int id) {
        Optional<OrderPosition> orderPositionBox = this.orderPositionService.getById(id);
        return orderPositionBox.map(op -> ResponseEntity.ok(new OrderPositionResponseDTO(op)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.GET)
    public OrderPositionListResponse getByOrderId(@RequestParam int orderId) {
        return new OrderPositionListResponse(
                this.orderPositionService.getByOrderId(orderId).stream()
                        .map(OrderPositionResponseDTO::new).toList());
    }
}
