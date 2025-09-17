package est.day11.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BD_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "BD_PRICE", nullable = false)
    private int price;

    @Column(name = "BD_PUBLISHER", nullable = false)
    private String publisher;

    @Column(name = "BD_SUMMARY", nullable = false)
    private String summary;

    @Column(name = "BD_LANGUAGE", nullable = false)
    private String language;

    @Builder
    public BookDetail(int price, String publisher, String summary, String language) {
        this.price = price;
        this.publisher = publisher;
        this.summary = summary;
        this.language = language;
    }

    public void updateBookDetail(int price, String publisher, String summary, String language) {
        this.price = price;
        this.publisher = publisher;
        this.summary = summary;
        this.language = language;
    }
}
