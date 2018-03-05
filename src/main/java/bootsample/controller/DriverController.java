package bootsample.controller;

import bootsample.model.Car;
import bootsample.model.Driver;
import bootsample.model.Role;
import bootsample.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes("Role")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/driver")
    public String driver(HttpServletRequest request, HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role != null) {
            if (driverService.checkExist(role.getUser().getId())== true) {
                request.setAttribute("mode","MODE_HOME");
                request.setAttribute("blad","DRIVER_ERROR");
                return "login";
            } else {
                request.setAttribute("mode", "MODE_NEW_CAR");
                return "login";
            }
        } else {
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }


    @PostMapping("/car-new")
    public String newCar(@ModelAttribute Car car, BindingResult bindingResult, HttpServletRequest request, HttpSession session) {
        //sprawdzac nulla!!
        Role role = (Role) session.getAttribute("role");
        if (role != null) {
            driverService.save(new Driver(role.getUser().getId(), car));
            request.setAttribute("mode", "MODE_OFFER");
            return "login";
        } else {
            System.out.println("BLAD null role!!!!!");

            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }

    }

}
