package com.acorp.ventimetriquadri.app.user;

import com.acorp.ventimetriquadri.app.branch.Branch;
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

    @GetMapping(path = "/findbyemail")
    public UserEntity retrieveAll(@RequestParam String email){
        return userService.findByEmail(email);
    }

    @GetMapping(path = "/findAllBranchesByUserId")
    public List<Branch> retrieveAllBranchesByUserId(@RequestParam long userId){
        return userService.retrieveAllBranchesByUserId(userId);
    }

    @PostMapping(path = "/save")
    public void save(UserEntity userEntity) { userService.addNewUser(userEntity); }

    @DeleteMapping(path = "/delete")
    public void delete(UserEntity userEntity){
        userService.delete(userEntity);
    }

    @PutMapping(path = "/update")
    public void update(UserEntity userEntity){
        userService.update(userEntity);
    }


}
