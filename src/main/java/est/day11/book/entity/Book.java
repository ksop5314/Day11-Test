package est.day11.book.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "BOOK_TITLE")
    private String title;

    @Column(name = "BOOK_AUTHOR")
    private String author;

    @Column(name = "BOOK_ISBN")
    private String isbn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BD_ID")
    private BookDetail bookDetail;

    @Builder
    public Book(String title, String author, String isbn, BookDetail bookDetail) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.bookDetail = bookDetail;
    }

    public void updateBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void addBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

}
