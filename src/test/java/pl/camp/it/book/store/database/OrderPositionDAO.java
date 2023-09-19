package pl.camp.it.book.store.database;

import pl.camp.it.book.store.model.OrderPosition;

import java.util.List;
import java.util.Optional;

public class OrderPositionDAO implements IOrderPositionDAO {
    @Override
    public void persist(OrderPosition orderPosition, int orderId) {

    }

    @Override
    public List<OrderPosition> getByOrderId(int orderId) {
        return null;
    }

    @Override
    public Optional<OrderPosition> getById(int id) {
        return Optional.empty();
    }
}
