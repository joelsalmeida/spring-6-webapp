package phantom.dev.spring6webapp.services;

import org.springframework.stereotype.Service;
import phantom.dev.spring6webapp.domain.Book;
import phantom.dev.spring6webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    final private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
