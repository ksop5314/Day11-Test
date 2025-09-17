package est.day11.book.controller;

import est.day11.book.dto.AddBookDetailRequest;
import est.day11.book.entity.Book;
import est.day11.book.service.BookDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/book_detail")
public class BookDetailController {

    private final BookDetailService bookDetailService;

    public BookDetailController(BookDetailService bookDetailService) {
        this.bookDetailService = bookDetailService;
    }

    // 이거는 책 데이터를 넣을 때 책 정보가 안들어가는걸 생각해서 만들었는데 책 데이터를 넣을 때
    // 책 정보가 없으면 아예 INSERT가 안되는거같음..
    // 그래서 필요 없는 코드 일듯.
//    @PostMapping("{isbn}")
//    public ResponseEntity<BookDetail> addBookDetail(@PathVariable String isbn, @RequestBody AddBookDetailRequest addBookDetailRequest) {
//        BookDetail bookDetail = bookDetailService.addBookDetail(isbn, addBookDetailRequest);
//        return ResponseEntity.status(HttpStatus.OK)
//            .body(bookDetail);
//    }

    // 문제를 잘못이해하고 풀어서 모두 수정
    // 기존에는 BookDetail 객체로 반환했는데 Book 객체안에 BookDetail을 갈아끼우고 Book 객체를
    // 다시 반환 해주는 방법으로 변경
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookDetail(@PathVariable Long id, @RequestBody AddBookDetailRequest bookDetail) {
        Book bd = bookDetailService.updateBookDetailById(id, bookDetail);
        return ResponseEntity.status(HttpStatus.OK)
            .body(bd);
    }

}
