package com.acorp.ventimetriquadri.app.user;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/users")
@CrossOrigin(origins = "*")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/findall")
    public List<UserEntity> retrieveAll(){
        return userService.findAll();
    }

//    @GetMapping(path = "/findbyphone")
//    public UserEntity retrieveByPhone(@RequestParam("phone") String phone){
//        return userService.findByPhone(phone);
//    }

    @PostMapping(path = "/save")
    public void save(UserEntity userEntity) { userService.addNewBranch(userEntity); }

    @DeleteMapping(path = "/delete")
    public void delete(UserEntity userEntity){
        userService.delete(userEntity);
    }

    @PutMapping(path = "/update")
    public void update(UserEntity userEntity){
        userService.update(userEntity);
    }
}
