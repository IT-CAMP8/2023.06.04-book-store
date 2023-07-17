package pl.camp.it.book.store.database.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IOrderDAO;
import pl.camp.it.book.store.database.sequence.IOrderIdSequence;
import pl.camp.it.book.store.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDAO implements IOrderDAO {

    private final List<Order> orders = new ArrayList<>();
    @Autowired
    IOrderIdSequence orderIdSequence;

    @Override
    public void persistOrder(Order order) {
        order.setId(this.orderIdSequence.getId());
        this.orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUserId(final int userId) {
        /*List<Order> result = new ArrayList<>();
        for(Order order : this.orders) {
            if(order.getUser().getId() == userId) {
                result.add(order);
            }
        }
        return result;*/
        return this.orders.stream().filter(o -> o.getUser().getId() == userId).toList();
    }

    @Override
    public Optional<Order> getOrderById(final int id) {
        /*for(Order order : this.orders) {
            if(order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();*/
        return this.orders.stream().filter(o -> o.getId() == id).findFirst();
    }
}
