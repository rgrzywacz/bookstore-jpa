package entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "copies")
public class Copy extends BasicEntity {
    @Column
    private double cost;
    @ManyToOne
    @JoinColumn(name = "format_id")
    private Format format;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
