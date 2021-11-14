package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BasicEntity{
    @Column
    private BigDecimal discount;
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "create_date")
    private LocalDateTime createDate;
}
