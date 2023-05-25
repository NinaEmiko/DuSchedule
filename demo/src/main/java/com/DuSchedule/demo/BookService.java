import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public Book[] getBooks() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://simple-books-api.glitch.me/books";

        ResponseEntity<Book[]> response = restTemplate.getForEntity(apiUrl, Book[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Book[] books = response.getBody();
            logger.info("Successfully retrieved {} books", books.length);
            return books;
        } else {
            logger.error("Failed to fetch books. Status code: {}", response.getStatusCode());
            throw new RuntimeException("Failed to fetch books");
        }
    }
}
