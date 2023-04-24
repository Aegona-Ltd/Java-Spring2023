package com.example.baitap1.controller;

import com.example.baitap1.entity.Contact;
import com.example.baitap1.entity.Users;
import com.example.baitap1.repository.ContactRepository;
import com.example.baitap1.repository.UserRepository;
import com.example.baitap1.service.ContactService;
import com.example.baitap1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

//@RestController
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        try {
            Principal principal = request.getUserPrincipal();
            System.out.println(principal.getName());

            return "redirect:/user/";
        }catch (Exception e){
            return "login";
        }
    }
//
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String login(@ModelAttribute(name="loginForm") Users users, Model model){
//        String username = Users
//
//        return "login";
//    }

//    @PostMapping("/doLogin")
//    public String doLogin(@RequestBody @Valid @ModelAttribute("user") Users user, BindingResult result, RedirectAttributes ra) {
//
////            PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
////            Users userdata = userService.findByEmail(user.getEmail());
////            System.out.println("user:" + userdata);
////            if(passwordEncoder.encode(user.getPassword()).equals(userdata.getPassword())){
////                return "user/home";
////            }else {
////                return "user/error";
////            }
//
//        return "login";
//
//    }
//        @PostMapping("/doLogin")
//        public String doLogin(@RequestBody @Valid @ModelAttribute("user") Users user, BindingResult result, RedirectAttributes ra) {
//
//
//        return "login";
//        }

    @GetMapping("/contactus")
    public String contact(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        return "contactus";
    }

    @GetMapping("/contactus2")
    public String contact2(Contact contact){
//        Contact contact = new Contact();
//        model.addAttribute("contact",contact);
        return "contactus2";
    }
    @PostMapping("/createContact")
    public String createContact(@Valid Contact contact,
                                BindingResult result,
                                HttpSession session){

        if (result.hasErrors()) {
            return "contactus2";
        }
//        contactRepository.save(contact);
        Contact contacts = contactService.createContact(contact);

        System.out.println("contact:" + contact);
        if(contacts!=null){
            session.setAttribute("msg","Gửi liên hệ thành công");
        }else{
            session.setAttribute("msg","Gửi liên hệ thất bại");
        }


        return "redirect:/contactus2";
    }

    @GetMapping("/register")
    public String register(Users users){
        return "register";
    }

    @PostMapping("/createRegister")
    public String createRegister(@Valid @ModelAttribute("users") Users users,
                           BindingResult result,
                           Model model, HttpSession sessions){
        if (result.hasErrors()) {
            return "register";
        }

        Users user= userService.createUsers(users);

        System.out.println("user:" + users);

        if(user!=null){
            sessions.setAttribute("msg","Bạn đã đăng ký thành công");
        }else{
            sessions.setAttribute("msg","Bạn đã đăng ký thất bại");
        }
        return "redirect:/register";
    }

}
