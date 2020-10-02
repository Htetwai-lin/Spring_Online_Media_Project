package coder.services;

import coder.daos.CatDao;
import coder.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    @Autowired
    private CatDao catDao;

    public List<Category> getAllCat(){
        return  catDao.getAllCategory();

    }

    public void saveCategory(Category category){
        catDao.addCat(category);
    }

    public Category getCategoryBy(int id){
        return catDao.getCatById(id);
    }

    public void updateCategory(Category category){
        catDao.updateCategory(category);
    }

    public void deleteCategory(int id){
        catDao.deleteCategory(id);
    }
}
