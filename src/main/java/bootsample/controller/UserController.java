package bootsample.controller;

import bootsample.model.DriveOffer;
import bootsample.model.Driver;
import bootsample.model.Role;
import bootsample.model.User;
import bootsample.service.DriveOfferService;
import bootsample.service.DriverService;
import bootsample.service.RoleService;
import bootsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("Role")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private DriveOfferService driveOfferService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "welcome";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_ABOUT");
        return "welcome";
    }

    @GetMapping("/new-user")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "welcome";
    }

    @GetMapping("/update-user")
    public String updateUser(HttpServletRequest request, HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role != null) {
            request.setAttribute("mode", "MODE_UPDATE");
            request.setAttribute("user", userService.findUser(role.getUser().getId()));
            return "login";
            //!!!!!!!!!!!!!!!!!!!!!
        } else {
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }

    }

    @GetMapping("/delete-user")
    public String deleteUser(HttpSession session, HttpServletRequest request) {
        Role role = (Role) session.getAttribute("role");
        if (role != null) {
            if(driverService.checkExist(role.getUser().getId())==true){
                Driver driver = driverService.findByUserId(role.getUser().getId());
                if(driveOfferService.checkExist(driver.getId()) == true){
                    request.setAttribute("blad","DELETE");
                    request.setAttribute("mode", "MODE_HOME");
                    return "login";
                }else{
                    driverService.delete(driver);
                    roleService.delete(role.getId());
                    request.setAttribute("blad","DELETE");
                    request.setAttribute("mode", "MODE_HOME");
                    return "welcome";
                }

            }else{
                roleService.delete(role.getId());
                request.setAttribute("blad","DELETE");
                request.setAttribute("mode", "MODE_HOME");
                return "welcome";
            }
        } else {
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @PostMapping("/update-save")
    public String updateSave(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request, HttpSession session) {
        //save
        Role role = (Role) session.getAttribute("role");
        if (role != null) {

            userService.update(user);
            request.setAttribute("mode", "MODE_HOME");
            return "login";

        } else {
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }

    }

    @PostMapping("/save-user")
    public String saveTasks(@ModelAttribute User user, BindingResult binding, @ModelAttribute Role role, BindingResult bindingResult, HttpServletRequest request) {
        boolean result = userService.check(user);
        if (!result) {
            request.setAttribute("mode", "MODE_NEW");
            request.setAttribute("mail", "BAD");
            return "welcome";
        } else {
            roleService.save(new Role(role.getNickname(), role.getPassword(), user));
//          request.setAttribute("tasks", taskService.findAll());
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("good", "GOOD");
            return "welcome";
        }
    }

    @GetMapping("/login-user")
    public String login(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "welcome";
    }

    @PostMapping("/check-user")
    public String check(@ModelAttribute Role role, BindingResult bindingResult, @ModelAttribute User user, BindingResult binding, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
//        role.getUser().getId()
        Long mailCheckReturnID = userService.findUserMail(user.getMail());
        if (mailCheckReturnID != -1) {
            Role result = roleService.checkPassword(mailCheckReturnID, role.getPassword());
            if (result != null) {
                //tworzymy sesje
                session.setAttribute("role", result);//zworc rola
                request.setAttribute("mode", "MODE_HOME");
                request.setAttribute("nickname", result);
                return "login";
            } else {
                //nie tworzymy sesji wysylamy blad
                request.setAttribute("password", "BAD");
                request.setAttribute("mode", "MODE_LOGIN");
                return "welcome";
            }
        } else {
            //nieprawidlowy email lub nie istnieje
            request.setAttribute("mail", "BAD");
            request.setAttribute("mode", "MODE_LOGIN");
            return "welcome";
        }
    }

    @GetMapping("/user-home")
    public String user_home(HttpServletRequest request, HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role != null) {
            request.setAttribute("nickname", role);
            request.setAttribute("mode", "MODE_HOME");
            return "login";
        } else {
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        request.setAttribute("mode", "MODE_HOME");
        return "welcome";
    }


}
