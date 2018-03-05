package bootsample.service;

import bootsample.dao.OpinionRepository;
import bootsample.model.Opinion;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public OpinionService(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    //Insert into OPINIA values(opinion);
    public void save(Opinion opinion){
        opinionRepository.save(opinion);
    }


}
