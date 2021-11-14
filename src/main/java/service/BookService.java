package service;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dto.AuthorDto;
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

    public BookDto findByTitle(String bookTitle) {
        if (bookTitle != null && bookTitle.equals("") == false) {
            Book book = bookDao.findByTitle(bookTitle);
            BookDto bookDto = new BookDto();
            bookDto.setTitle(book.getTitle());
            bookDto.setPublisherName(book.getPublisher().getName());
            bookDto.setCategoryName(book.getCategory().getName());
            bookDto.setPagesNumber(book.getPagesNumber());
            return bookDto;
        } else {
            throw new IllegalArgumentException("bookTitle can not be null or empty");
        }
    }

    public List<BookDto> findBookWithPagesNumberRange(short min, short max) {
        if (min > 0 && max > 0 && max > min) {
            List<Book> books = bookDao.findBookWithPagesNumberRange(min, max);
            List<BookDto> bookDtos = new ArrayList<>();
            books.forEach(book -> {
                BookDto bookDto = new BookDto();
                bookDto.setTitle(book.getTitle());
                AuthorDto authorDto = new AuthorDto();
                authorDto.setFirstName(book.getAuthorBookList().get(0).getAuthor().getFirstName());
                authorDto.setLastName(book.getAuthorBookList().get(0).getAuthor().getLastName());
                bookDto.setAuthorDto(authorDto);
                bookDtos.add(bookDto);
            });
            return bookDtos;
        } else {
            throw new IllegalArgumentException(
                    "min and max value can not be 0 and max must be greater than min");
        }
    }
}









