package bootsample.service;


import bootsample.dao.DriverRepository;
import bootsample.model.Driver;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverService {


    private final DriverRepository driveRepository;

    public DriverService(DriverRepository driveRepository) {
        this.driveRepository = driveRepository;
    }

    //Select * from KIEROWCA where IDUZYTKOWNIK = id;
    public Driver findByUserId(Long id){
        return driveRepository.findByIdUser(id);
    }

    //Insert into KIEROWCA values(SEQ,...);
    public void save(Driver driver) {
        driveRepository.save(driver);
    }

    //Select IDKIEROWCY from KIEROWCA where IDUZYTKOWNIKA = id;
    public Long findId(Long id){
        try{
            return driveRepository.findDriverByIdUser(id).getId();
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Jestem");
            return 0L;
        }

    }

    public boolean checkExist(Long id){

        System.out.println("Sprawdz id "+ id);
        if(!findId(id).equals(0L)){
            return true;
        }else return false;
    }

    //Delete from KIEROWCA where IDKIEROWCY = driver.id;
    public void delete(Driver driver){
        driveRepository.delete(driver);
    }

    //Select * from KIEROWCA where IDKIEROWCY = id;
    public Driver findDriver(Long id ){
        return driveRepository.findOne(id);
    }


}
