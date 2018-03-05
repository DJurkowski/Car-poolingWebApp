package bootsample.dao;

import bootsample.model.DriveOffer;
import bootsample.model.Driver;
import bootsample.model.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriveOfferRepository  extends CrudRepository<DriveOffer, Long> {
    DriveOffer findByRoute(Route route);
    DriveOffer findByIdDriver(Long id);
    List<DriveOffer> findAllByIdDriver(Long id);

}
