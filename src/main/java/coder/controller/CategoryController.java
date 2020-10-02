package coder.controller;

import coder.models.Category;
import coder.models.Post;
import coder.services.CatService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CatService catService;

    @RequestMapping("admin/cat/all")
    public String catAll(Model model){
       List<Category> categoryList = catService.getAllCat();
        model.addAttribute("cats",categoryList);
        return "admin.cat.all";
    }

    @RequestMapping("admin/cat/edit/{id}")
    public String showEditCat(@PathVariable("id")String id, Model model){
       Category category = catService.getCategoryBy(Integer.parseInt(id));
       model.addAttribute("category",category);
        return "admin.cat.edit";
    }

    @RequestMapping(value = "admin/cat/edit",method = RequestMethod.POST)
    public String editCat(@ModelAttribute("category") Category category, Model model){
        catService.updateCategory(category);
        return  "redirect:/admin/cat/all";
    }

    @RequestMapping("admin/cat/delete/{id}")
    public String deleteCat(@PathVariable("id")String id, Model model){
        catService.deleteCategory(Integer.parseInt(id));
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("admin/cat/create")
    public String showCreatePage(Model model){
       model.addAttribute("category", new Category());
        return "admin.cat.create";
    }

    @RequestMapping(value="admin/cat/create" ,method = RequestMethod.POST)
    public String showCreatePage(@ModelAttribute("category") Category category, Model model){
        catService.saveCategory(category);
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/cat/{id}")
    public String getCatWithPost(@PathVariable("id")String id,Model model){
       Category category =  catService.getCategoryBy(Integer.parseInt(id));
       List<Category> cats = catService.getAllCat();
       List<Post> posts =  category.getPostList();
       model.addAttribute("posts", posts);
       model.addAttribute("cats" , cats);
       return "catpage";
    }
}
