package pl.camp.it.book.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
    private final Set<OrderPosition> orderPositions = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private Status status;
    private double total;
    private LocalDateTime dateTime;

    public Order(int id) {
        this.id = id;
    }

    public String getPrettyTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return this.dateTime.format(formatter);
    }

    public void addOrderPosition(OrderPosition orderPosition) {
        this.orderPositions.add(orderPosition);
        orderPosition.setOrder(this);
    }

    public enum Status {
        NEW,
        PAID,
        SENT,
        DONE
    }
}
