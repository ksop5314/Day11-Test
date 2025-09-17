package est.day11.book.controller;

import est.day11.book.dto.AddBookRequest;
import est.day11.book.dto.BookResponse;
import est.day11.book.entity.Book;
import est.day11.book.service.BookService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest book) {
        Book bookEntity = bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(bookEntity);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(@RequestParam(required = false) String title) {
        List<BookResponse> bookList = bookService.getBooks(title);
        return ResponseEntity.status(HttpStatus.OK)
            .body(bookList);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> searchISBN(@PathVariable String isbn) {
        Book searchBook = bookService.searchISBN(isbn);
        return ResponseEntity.status(HttpStatus.OK)
            .body(searchBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody AddBookRequest updateBook) {
        Book book = bookService.updateBook(id, updateBook);
        return ResponseEntity.status(HttpStatus.OK)
            .body(book);
    }

}
