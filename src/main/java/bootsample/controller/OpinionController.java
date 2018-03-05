package bootsample.controller;

import bootsample.model.Opinion;
import bootsample.model.Role;
import bootsample.model.User;
import bootsample.service.OpinionService;
import bootsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("Role")
public class OpinionController {

    @Autowired
    private UserService userService;

    @Autowired
    private OpinionService opinionService;

    @GetMapping("/all-users")
    public String allusers(HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null) {
            request.setAttribute("users", userService.findAllWithout(role.getUser().getId()));
            request.setAttribute("mode", "MODE_OPINION");
            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }

    }

    @GetMapping("/give-opinion")
    public String giveOpinion(@RequestParam Long id, HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null) {
            request.setAttribute("user", userService.findUser(id));
            request.setAttribute("mode", "MODE_GIVEOPINION");
            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @PostMapping("/check-opinion")
    public String checkOpinion(@ModelAttribute Opinion opinion, @ModelAttribute User user, BindingResult result, BindingResult bindingResult, HttpSession session, HttpServletRequest request){
        //dokonczyc dodawanie opinii
        //zapisuje podwojnie imie??usera
        //gwiazdki dla oceny
        Role role = (Role)session.getAttribute("role");
        if(role != null) {
            opinionService.save(new Opinion(opinion.getComments(), opinion.getMark(), userService.findUser(role.getUser().getId())));
            request.setAttribute("nickname", role);
            request.setAttribute("mode", "MODE_HOME");
            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }


    }

}
