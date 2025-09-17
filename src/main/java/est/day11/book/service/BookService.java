package est.day11.book.service;

import est.day11.book.dto.AddBookRequest;
import est.day11.book.dto.BookResponse;
import est.day11.book.entity.Book;
import est.day11.book.repository.BookRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(AddBookRequest addBookRequest) {
        return bookRepository.save(addBookRequest.toEntity());
    }

    public List<BookResponse> getBooks(String title) {
        if (title == null || title.isBlank()) {
            return bookRepository.findAll().stream()
                .map(b -> new BookResponse(b))
                .toList();
        } else {
            return bookRepository.findByTitleContaining(title).stream()
                .map(b -> new BookResponse(b))
                .toList();
        }
    }

    public Book searchISBN(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "잘못된 ISBN 입니다.");
        } else {
            return book;
        }
    }

    // BookDetail 정보 빼고 Update
    public Book updateBook(Long id, AddBookRequest updateBook) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        book.updateBook(
            updateBook.getTitle(),
            updateBook.getAuthor(),
            updateBook.getIsbn()
        );

        return book;
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
