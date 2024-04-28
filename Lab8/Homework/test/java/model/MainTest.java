package model;

import controller.GenreDAO;
import controller.BookDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        Singleton.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        Singleton.setUser("STUDENT");
        Singleton.setPassword("STUDENT");
        assertNotEquals(Singleton.getUrl(), null);
        assertNotEquals(Singleton.getUser(), null);
        assertNotEquals(Singleton.getPassword(), null);
        BookDAO bookDAO = new BookDAO();
        assertNotEquals(bookDAO, null);
        bookDAO.getBooks();
        assertNotEquals(bookDAO.findById("1"), null);
        assertNotEquals(bookDAO.findByName("The Hours").size(), 0);

        GenreDAO genreDAO = new GenreDAO();
        genreDAO.getGenres();
        assertNotEquals(genreDAO.findById("1"), null);
        assertNotEquals(genreDAO.findByName("Mystery"), null);
    }
}