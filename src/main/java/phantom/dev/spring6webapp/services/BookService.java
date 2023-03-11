package phantom.dev.spring6webapp.services;

import phantom.dev.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
