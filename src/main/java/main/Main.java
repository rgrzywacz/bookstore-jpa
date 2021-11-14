package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Author;
import entity.AuthorBook;
import entity.Book;
import entity.Category;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
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
        entityManager.close();
        //System.out.println(category);
    }
}
