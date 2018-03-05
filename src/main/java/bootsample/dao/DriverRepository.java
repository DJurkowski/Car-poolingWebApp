package bootsample.dao;

import bootsample.model.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {
    Driver findDriverByIdUser(Long id);
    Driver findByIdUser(Long id);
}
