package bootsample.dao;

import bootsample.model.Opinion;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, Long> {
}
