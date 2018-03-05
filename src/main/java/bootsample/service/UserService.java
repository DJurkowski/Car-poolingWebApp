package bootsample.service;

import bootsample.dao.UserRepository;
import bootsample.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Select * from UZYTKOWNIK;
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    //Select * from UZYTKOWNIK where IS NOT IDUZYTKOWNIKA = id;
    public List<User> findAllWithout(Long id){
        List<User> users = new ArrayList<User>();
        for(User user: userRepository.findAll()){
            if(!user.getId().equals(id)){
                users.add(user);
            }
        }
        return users;
    }

    //Select * form UZYTKOWNIK where IDUZYTKOWNIKA = id;
    public User findUser(Long id) {
        return userRepository.findOne(id);
    }

    //Insert into UZYTKOWNIK values(user);
    public boolean save(User user) {
        if (userRepository.findByMail(user.getMail()) == null) {
            userRepository.save(user);
            return true;
        }
        return false;

    }

    public void update(User user){
        userRepository.save(user);
    }
    public boolean check(User user){
        if(userRepository.findByMail(user.getMail()) == null){
            return true;
        }
        return false;
    }

    public Long findUserMail(String mail){
        User user = (User)userRepository.findByMail(mail);
        if(user != null){
            return user.getId();
        }
        return -1l;
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}
