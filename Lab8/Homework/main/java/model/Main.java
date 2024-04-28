package model;

import controller.GenreDAO;
import controller.BookDAO;
import controller.AuthorsDAO;
import exceptions.FileException;
import tools.CSVReader;
import tools.ImportFromCSV;

import java.sql.Date;

public class Main {

    public static void main(String[] args){
        Singleton.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        Singleton.setUser("STUDENT");
        Singleton.setPassword("STUDENT");
        BookDAO bookDAO = new BookDAO();
        bookDAO.getBooks();
        System.out.println();
        System.out.println(bookDAO.findById("1"));
        System.out.println();
        bookDAO.findByName("The Hours").stream().forEach(System.out::println);
        
        GenreDAO genreDAO = new GenreDAO();
        genreDAO.getGenres();
        System.out.println();
        System.out.println(genreDAO.findById("3"));
        System.out.println();
        System.out.println(genreDAO.findByName("Thriller"));
        
        AuthorsDAO authorDAO = new AuthorsDAO();
        authorDAO.getAuthors();
        CSVReader csvReader = new CSVReader();
        csvReader.setSource("D://db//IMDb_movies.csv");
        csvReader.setSeparator(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        ImportFromCSV importFromCSV = new ImportFromCSV(csvReader);
        bookDAO.importBooks(importFromCSV);
        bookDAO.getBooks();
    }
}
