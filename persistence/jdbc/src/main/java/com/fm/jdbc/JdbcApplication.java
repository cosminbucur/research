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

        //create
        BookJdbcMysqlDao bookJdbcMysqlDao = new BookJdbcMysqlDao();
        Book book = new Book("Anna Karenina", "Leo Tolstoy", LocalDate.parse("1865-01-08"));
        //bookJdbcMysqlDao.create(book);

        //findAll
        List<Book> listOfBooks = bookJdbcMysqlDao.findAll();
        listOfBooks.forEach(System.out::println);
        bookJdbcMysqlDao.delete((long) 13);

        //findById
        logger.info("===findByID===");
        System.out.println(bookJdbcMysqlDao.findById((long) 1));

        //findByTitle
        System.out.println(bookJdbcMysqlDao.findByTitle("Spring is coming"));

        //findByAuthor
        List<Book> booksByAuthor = bookJdbcMysqlDao.findByAuthor("Leo Tolstoy");
        booksByAuthor.forEach(System.out::println);
        //update
        Book bookUpdate = new Book("Spring is coming", "Vasile", LocalDate.parse("2015-01-01"));
        bookJdbcMysqlDao.update(6L, bookUpdate);
    }
}
