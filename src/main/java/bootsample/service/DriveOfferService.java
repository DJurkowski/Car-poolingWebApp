package bootsample.service;

import bootsample.dao.DriveOfferRepository;
import bootsample.model.DriveOffer;
import bootsample.model.Route;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriveOfferService {

    private final DriveOfferRepository driveOfferRepository;

    public DriveOfferService(DriveOfferRepository driveOfferRepository) {
        this.driveOfferRepository = driveOfferRepository;
    }

    //Select * from OFERTAPRZEJAZDU;
    public List<DriveOffer> findAll(){
        List<DriveOffer> offers = new ArrayList<>();
        for(DriveOffer offer: driveOfferRepository.findAll()) {
            offers.add(offer);
        }
        return offers;
    }

    //Insert into OFERTAPRZEJAZDU values(SEQ,...);
    public void save(DriveOffer driveOffer){

        driveOfferRepository.save(driveOffer);
    }

    //Select * from OFERTAPRZEJAZDU where IDTRASY_OFERTA = route.id;
    public DriveOffer findOfferByRoute(Route route){
        return driveOfferRepository.findByRoute(route);
    }

    //Select * from OFERTAPRZEJAZDU where IDPRZEJAZDU = id;
    public DriveOffer findDriveOffer(Long id){
        return driveOfferRepository.findOne(id);
    }

    // Select * from OFERTAPRZEJAZDU;
    public List<DriveOffer> findMyAll(Long id){
        List<DriveOffer> offers = new ArrayList<>();
        for(DriveOffer offer: driveOfferRepository.findAll()){
            if(offer.getIdDriver().equals(id)){
                offers.add(offer);
            }
        }
        return offers;
    }

    // Select * from OFERTAPRZEJAZDU where IDKIEROWCY = id;
    public List<Long> findByDriverId(Long id){
        List<Long> listId=new ArrayList<>();
        for(DriveOffer x: driveOfferRepository.findAllByIdDriver(id)){
            listId.add(x.getId());
        }
        return listId;

    }

    public boolean checkExist(Long id){
        if(!findByDriverId(id).isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
