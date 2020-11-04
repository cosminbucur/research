package com.fm.jdbc;

import com.fm.jdbc.user.Book;
import com.fm.jdbc.user.BookJdbcMysqlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class JdbcApplication {

    // TODO: add slf4j + log4j support
    private static final Logger logger = LoggerFactory.getLogger(JdbcApplication.class);

    public static void main(String[] args) {

        BookJdbcMysqlDao bookJdbcMysqlDao = new BookJdbcMysqlDao();
        Book book = new Book("JDBC is cool","nobody",LocalDate.parse("2000-01-08"));
        //bookJdbcMysqlDao.create(book);
        List<Book> listOfBooks = bookJdbcMysqlDao.findAll();
        listOfBooks.forEach(System.out::println);
        bookJdbcMysqlDao.delete(3L);


    }
}
