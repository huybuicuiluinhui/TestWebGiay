package asmhuybtph26874.demo.Controller;

import asmhuybtph26874.demo.Model.Account;
import asmhuybtph26874.demo.Service.IAccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/")
    public String showLoginPage(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("pass") String password,
                        HttpSession session) {

        Account account = accountService.login(username, password);

        if (account != null) {
            session.setAttribute("account", account);
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            model.addAttribute("account", account);
            return "redirect:/asm/product/user";
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("account", new Account());
        return "dangKy";
    }

    @PostMapping("/register")
    public String add(@ModelAttribute("account") Account account, HttpSession session) {
        account.setRole(1);
        accountService.insert(account);
        session.setAttribute("message", "Đăng ký tài khoản thành công!");
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/forgot")
    public String forgot() {
        return "/forgot";
    }

    @PostMapping("/forgot-password")
    public String forgotPass(@RequestParam(name = "userName") String userName, @RequestParam(name = "email") String email, @RequestParam(name = "pass") String pass) {
        Account account1 = accountService.findByUsername(userName);
        String emailUser = account1.getEmail();
        System.out.println("email" + emailUser);

        if (emailUser.equals(email)) {
            account1.setPass(pass);
            account1.setUsername(userName);
            account1.setEmail(email);
            account1.setPass(pass);
            accountService.insert(account1);
        }
        return "redirect:/home";
    }
}
