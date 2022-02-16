package hh.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.books.domain.Book;
import hh.books.domain.BookRepository;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Supermarsu lentää Intiaan", "Paula Noronen", "\n"
					+ "9789512077960", 10.00);
			Book book2 = new Book("Risto Räppääjä ja viimeinen tötterö", "Sinikka Nopola, Tiina Nopola", "\n"
					+ "9789513138998", 12.00);
			
			repository.save(book1);
			repository.save(book2);
		};
	}

}
