package bootsample.dao;

import bootsample.model.Preference;
import org.springframework.data.repository.CrudRepository;

public interface PreferenceRepository extends CrudRepository<Preference, Long> {

}
