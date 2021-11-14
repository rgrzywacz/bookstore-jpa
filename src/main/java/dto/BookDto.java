package dto;

import lombok.Builder;
import lombok.Data;

@Data
public class BookDto {
    private String title;
    private short pagesNumber;
    private String categoryName;
    private String publisherName;
    private AuthorDto authorDto;

}
