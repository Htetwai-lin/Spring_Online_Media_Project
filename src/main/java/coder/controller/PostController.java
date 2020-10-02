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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private CatService catService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/author/post/all")
    public String allPost(Model model){
       List<Post> posts =  postService.getAllPost();
       model.addAttribute("postList",posts);
        return "author.post.all";
    }

    @RequestMapping("/author/post/create")
    public String showPostCreate(Model model){
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats",cats);
        model.addAttribute("post",new Post());
        return "author.post.create";
    }


    @RequestMapping(value = "/author/post/create",method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post")Post post, Model model, HttpServletRequest request){
        MultipartFile file = post.getFile();
        if(file!=null && !file.isEmpty()){
           String imgName =  saveImage(file,request);
            post.setImage(imgName);
        }
        post.setUser_id(1);
        postService.addPost(post);
    return "redirect:/author/post/all";
    }

    @RequestMapping("/post/{id}")
    public String singlePost(@PathVariable("id")String id ,Model model){
        Post post = postService.getPostById(Integer.parseInt(id));
        List<Category> categoryList =  catService.getAllCat();
        model.addAttribute("post",post);
        model.addAttribute("cats", categoryList);
        return "post";
    }

    @RequestMapping("/author/post/edit/{id}")
    public String editPost(@PathVariable("id")String id, Model model){
        Post post = postService.getPostById(Integer.parseInt(id));
        List<Category> categoryList =  catService.getAllCat();
        model.addAttribute("post",post);
        model.addAttribute("cats", categoryList);
        return "author.post.edit";
    }
    @RequestMapping(value = "/author/post/edit")
    public String editPost(@ModelAttribute("post")Post post, Model model,HttpServletRequest request){
        MultipartFile file = post.getFile();
        if(file!=null && !file.isEmpty()){
            String imgName = saveImage(file,request);
            post.setImage(imgName);
        }else {
            System.out.println("file does not exit.");
        }
        postService.updatePost(post);
        return "redirect:/author/post/all";
    }

    @RequestMapping("/author/post/delete/{id}")
    public String deletePost(@PathVariable("id")String id, Model model){
        postService.deletePost(Integer.parseInt(id));
        return "redirect:/author/post/all";
    }
    public String saveImage(MultipartFile file, HttpServletRequest request){
        String imgName = System.currentTimeMillis()+"png";
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "/WEB-INF/assets/img/" + imgName);

        if (file != null && !file.isEmpty()){
            try {
                file.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Image can't upload");
            }
        }
        return imgName;
    }
}
