package bootsample.controller;

import bootsample.model.*;
import bootsample.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("Role")
public class ReservationController {


    @Autowired
    private DriveOfferService driveOfferService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private PreferenceService preferenceService;

    @Autowired
    private ReservationDriveService reservationDriveService;

    @Autowired
    private UserService userService;

    @Autowired
    private DriverService driverService;

    @GetMapping("/get-reserv")
    public String getReserv(HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null) {
            request.setAttribute("offers", routeService.findAll());
            request.setAttribute("mode","MODE_RESERVE");

            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @GetMapping("/reserv-detail")
    public String detalReserv(@RequestParam Long id, HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null) {
            //preference route i driveoffer
            Route route = routeService.findRoute(id);
            DriveOffer driveOffer = driveOfferService.findOfferByRoute(route);
            Preference preference = preferenceService.findPreference(driveOffer.getPreference().getId());
            Driver driver = driverService.findDriver(driveOffer.getIdDriver());
            User user = userService.findUser(driver.getIdUser());

            request.setAttribute("user", user);
            request.setAttribute("route", route);
            request.setAttribute("driveOffer", driveOffer);
            request.setAttribute("preference", preference);
            request.setAttribute("mode", "MODE_DETAIL");

            return "login";

        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }
    @PostMapping("/save-reserv")
    public String saveReserv(@ModelAttribute Preference preference, BindingResult bindingResult, @ModelAttribute Route route, BindingResult bindingResul, @ModelAttribute DriveOffer driveOffer, BindingResult bindingResu, HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null){

            reservationDriveService.save(new ReservationDrive(driveOffer,userService.findUser(role.getUser().getId())));
            request.setAttribute("nickname", role);
            request.setAttribute("mode","MODE_HOME");
            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @GetMapping("/user-reserv")
    public String userReserv(HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null){
            List<ReservationDrive> reservationDriveList = new ArrayList<>();
            reservationDriveList = reservationDriveService.findByUser(userService.findUser(role.getUser().getId()));
            if(reservationDriveList.isEmpty()){
             request.setAttribute("mode","MODE_RESERVE");
             request.setAttribute("blad","RESERVE");
             request.setAttribute("offers", routeService.findAll());
             return "login";
            }else {
                request.setAttribute("reservs", reservationDriveList);
                request.setAttribute("mode", "MODE_MY_RESERVE");
                return "login";
            }

        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    //zrobic wypisywanie detali
    @GetMapping("user-reserve-detail")
    public String userReservDetail(@RequestParam Long id, HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null){
            DriveOffer driveOffer = driveOfferService.findDriveOffer(reservationDriveService.findReservationDrive(id).getDriveOffer().getId());
            Route route = routeService.findRoute(driveOffer.getRoute().getId());
            Preference preference = preferenceService.findPreference(driveOffer.getPreference().getId());
            ReservationDrive reservationDrive = reservationDriveService.findReservationDrive(id);
            Driver driver = driverService.findDriver(driveOffer.getIdDriver());
            User user = userService.findUser(driver.getIdUser());

            request.setAttribute("user", user);
            request.setAttribute("reservationDrive", reservationDrive);
            request.setAttribute("route", route);
            request.setAttribute("driveOffer", driveOffer);
            request.setAttribute("preference", preference);
            request.setAttribute("mode", "MODE_MY_RESERVE_DETAIL");
            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

}
