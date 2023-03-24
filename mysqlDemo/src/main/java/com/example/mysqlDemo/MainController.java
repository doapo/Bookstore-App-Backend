package com.example.mysqlDemo;


import com.example.mysqlDemo.Model.Author;
import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Model.ShoppingCart;
<<<<<<< HEAD
import com.example.mysqlDemo.Service.BookDetailService;
import com.example.mysqlDemo.Service.ProfileManagementService;
=======
import com.example.mysqlDemo.Model.User;
>>>>>>> 9eddb60fba5991732335b8c663753de03b03edd7
import com.example.mysqlDemo.Service.ShoppingCartService;
import com.example.mysqlDemo.Service.ProfileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

@RestController // This means that this class is a Controller
@RequestMapping(path="/project") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private final ShoppingCartService shoppingCartService;
<<<<<<< HEAD
    @Autowired
    private final BookDetailService bookDetailService;
    @Autowired
    private final ProfileManagementService profileManagementService;

    public MainController(ShoppingCartService shoppingCartService, BookDetailService bookDetailService, ProfileManagementService profileManagementService){
        this.shoppingCartService = shoppingCartService;
        this.bookDetailService = bookDetailService;
        this.profileManagementService = profileManagementService;
    }
    //bookDetails
    @GetMapping("/get/bookDetails/findBook")
    public  @ResponseBody Book findBook(@RequestParam int isbn){
        return bookDetailService.findBook(isbn);
    }

    @GetMapping("get/bookDetails/getBooks")
    public @ResponseBody Future<List<Book>> getBooks(@RequestParam int authorId){
        return bookDetailService.getBooks(authorId);}
    @PostMapping("/post/bookDetails/saveBook")
    public @ResponseBody String saveBook(@RequestParam int isbn,@RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam int authorId, @RequestParam String genre, @RequestParam String publisher, @RequestParam int yearPublished, @RequestParam int copiesSold){
        return bookDetailService.saveBook(isbn, name, description, price, authorId, genre, publisher, yearPublished, copiesSold);
    }
    @PostMapping("/post/bookDetails/addAuthor")
    public @ResponseBody String addAuthor(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String biography,@RequestParam String publisher){
        return bookDetailService.addAuthor(firstName, lastName, biography, publisher);
=======
    
    @Autowired
    private final ProfileManagementService profileManagementService;

    public MainController(ShoppingCartService shoppingCartService, ProfileManagementService profileManagementService){
        this.shoppingCartService = shoppingCartService;
        this.profileManagementService = profileManagementService;
    }
    
    @PostMapping("/post/User/addUser")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String homeAddress, @RequestParam String username, @RequestParam String password) {
    	return profileManagementService.addUser(name, email, homeAddress, username, password);
    }
    @GetMapping("/get/User/getUser")
    public @ResponseBody  User getUser(@RequestParam String username){
    	return profileManagementService.getUser(username);
    	
>>>>>>> 9eddb60fba5991732335b8c663753de03b03edd7
    }


    //shoppingCart
    @PostMapping("/post/shoppingCart/addBook")
    public @ResponseBody String addBook(@RequestParam int bookId, @RequestParam String username){
        return shoppingCartService.addtoCart(bookId,username);

    }@GetMapping("/get/shoppingCart/getBook")
    public @ResponseBody List<Book> getBooks (@RequestParam String username){
        return shoppingCartService.getBooksFromCart(username);
    }
    @GetMapping("/get/shoppingCart/getPrice")
    public @ResponseBody double getPrice(@RequestParam String username){
        return shoppingCartService.retrievePrice(username);
    }
    @DeleteMapping("delete/shoppingCart/remove")
    public @ResponseBody String removeFromCart(@RequestParam int bookId, @RequestParam String username){
        return shoppingCartService.removeFromCart(bookId,username);
    }

    // Profile Management
    @PostMapping("/post/profileManagement/createUser")
    public @ResponseBody String createUser(@RequestParam String username,@RequestParam String name, @RequestParam String email, @RequestParam String homeAddress,@RequestParam String password){
        return profileManagementService.createUser(username, name, email, homeAddress, password);
    }


}