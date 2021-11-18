package dao;

import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import entity.Author;
import entity.AuthorBook;
import entity.Book;
import entity.Category;

public class BookDao {
    public List<Book> findBooks() {
        EntityManager entityManager = DatabaseConnection.getInstance().getConnection();
       TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> books = query.getResultList();
        entityManager.close();
        return books;
    }

    public Book findByTitle(String bookTitle) {
        EntityManager entityManager = DatabaseConnection.getInstance().getConnection();
        TypedQuery<Book> query = entityManager.createQuery(
                "select b from Book b where b.title=:title", Book.class);
        query.setParameter("title", bookTitle);
        Book b = query.getSingleResult();
        entityManager.close();
        return b;
    }

    public List<Book> findBookWithPagesNumberRange(short min, short max){
        EntityManager entityManager = DatabaseConnection.getInstance().getConnection();
        TypedQuery<Object[]> query = entityManager.createQuery(
                "select b.title, a.firstName, a.lastName, b.pagesNumber, c.name from Book b " +
                "left join b.category c " +
                "left join b.authorBookList ab left join ab.author a " +
                "where b.pagesNumber>=:minPagesNumber and b.pagesNumber<=:maxPagesNumber", Object[].class);
        query.setParameter("minPagesNumber", min);
        query.setParameter("maxPagesNumber", max);

        List<Object[]> objectList = query.getResultList();
        List<Book> books = new ArrayList<>();
        objectList.forEach(objects -> {
            String title = (String) objects[0];
            String authorFirstName = (String) objects[1];
            String authorLastName = (String) objects[2];
            short pagesNumber = (short) objects[3];
            String categoryName = (String) objects[4];

            Category category = new Category();
            category.setName(categoryName);

            Book book = new Book();
            book.setTitle(title);
            book.setPagesNumber(pagesNumber);
            book.setCategory(category);

            Author author = new Author();
            author.setFirstName(authorFirstName);
            author.setLastName(authorLastName);

            AuthorBook authorBook = new AuthorBook();
            authorBook.setAuthor(author);
            authorBook.setBook(book);

            List<AuthorBook> authorBooks = new ArrayList<>();
            authorBooks.add(authorBook);

            book.setAuthorBookList(authorBooks);
            books.add(book);
        });
        return books;
    }
}