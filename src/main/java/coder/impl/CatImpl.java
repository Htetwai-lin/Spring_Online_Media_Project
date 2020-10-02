package coder.impl;

import coder.daos.CatDao;
import coder.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class CatImpl implements CatDao {
    @Autowired
    SessionFactory sessionFactory;

    private Session session(){
        return sessionFactory.getCurrentSession();
    }

    public List<Category> getAllCategory() {
       Query query= session().createQuery("from Category ");
       List<Category> categoryList = query.list();
       session().flush();
        return categoryList;
    }

    public void addCat(Category category) {
        session().save(category);
        session().flush();
    }

    public Category getCatById(int id) {
        Category category = session().get(Category.class,id);
        session().flush();
        return  category;
    }

    public void updateCategory(Category category) {
        session().saveOrUpdate(category);
        session().flush();
    }

    public void deleteCategory(int id) {
        session().delete(getCatById(id));
        session().flush();
    }
}
