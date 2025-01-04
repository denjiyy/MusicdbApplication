package bg.musicapp.musicdb.web;

import bg.musicapp.musicdb.model.entities.UserEntity;
import bg.musicapp.musicdb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

// these were all supposed to be just controller
@RestController
@RequestMapping("/test")
public class TestController {

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/update")
    public String update(Principal principal, Model model){
        //ToDo: change entity
        UserEntity userEntity = userService
                .findByName(principal.getName());





        model.addAttribute("username", userEntity.getUsername());
        model.addAttribute("userId", userEntity.getId());

        return "test";

    }

    @PatchMapping("/update/{id}")
    public String updateConfirm(@PathVariable Long id){
        System.out.println();
        return "redirect:/home";
    }
}
