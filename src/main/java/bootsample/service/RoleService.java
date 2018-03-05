package bootsample.service;

import bootsample.dao.RoleRepository;
import bootsample.model.Role;
import bootsample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    //Select * from KONTO;
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        for (Role role : roleRepository.findAll()) {
            roles.add(role);
        }
        return roles;
    }

    //Select * from KONTO where IDUZYTKOWNIKA = id;
    public Role findUser(Long id) {
        return roleRepository.findOne(id);
    }

    //Insert into KONTO values(role);
    public void save(Role role) {
        roleRepository.save(role);
    }

    //Delete from KONTO where IDUZYTKOWNIKA = id;
    public void delete(Long id) {
        roleRepository.delete(id);
    }

    public Role checkPassword(Long id, String pass) {
        User user = userService.findUser(id);
        Role role = (Role) findUser(user);
        if (role.getPassword().equals(pass)) {
            return role;
        }
        return null;
    }

    //Select * from KONTO where IDUZYTKOWNIKA_KONTO = user.id;
    private Role findUser(User user) {
        return roleRepository.findByUser(user);

    }
}
