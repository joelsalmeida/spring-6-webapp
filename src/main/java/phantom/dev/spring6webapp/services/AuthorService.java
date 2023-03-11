package phantom.dev.spring6webapp.services;

import phantom.dev.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
