package bootsample.service;

import bootsample.dao.PreferenceRepository;
import bootsample.model.Preference;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;

    public PreferenceService(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    //Select * from PREFERENCJE where IDPREFERENCJI = id
    public Preference findPreference(Long id){

        return preferenceRepository.findOne(id);

    }

}
