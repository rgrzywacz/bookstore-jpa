package service;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dto.BookDto;
import entity.Book;

public class BookService {

    private BookDao bookDao = new BookDao();

    public List<BookDto> findBooks() {
        List<Book> books = bookDao.findBooks();

        List<BookDto> dtos = new ArrayList<>();
        books.forEach(book -> {
            BookDto bookDto = new BookDto();
            bookDto.setTitle(book.getTitle());
            bookDto.setPublisherName(book.getPublisher().getName());
            bookDto.setCategoryName(book.getCategory().getName());
            bookDto.setPagesNumber(book.getPagesNumber());
            dtos.add(bookDto);
        });
        return dtos;
    }
}
