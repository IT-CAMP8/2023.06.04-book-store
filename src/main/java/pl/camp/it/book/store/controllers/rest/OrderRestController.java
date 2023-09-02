package pl.camp.it.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.exceptions.BookNotExistException;
import pl.camp.it.book.store.exceptions.UserNotExistException;
import pl.camp.it.book.store.model.Order;
import pl.camp.it.book.store.model.dto.OrderDTO;
import pl.camp.it.book.store.model.dto.OrderListResponse;
import pl.camp.it.book.store.model.dto.SaveOrderRequest;
import pl.camp.it.book.store.services.IOrderService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrderRestController {

    @Autowired
    IOrderService orderService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable int id) {
        Optional<Order> orderBox = this.orderService.getOrderById(id);
        return orderBox.map(order -> ResponseEntity.ok(new OrderDTO(order)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.GET)
    public OrderListResponse getOrdersByUserId(@RequestParam int userId) {
        return new OrderListResponse(this.orderService.getOrdersByUserId(userId).stream()
                .map(OrderDTO::new)
                .toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody SaveOrderRequest orderDTO) {
        try {
            return ResponseEntity.ok(new OrderDTO(this.orderService.persistOrder(orderDTO)));
        } catch (UserNotExistException | BookNotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
