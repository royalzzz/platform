package xin.qust.platform.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.User;
import xin.qust.platform.repository.UserRepo;

import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    private UserRepo userRepo;

//    username使用nickname
    public Optional<User> findUserByUsername(String username){
        return userRepo.findByNickName(username);
    }

}
