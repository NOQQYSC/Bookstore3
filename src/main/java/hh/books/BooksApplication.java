package hh.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.books.domain.Book;
import hh.books.domain.BookRepository;
import hh.books.domain.Category;
import hh.books.domain.CategoryRepository;
import hh.books.domain.User;
import hh.books.domain.UserRepository;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryrepository, UserRepository userrepository) {
		return (args) -> {
			
			Category c1 = new Category("Childrens");
			Category c2 = new Category("Manga");
			Category c3 = new Category("Fantasy");
			
			categoryrepository.save(c1);
			categoryrepository.save(c2);
			categoryrepository.save(c3);
			
			User user1 = new User("user", "$2a$10$hDyTx2kkbfUuQtHR7CX1tO0RB.aD5X3oFckoMfWxluvU0e7rm/8i6", "USER");
			User user2 = new User("admin", "$2a$10$RHYQWYWhUTnDPxqG5kjjfuFSdO8wuYq.ax/amu0u0ycI7/yNV2tW.", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
			
			Book book1 = new Book("Supermarsu lentää Intiaan", "Paula Noronen", "\n"
					+ "9789512077960", 10.00, categoryrepository.findByName("Childrens").get(0));
			Book book2 = new Book("Risto Räppääjä ja viimeinen tötterö", "Sinikka Nopola, Tiina Nopola", "\n"
					+ "9789513138998", 12.00, categoryrepository.findByName("Childrens").get(0));
			
			repository.save(book1);
			repository.save(book2);
			
		};
	}

}
