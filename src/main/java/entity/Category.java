package entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categories")
public class Category extends BasicEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    @Override
    public String toString() {
        List<String> collect = books.stream().map(Book::getTitle).collect(Collectors.toList());
        List<String> titles = new ArrayList<>();
        for (Book book : books) {
            titles.add(book.getTitle());
        }
        return "Category{" + "id=" + id + ", name='" + name + '\'' + ", code='" + code + '\'' +
               ", books=" + titles + '}';
    }
}
