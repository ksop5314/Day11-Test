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
public class AddBookDetailRequest {

    private int price;
    private String publisher;
    private String summary;
    private String language;

    public BookDetail toEntity() {
        return BookDetail.builder()
            .price(price)
            .publisher(publisher)
            .summary(summary)
            .language(language)
            .build();
    }

}
