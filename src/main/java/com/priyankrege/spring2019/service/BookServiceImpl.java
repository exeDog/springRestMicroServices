package com.priyankrege.spring2019.service;

import com.priyankrege.spring2019.dao.BookDao;
import com.priyankrege.spring2019.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {


    private BookDao bookDao;

    @Autowired
    public  void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Transactional
    public long save(Book book){
        return bookDao.save(book);
    }

    public Book get(long id){
        return bookDao.get(id);
    }

    public List<Book> list(){
        return bookDao.list();
    }

    @Transactional
    public void update(long id, Book book){
        bookDao.update(id,book);
    }

    @Transactional
    public void delete(long id){
        bookDao.delete(id);
    }

}
