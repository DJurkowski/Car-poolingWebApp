package bootsample.dao;

import bootsample.model.DriveOffer;
import bootsample.model.ReservationDrive;
import bootsample.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationDriveRepository extends CrudRepository<ReservationDrive, Long> {
    List<ReservationDrive> findByUser(User user);
}
