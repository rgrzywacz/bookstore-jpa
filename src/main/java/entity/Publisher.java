package entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "publishers")
public class Publisher extends BasicEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "dialing_code")
    private String dialingCode;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
