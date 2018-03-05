package bootsample.dao;

import bootsample.model.Role;
import bootsample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface RoleRepository extends JpaRepository<Role, Long> {
//}

public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAllByNickname(String nickname);
    Role findByUser(User user);
}