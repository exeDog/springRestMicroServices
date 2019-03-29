package com.priyankrege.spring2019.service;

import com.priyankrege.spring2019.model.Book;

import javax.transaction.Transactional;
import java.util.List;

public interface BookService {
    @Transactional
    long save(Book book);

    Book get(long id);

    List<Book> list();

    @Transactional
    void update(long id, Book book);

    @Transactional
    void delete(long id);
}
