package pl.camp.it.book.store.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.camp.it.book.store.controllers.rest.RestConstants;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.OrderPosition;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPositionResponseDTO {
    private int id;
    private String book;
    private int quantity;
    private String order;

    public OrderPositionResponseDTO(OrderPosition orderPosition) {
        System.out.println(RestConstants.API_LOCATION);
        this.id = orderPosition.getId();
        this.book = RestConstants.API_LOCATION + "book/" + orderPosition.getBook().getId();
        this.quantity = orderPosition.getQuantity();
        this.order = RestConstants.API_LOCATION + "order/" + orderPosition.getOrder().getId();
    }
}
