package coder.controller;

import coder.models.Category;
import coder.models.Post;
import coder.models.User;
import coder.services.CatService;
import coder.services.PostService;
import coder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private CatService catService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model){
       List<Post> postList =  postService.getAllPost();
       List<Category> categoryList = catService.getAllCat();
       model.addAttribute("posts" , postList);
       model.addAttribute("cats",categoryList);
        return "home";
    }

    @RequestMapping("/contact")
    public String contact(Model model){
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats",cats);
        return "contact";
    }

/*
    @RequestMapping("/author/home")
    public String auhtor(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
            System.out.println(username);
        }else {
            String username = principal.toString();
            System.out.println(username);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean auth = authentication.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("ROLE_ADMIN"));
//        if (auth){
//            return "redirect:/admin/home";
//        }else {
//            return "author.home";
//        }
        return "author.home";
    }

 */

    @RequestMapping("/author/home")
    public String auhtor(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        List<Category> cats = catService.getAllCat();
        User user = userService.getUserByName(username);
        model.addAttribute("postList",user.getPostList());
        model.addAttribute("cats",cats);
        return "author.home";
        }

    @RequestMapping("/user/home")
    public String userHome(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean auth = authentication.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("ROLE_ADMIN"));
        if (auth){
            return "redirect:/admin/home";
        }else {
            return "author.home";
        }
    }
    @RequestMapping("/admin/home")
    public String admin(Model model){
        List<Category> cats = catService.getAllCat();
        List<Post> postList = postService.getAllPost();
        model.addAttribute("postList", postList);
        model.addAttribute("cats",cats);
        return "admin.home";
    }

}