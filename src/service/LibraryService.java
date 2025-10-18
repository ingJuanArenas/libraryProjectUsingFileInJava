package service;


public class LibraryService {
    private final BookService bookService;
    private final UserService userService;

    public LibraryService(){
        this.bookService= new BookService();
        this.userService = new UserService();
    }

    public BookService getBookService() {
        return bookService;
    }

    public UserService getUserService() {
        return userService;
    }


}
