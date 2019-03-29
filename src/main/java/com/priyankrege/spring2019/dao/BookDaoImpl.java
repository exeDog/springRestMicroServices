package com.priyankrege.spring2019.dao;

import com.priyankrege.spring2019.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.query.Query;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public long save(Book book){
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    public Book get(long id){
        return sessionFactory.getCurrentSession().get(Book.class,id);
    }

    public List<Book> list(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        Query<Book> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public void update(long id, Book book){
        Session session = sessionFactory.getCurrentSession();
        Book book1 = session.byId(Book.class).load(id);
        book1.setName(book.getName());
        book1.setDescription(book.getDescription());
        session.flush();
    }

    public void delete(long id){
        Session session = sessionFactory.getCurrentSession();
        Book book = session.byId(Book.class).load(id);
        session.delete(book);
    }

}
