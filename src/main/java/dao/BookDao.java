package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import entity.Book;

public class BookDao {
    public List<Book> findBooks() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> books = query.getResultList();
        entityManager.close();
        return books;
    }
}
