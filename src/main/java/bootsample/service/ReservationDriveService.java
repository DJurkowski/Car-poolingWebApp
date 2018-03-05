package bootsample.service;

import bootsample.dao.ReservationDriveRepository;
import bootsample.model.ReservationDrive;
import bootsample.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationDriveService {

    private final ReservationDriveRepository reservationDriveRepository;

    public ReservationDriveService(ReservationDriveRepository reservationDriveRepository) {
        this.reservationDriveRepository = reservationDriveRepository;
    }

    //Insert into REZERWACJAPRZEJAZDU values(reservationDrive)
    public void save(ReservationDrive reservationDrive){
        reservationDriveRepository.save(reservationDrive);
    }

    //Select * from REZERWACJAPRZEJAZDU where IDUZYTKOWNIKA = user.id;
    public List<ReservationDrive> findByUser(User user){

        try{
            return reservationDriveRepository.findByUser(user);
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    //Select * form REZERWACJAPRZEJAZDU where IDDOLACZENIA = id;
    public ReservationDrive findReservationDrive(Long id){
        return reservationDriveRepository.findOne(id);
    }
}
