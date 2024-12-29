package com.lib.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lib.model.Book;
import com.lib.model.User;
import com.lib.service.BookService;
import com.lib.service.UserService;

/*
 * Rest Controller Class For All the Rest API operation
 * All the Methods are mapped for Different operations
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	public BookController() {
	}

	@GetMapping({ "/", "/welcome" })
	public ModelAndView getHell(Model model) {
		model.addAttribute("name", "Indian Bittu");
		ModelAndView modelandview = new ModelAndView("welcome");
		return modelandview;
	}

	@GetMapping("/listBooks")
	public ModelAndView listBooks(Model model) {
		model.addAttribute("listBooks", bookService.getAllBook());
		ModelAndView modelandview = new ModelAndView("BookList");
		return modelandview;
	}

	@GetMapping("/addNewBook")
	public ModelAndView addNewBook(Model model) {
		ModelAndView modelandview = new ModelAndView("AddBook");
		return modelandview;
	}

	@RequestMapping(value = "/addOneBook", method = RequestMethod.POST)
	public ModelAndView addOneBook(Book book, Model model) {
		System.out.println("Name= " + book.getName());
		System.out.println("Id= " + book.getId());
		System.out.println("Date-"+book.getReturnDate());
		String status = bookService.insertBook(book);
		System.out.println(status);
		model.addAttribute("AddStatus", status);
		return new ModelAndView("welcome");
	}

	@GetMapping("/editOneBook/{bookId}")
	public ModelAndView editOneBook(@PathVariable String bookId, Model model) {
		System.out.println(bookId);
		ModelAndView modelandview = new ModelAndView("EditBook");
		return modelandview;
	}

	@GetMapping("/error")
	public ModelAndView error(Model model) {
		ModelAndView modelandview = new ModelAndView("errorPage");
		return modelandview;
	}

	/*
	 * Rest API method for User Operation This method insert the details of user in
	 * database by calling userService class and it is using Rest API operation
	 */
	@PostMapping(path = "/registerUser", consumes = "application/json")
	public String addUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	/*
	 * Rest API method for User Operation This method gets the details of user from
	 * database by calling userService class and it is using Rest API operation and
	 * it will return all the list of users
	 */
	@GetMapping(path = "/allUserList", produces = "application/json")
	public ArrayList<User> getAllUser() {
		return userService.getAllUser();
	}

	/*
	 * This method validate username and password given by user against user details
	 * available in database if it gets both Correct then return true otherwise
	 * false
	 */
	@GetMapping(path = "/validateUser/{name}/{password}", produces = "text/html")
	public boolean validateUser(@PathVariable String name, @PathVariable String password) {
		return userService.validateUser(name, password);
	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public String addBook(@RequestBody Book book) {
		return bookService.insertBook(book);
	}

	@PostMapping(path = "/editBook", consumes = "application/json")
	public String editBook(@RequestBody Book book) {
		return bookService.editBook(book);
	}

	/*
	 * This method gets the all books from database by calling bookService class.
	 * and using Rest API operation it will return list of all the books
	 */
	@GetMapping(path = "/booksList", produces = "application/json")
	public ArrayList<Book> getAllBook() {
		return bookService.getAllBook();
	}

	/*
	 * This method searches the database for book against given name by calling
	 * bookService class. using Rest API operation it will then returns the list of
	 * book with the same name
	 */
	@GetMapping(path = "/name/{name}", produces = "application/json")
	public ArrayList<Book> searchByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}

	/*
	 * This method searches the database for book against given author name by
	 * calling bookService class. using Rest API operation it will then returns the
	 * list of book with the same author name
	 */
	@GetMapping(path = "/author/{author}", produces = "application/json")
	public ArrayList<Book> searchByAuthor(@PathVariable String author) {
		return bookService.getBookByAuthor(author);
	}

	/*
	 * This method searches the database for book against given category name by
	 * calling bookService class. using Rest API operation it will then returns the
	 * list of book with the same category name
	 */
	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ArrayList<Book> searchByCategory(@PathVariable String category) {
		return bookService.getBookByCategory(category);
	}

}
