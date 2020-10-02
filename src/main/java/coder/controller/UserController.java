package coder.controller;

import coder.models.Authority;
import coder.models.Post;
import coder.models.User;
import coder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/user/toggle/{id}")
    public String getUserById(@PathVariable("id")String id, Model model){
       User user =  userService.getUserById(Integer.parseInt(id));
        if(user.isEnabled()){
            user.setEnabled(false);
        }else {
            user.setEnabled(true);
        }
        userService.updateUser(user);
        return "redirect:/admin/user/all";
    }

    @RequestMapping("/admin/user/all")
    public String getAllUser(Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("users",userList);
        return "admin.user.all";
    }


    @RequestMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id")String id,Model model){
        userService.deleteUser(Integer.parseInt(id));
       return "";
    }
    @RequestMapping("/login")
    public String login(@RequestParam(name = "error",required = false)String error,
                        @RequestParam(name = "logout",required = false)String logout,Model model){

        if(error !=null){
            model.addAttribute("error","login error , please try again.");
        }
        if(logout != null){
            model.addAttribute("logout","logout successful.");
        }
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user")User user, BindingResult result, Model model){
            if(result.hasErrors()){
               List<ObjectError> errors = result.getAllErrors();
               return "register";
            }else {
                userService.addUser(user);
                userService.addAuthority(new Authority(user.getUsername(),"ROLE_AUTHOR"));
                model.addAttribute("register","register successful.");
                return "login";
            }


    }
}
