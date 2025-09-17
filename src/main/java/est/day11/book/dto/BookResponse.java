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
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BookDetailResponse bookDetailResponse;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.bookDetailResponse = new BookDetailResponse(book.getBookDetail());
    }

}
