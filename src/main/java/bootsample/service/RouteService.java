package bootsample.service;

import bootsample.dao.RouteRepository;
import bootsample.model.Route;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> findAll(){
        List<Route> routes = new ArrayList<>();
        for(Route route: routeRepository.findAll()){
            routes.add(route);
        }
        return routes;
    }

    public Route findRoute(Long id){
        return routeRepository.findOne(id);
    }
}
