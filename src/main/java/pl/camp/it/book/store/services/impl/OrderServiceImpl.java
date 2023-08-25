package pl.camp.it.book.store.services.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.camp.it.book.store.database.IOrderDAO;
import pl.camp.it.book.store.exceptions.BookNotExistException;
import pl.camp.it.book.store.exceptions.BookValidationException;
import pl.camp.it.book.store.exceptions.UserNotExistException;
import pl.camp.it.book.store.exceptions.UserValidationException;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.Order;
import pl.camp.it.book.store.model.OrderPosition;
import pl.camp.it.book.store.model.User;
import pl.camp.it.book.store.model.dto.OrderPositionDTO;
import pl.camp.it.book.store.model.dto.SaveOrderRequest;
import pl.camp.it.book.store.services.IBookService;
import pl.camp.it.book.store.services.IOrderService;
import pl.camp.it.book.store.services.IUserService;
import pl.camp.it.book.store.session.SessionData;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    SessionData sessionData;

    @Autowired
    IOrderDAO orderDAO;

    @Autowired
    IUserService userService;

    @Autowired
    IBookService bookService;

    @Override
    public List<Order> getAllOrdersForCurrentUser() {
        return this.orderDAO.getOrdersByUserId(this.sessionData.getUser().getId());
    }

    @Override
    public void persistOrder(Order order) {
        this.orderDAO.persistOrder(order);
    }

    @Override
    public Order persistOrder(SaveOrderRequest saveOrderRequest) {
        Optional<User> userBox = this.userService.getById(saveOrderRequest.getUserId());
        if(userBox.isEmpty()) {
            throw new UserNotExistException();
        }
        Order order = new Order(0, userBox.get(), saveOrderRequest.getStatus(),
                saveOrderRequest.getTotal(), saveOrderRequest.getDateTime());

        for(OrderPositionDTO orderPositionDTO : saveOrderRequest.getOrderPositions()) {
            Optional<Book> bookBox = this.bookService.getBookById(orderPositionDTO.getBookId());
            if(bookBox.isEmpty()) {
                throw new BookNotExistException();
            }
            OrderPosition orderPosition = new OrderPosition(0, bookBox.get(),
                    orderPositionDTO.getQuantity(), order);
            order.getOrderPositions().add(orderPosition);
        }
        this.orderDAO.persistOrder(order);
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return this.orderDAO.getOrdersByUserId(userId);
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return this.orderDAO.getOrderById(id);
    }
}
