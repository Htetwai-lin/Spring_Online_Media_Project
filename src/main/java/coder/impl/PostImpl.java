package coder.impl;

import coder.daos.PostDao;
import coder.models.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PostImpl implements PostDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session session(){
       return sessionFactory.getCurrentSession();
    }
    public void addPost(Post post) {
        session().save(post);
        session().flush();
    }

    @Override
    public List<Post> getAllPost() {
        Query query = session().createQuery("from Post");
        List<Post> postList = query.list();
        session().flush();
        return postList;
    }

    @Override
    public Post getPostById(int id) {
        Post post = session().get(Post.class,id);
        session().flush();
        return post;
    }

    @Override
    public void updatePost(Post post) {
         session().saveOrUpdate(post);
         session().flush();

    }

    @Override
    public void deletePost(int id) {
        session().delete(getPostById(id));
        session().flush();
    }
}
