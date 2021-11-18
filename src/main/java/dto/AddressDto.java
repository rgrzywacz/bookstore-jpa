package dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String country;
    private String city;
    private String zipCode;
    private String street;
    private String streetNo;
    private String homeNo;
    private boolean isAssociatedWithPublisher;
}
