package entity;

import javax.persistence.*;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Book extends BasicEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "pages_number")
    private short pagesNumber;

    @Column(name = "isbn")
    private long isbn;

   /* @Column(name = "category_id")
    private int categoryId;*/
   /*@Column(name = "publisher_id")
    private int publisherId;*/

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<AuthorBook> authorBookList;

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", pagesNumber=" + pagesNumber + ", isbn=" +
               isbn + ", category=" + category + ", publisher=" + publisher + '}';
    }
}
