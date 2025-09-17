package est.day11.book.service;

import est.day11.book.dto.AddBookDetailRequest;
import est.day11.book.entity.Book;
import est.day11.book.entity.BookDetail;
import est.day11.book.repository.BookDetailRepository;
import est.day11.book.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookDetailService {

    private final BookDetailRepository bookDetailRepository;
    private final BookRepository bookRepository;

    public BookDetailService(BookDetailRepository bookDetailRepository, BookRepository bookRepository) {
        this.bookDetailRepository = bookDetailRepository;
        this.bookRepository = bookRepository;
    }

    // 필요없는 코드
//    public BookDetail addBookDetail(String isbn, AddBookDetailRequest addBookDetailRequest) {
//        Book book = bookRepository.findByIsbn(isbn);
//        BookDetail bookDetail = book.getBookDetail();
//        // 이렇게 해도 되는건지 확실하지 않은 코드
//        if (bookDetail == null || bookDetail.getId() == null) {
//            book.addBookDetail(addBookDetailRequest.toEntity());
//            return book.getBookDetail();
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "BookDetail already exists");
//        }
//    }

    // BookDetail 정보 업데이트
    public Book updateBookDetailById(Long id, AddBookDetailRequest bookDetail) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        BookDetail db = book.getBookDetail();

        db.updateBookDetail(
            bookDetail.getPrice(),
            bookDetail.getPublisher(),
            bookDetail.getSummary(),
            bookDetail.getLanguage()
        );

        return Book.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .bookDetail(db)
                .build();
    }

}
