package est.day11.book.dto;

import est.day11.book.entity.BookDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailResponse {

    private Long id;
    private int price;
    private String publisher;
    private String summary;
    private String language;

    public BookDetailResponse(BookDetail book) {
        this.id = book.getId();
        this.price = book.getPrice();
        this.publisher = book.getPublisher();
        this.summary = book.getSummary();
        this.language = book.getLanguage();
    }

}
