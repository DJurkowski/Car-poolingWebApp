package bootsample.controller;

import bootsample.model.*;
import bootsample.service.DriveOfferService;
import bootsample.service.DriverService;
import bootsample.service.PreferenceService;
import bootsample.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("Role")
public class OfferController {

    @Autowired
    DriveOfferService driveOfferService;

    @Autowired
    DriverService driverService;

    @Autowired
    RouteService routeService;

    @Autowired
    PreferenceService preferenceService;

    @GetMapping("/new-offer")
    public String newOffer(HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null) {
            if(driverService.checkExist(role.getUser().getId())==true){
                request.setAttribute("mode", "MODE_OFFER");
                return "login";
            }else{
                request.setAttribute("mode","MODE_NEW_CAR");
                request.setAttribute("blad","DRIVER");
                return "login";
            }
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @PostMapping("/check-offer")
    public String newOffer(@ModelAttribute Route route, BindingResult bindingR, @ModelAttribute DriveOffer offer, BindingResult binding, @ModelAttribute Preference preference, BindingResult bindingResult, HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null){//zmienic
            System.out.println(driverService.findId(role.getUser().getId()));

            if(driverService.checkExist(role.getUser().getId())==true){
                driveOfferService.save(new DriveOffer(offer.getDate(), offer.getCost(), offer.getSitsNumber(), driverService.findId(role.getUser().getId()), preference, route ));
                request.setAttribute("mode","MODE_HOME");
                return "login";
            }else{
                request.setAttribute("mode","MODE_NEW_CAR");
                request.setAttribute("blad","DRIVER");
                return "login";
            }
        }else {
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @GetMapping("/my-offers")
    public String myOffers(HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null){
            if(driverService.checkExist(role.getUser().getId())==true) {
                request.setAttribute("offers", driveOfferService.findMyAll(driverService.findByUserId(role.getUser().getId()).getId()));
                request.setAttribute("mode", "MODE_MY_OFFERS");

                return "login";
            }else{
                request.setAttribute("mode","MODE_NEW_CAR");
                request.setAttribute("blad","DRIVER");
                return "login";
            }
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }

    @GetMapping("/offer-detail")
    public String offerDetail(@RequestParam Long id, HttpServletRequest request, HttpSession session){
        Role role = (Role)session.getAttribute("role");
        if(role != null){
            DriveOffer driveOffer = driveOfferService.findDriveOffer(id);
            Route route = routeService.findRoute(driveOffer.getRoute().getId());
            Preference preference = preferenceService.findPreference(driveOffer.getPreference().getId());

            request.setAttribute("driveOffer", driveOffer);
            request.setAttribute("route", route);
            request.setAttribute("preference", preference);
            request.setAttribute("mode", "MODE_OFFER_DETAIL");

            return "login";
        }else{
            request.setAttribute("mode", "MODE_LOGIN");
            request.setAttribute("register", "BAD");
            return "welcome";
        }
    }
}
