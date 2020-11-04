package com.fm.jdbc.user;

import com.fm.jdbc.util.PropertiesLoader;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: implement this using jdbc prepared statements
// use a mysql database
// use try with resources
public class BookJdbcMysqlDao implements BookRepository {

    @Override
    public Book create(Book book) {
        String query = "INSERT INTO book(title,author,publish_date) VALUES (?, ?, ?)";
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        propertiesLoader.loadProperties();
        try (Connection connection = DriverManager.getConnection(propertiesLoader.url, propertiesLoader.username,
                propertiesLoader.password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDate(3, Date.valueOf(book.getPublishDate()));
            boolean flag = statement.execute();
            if (flag){
                System.out.println("book creted");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        propertiesLoader.loadProperties();
        List<Book> books = new ArrayList<>();
        String query = "SELECT id, title, author,publish_date FROM book";
        try (Connection connection = DriverManager.getConnection(propertiesLoader.url, propertiesLoader.username, propertiesLoader.password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                LocalDate publishDate = LocalDate.parse(resultSet.getString("publish_date"));
                Book book = new Book(id, title, author, publishDate);
                books.add(book);
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Book update(Long id, Book book) {
        return null;
    }

    @Override
    public void delete(Long id) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        propertiesLoader.loadProperties();
        String query = "DELETE FROM book WHERE id=?";
        try(Connection connection = DriverManager.getConnection(propertiesLoader.url, propertiesLoader.username ,propertiesLoader.password);
        PreparedStatement statement= connection.prepareStatement(query)){
            statement.setLong(1, id);
            boolean flag = statement.execute();
            if (flag){
                System.out.println("book deleted");
            }
        } catch (SQLException e){
            System.out.println("book not deleted");
        }
    }
}
