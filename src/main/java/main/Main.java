package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import dao.BookDao;
import dto.BookDto;
import entity.Author;
import entity.AuthorBook;
import entity.Book;
import entity.Category;
import service.BookService;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
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

        //System.out.println(books);
        /* EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("bookstore");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Category category = entityManager.find(Category.class, 1);
        System.out.println(category);

        Book book = entityManager.find(Book.class, 1);
        System.out.println(book);

        Author author = entityManager.find(Author.class,1);
        System.out.println("List of "+author.getFirstName() + ' '+author.getLastName() + " books" );


        for (AuthorBook authorBook : author.getAuthorBookList()) {
            System.out.println(authorBook.getBook());
        }

        entityManager.clear();
        entityManager.close();*/
        //System.out.println(category);
    }
}
