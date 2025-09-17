package est.day11.book.dto;

import est.day11.book.entity.Book;
import est.day11.book.entity.BookDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequest {

    private String title;
    private String author;
    private String isbn;
    private BookDetail bookDetail;

    public Book toEntity() {
        return Book.builder()
            .title(title)
            .author(author)
            .isbn(isbn)
            .bookDetail(bookDetail)
            .build();
    }

}
