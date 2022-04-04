package hh.books.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.books.domain.Category;
import hh.books.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository categoryrepository;

	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories (Model model) {
		model.addAttribute("categories", categoryrepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String save(Category category) {
		categoryrepository.save(category);
		return "redirect:categorylist";
	}
	
	//@RequestMapping(value = "/delete/{categoryid}", method = RequestMethod.GET)
	//public String deleteCategory(@PathVariable("categoryid") Long categoryId, Model model) {
	//	categoryrepository.deleteById(categoryId);
	//	return "redirect:../categorylist";
	//}
}
