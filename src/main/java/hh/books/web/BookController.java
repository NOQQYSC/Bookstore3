package hh.books.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.books.domain.BookRepository;

@Controller
public class BookController {
@Autowired
private BookRepository repository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getBooks (Model model) {
		return "books";
	}
}


