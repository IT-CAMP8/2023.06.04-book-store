package pl.camp.it.book.store.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IOrderDAO;
import pl.camp.it.book.store.model.Order;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDAO implements IOrderDAO {

    @Autowired
    Connection connection;

    @Override
    public void persistOrder(Order order) {

    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return null;
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return Optional.empty();
    }
}
