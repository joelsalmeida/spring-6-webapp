package phantom.dev.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import phantom.dev.spring6webapp.domain.Author;
import phantom.dev.spring6webapp.domain.Book;
import phantom.dev.spring6webapp.domain.Publisher;
import phantom.dev.spring6webapp.repositories.AuthorRepository;
import phantom.dev.spring6webapp.repositories.BookRepository;
import phantom.dev.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher fiveStars = new Publisher();
        fiveStars.setAddress("Z Street, 7");
        fiveStars.setCity("Z City");
        fiveStars.setState("Z State");
        fiveStars.setPublisherName("Five Stars");
        fiveStars.setZipCode(95175325);
        Publisher fiveStarsSaved = publisherRepository.save(fiveStars);

        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Lord");
        Author johnSaved = authorRepository.save(john);

        Book grandLord = new Book();
        grandLord.setIsbn("NXH8794");
        grandLord.setTitle("Grand Lord");
        Book grandLordSaved = bookRepository.save(grandLord);

        Book grandLordTwo = new Book();
        grandLordTwo.setIsbn("NXH3512");
        grandLordTwo.setTitle("Grand Lord II");
        Book grandLordTwoSaved = bookRepository.save(grandLordTwo);

        grandLordSaved.setPublisher(fiveStarsSaved);
        grandLordTwoSaved.setPublisher(fiveStarsSaved);

        johnSaved.getBooks().add(grandLordSaved);
        johnSaved.getBooks().add(grandLordTwoSaved);

        grandLordSaved.getAuthors().add(johnSaved);
        grandLordTwoSaved.getAuthors().add(johnSaved);

        authorRepository.save(johnSaved);
        bookRepository.save(grandLordSaved);
        bookRepository.save(grandLordTwoSaved);
        publisherRepository.save(fiveStarsSaved);

        System.out.println("####################");
        System.out.println("PUBLISHER: " + publisherRepository.count());
        System.out.println("AUTHOR: " + authorRepository.count());
        System.out.println("BOOK : " + bookRepository.count());
    }
}
