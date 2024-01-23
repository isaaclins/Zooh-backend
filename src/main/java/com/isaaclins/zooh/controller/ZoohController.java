package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.isaaclins.zooh.db.Generalisation.*;


@Controller
public class ZoohController{





    @PostMapping("/register")
    public String processRegistration(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) boolean isAdmin, Model model) {
        if (checkForUsername(username)) {
            return "redirect:/usernamealreadyexists"; // Redirect to a failure page
        } else {
            // Create a new UserEntity and save it to the database
            UserEntity savedUserToDB = new UserEntity();
            savedUserToDB.setUsername(username);
            savedUserToDB.setPassword(password);

            if (Register(savedUserToDB)) {
                // Pass the user data to the success page
                UserEntity displayedUserToWebsite = getUserByUsername(username);
                if (displayedUserToWebsite != null) {  // Check if newUser is not null
                    String newusername = displayedUserToWebsite.getUsername();
                    String newpin = displayedUserToWebsite.getPassword();

                    model.addAttribute("username", newusername);
                    model.addAttribute("password", newpin);
                    return "registration-success"; // Redirect to a success page
                } else {
                    UserEntity UserDataTakenFromDB = getUserByUserID(savedUserToDB.getUserID());
                    model.addAttribute("username", UserDataTakenFromDB.getUsername());
                    model.addAttribute("password", UserDataTakenFromDB.getPassword());
                    return "registration-success"; // take the userID from the submitted user by username, search data from DB and give to user as website

                }
            } else {
                return "redirect:/registration-failure-2"; // Redirect to a failure page
            }
        }
    }

}
