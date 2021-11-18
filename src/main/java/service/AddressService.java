package service;

import dao.AddressDao;
import dto.AddressDto;
import entity.Address;


public class AddressService {

    private AddressDao addressDao = new AddressDao();

    public void deleteAddressById(int id) {
        if (id > 0) {
            Address address = addressDao.find(id);
            addressDao.delete(address);
        } else {
            throw new IllegalArgumentException("id can not be lower than 0");
        }
    }

    public AddressDto upadateAddress(AddressDto addressDto) {
        String city = addressDto.getCity();
        String country = addressDto.getCountry();
        String zipCode = addressDto.getZipCode();
        String street = addressDto.getStreet();
        String streetNo = addressDto.getStreetNo();

        if (city != null && !city.isEmpty() && country != null && !country.isEmpty() &&
            zipCode != null && !zipCode.isEmpty() && street != null && !street.isEmpty() &&
            streetNo != null && !streetNo.isEmpty() && addressDto.getId() != 0) {

            Address address = new Address();
            address.setId(addressDto.getId());
            address.setCity(city);
            address.setCountry(country);
            address.setStreet(street);
            address.setStreetNo(streetNo);
            address.setHomeNo(addressDto.getHomeNo());
            address.setZipCode(zipCode);
            addressDao.insertOrUpdate(address);
            return addressDto;
        } else {
            throw new IllegalArgumentException("AddressDto is incomplete, check values");
        }
    }

    public AddressDto addAddress(AddressDto addressDto) {

        String city = addressDto.getCity();
        String country = addressDto.getCountry();
        String zipCode = addressDto.getZipCode();
        String street = addressDto.getStreet();
        String streetNo = addressDto.getStreetNo();

        if (city != null && !city.isEmpty() && country != null && !country.isEmpty() &&
            zipCode != null && !zipCode.isEmpty() && street != null && !street.isEmpty() &&
            streetNo != null && !streetNo.isEmpty()) {

            Address address = new Address();
            address.setCity(city);
            address.setCountry(country);
            address.setStreet(street);
            address.setStreetNo(streetNo);
            address.setHomeNo(addressDto.getHomeNo());
            address.setZipCode(zipCode);

            address = addressDao.insertOrUpdate(address);
            addressDto.setId(address.getId());
            return addressDto;
        } else {
            throw new IllegalArgumentException("AddressDto is incomplete, check values");
        }
    }
}
