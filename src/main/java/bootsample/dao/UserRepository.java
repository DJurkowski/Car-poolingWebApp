package bootsample.dao;


import bootsample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//
//public interface UserRepository extends JpaRepository<User, Integer> {
//    User findByUsername(String username);
//}

public interface UserRepository extends CrudRepository<User, Long> {
//    User findByUsername(String username);
    User findByMail(String mail);

}
