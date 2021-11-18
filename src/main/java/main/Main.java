package main;

import java.util.List;

import dto.AddressDto;
import dto.BookDto;
import service.AddressService;
import service.BookService;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        AddressService addressService = new AddressService();

        List<BookDto> books = bookService.findBooks();

        books.forEach(bookDto -> {
            System.out.println(bookDto);
        });

        BookDto bookDto = bookService.findByTitle("Kaznodzieja");
        System.out.println(bookDto);

        System.out.println("**call bookService.findBookWithPagesNumberRange**");
        List<BookDto> bookWithPagesNumberRange = bookService.findBookWithPagesNumberRange(
                (short) 100, (short) 300);
        bookWithPagesNumberRange.forEach(bookDto1 -> {
            System.out.println(bookDto1);
        });
        System.out.println("**call addressService.addAddress**");
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry("Polska");
        addressDto.setCity("Łódź");
        addressDto.setStreet("Dowborczyków");
        addressDto.setZipCode("90-100");
        addressDto.setStreetNo("23");
        addressDto.setHomeNo("3");
        addressDto = addressService.addAddress(addressDto);
        System.out.println(addressDto);

        System.out.println("**call addressService.upadateAddress**");
        addressDto.setStreet("Piłsudzkiego");
        addressDto = addressService.upadateAddress(addressDto);
        System.out.println(addressDto);

        System.out.println("**call  addressService.deleteAddressById**");
        addressService.deleteAddressById(addressDto.getId());
    }
}
