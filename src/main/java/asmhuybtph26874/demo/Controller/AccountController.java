package asmhuybtph26874.demo.Controller;

import asmhuybtph26874.demo.Model.Account;
import asmhuybtph26874.demo.Service.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    ParamService param;
    @Autowired
    AccountService accountService;
    @Autowired
    SessionService sessionService;
    @Autowired
    HttpServletResponse response;
    @Autowired
    CookieService cookieService;
    @GetMapping("/login")
    public String viewForm(Model model){
        model.addAttribute("account", new Account());
        return "/login";
    }
    @PostMapping("/login")
    public  String login(HttpServletRequest request, Model model){
        model.addAttribute("account", new Account());
        String u = param.getString("username","");
        String p = param.getString("pass","");
        boolean r = param.getBoolean("chkRemember",false);
        Account acc = accountService.findByUsername(u);
       int role = acc.getRole();
        System.out.println(u);
        if(acc != null){
            HttpSession session = request.getSession();
            session.setAttribute("account", acc);
        }
        if(u.equals("admin")){
            try{
                if(!acc.getPass().equals(p)){
                    model.addAttribute("MESSAGE","Invalid password");
                }
                else{
                    String uri = sessionService.get("security-uri");
                    if(uri != null){
                        return "redirect:" +uri;
                    }
                    else{
                        model.addAttribute("MESSAGE","login successfull");
                        sessionService.set("username", u);
                    }
                }
            }
            catch (Exception e){
                model.addAttribute("MESSAGE","Invalid user");
            }
            return "redirect:/asm/product/admin";

        }
      else{
            try{
                if(!acc.getPass().equals(p)){
                    model.addAttribute("MESSAGE","Invalid password");
                }
                else{
                    String uri = sessionService.get("security-uri");
                    if(uri != null){
                        return "redirect:" +uri;
                    }
                    else{
                        model.addAttribute("MESSAGE","login successfull");
                        sessionService.set("username", u);
                        String userName  = sessionService.get("username");
                        System.out.println(u);
                        System.out.println(userName);
                    }
                }
            }
            catch (Exception e){
                model.addAttribute("MESSAGE","Invalid user");
            }
            return "redirect:/asm/product/user";
        }
    }
    @GetMapping("logout")
    public String logout(){

        sessionService.remove("USERNAME");
        return "/login";

    }



}
