package est.day11.book.repository;

import est.day11.book.dto.BookResponse;
import est.day11.book.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);
    List<Book> findByTitleContaining(String title);
}
