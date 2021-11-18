package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BasicEntity {
    @Column
    private String country;
    @Column
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column
    private String street;
    @Column(name = "street_no")
    private String streetNo;
    @Column(name = "home_no")
    private String homeNo;

}
