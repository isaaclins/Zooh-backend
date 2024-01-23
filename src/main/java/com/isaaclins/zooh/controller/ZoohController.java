package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.UserEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ZoohController{





    @PostMapping("/register")
    public String processRegistration(@RequestParam String username, @RequestParam int pin, @RequestParam(required = false) boolean isAdmin, Model model) {
        if (checkForUsername(username)) {
            return "redirect:/username-error"; // Redirect to a failure page
        } else {
            // Create a new UserEntity and save it to the database
            UserEntity savedUserToDB = new UserEntity();
            savedUserToDB.setUsername(username);
            savedUserToDB.setPin(pin);

            if (Registration.Register(savedUserToDB)) {
                // Pass the user data to the success page
                UserEntity displayedUserToWebsite = getUserByUsername(username);
                if (displayedUserToWebsite != null) {  // Check if newUser is not null
                    String newusername = displayedUserToWebsite.getUsername();
                    int newpin = displayedUserToWebsite.getPin();

                    model.addAttribute("username", newusername);
                    model.addAttribute("pin", newpin);
                    model.addAttribute("isAdmin", newisAdmin ? "Admin" : "Not Admin");
                    return "registration-success"; // Redirect to a success page
                } else {
                    UserEntity UserDataTakenFromDB = getUserByUserID(savedUserToDB.getUserID());
                    model.addAttribute("username", UserDataTakenFromDB.getUsername());
                    model.addAttribute("pin", UserDataTakenFromDB.getPin());
                    return "registration-success"; // take the userID from the submitted user by username, search data from DB and give to user as website

                }
            } else {
                return "redirect:/registration-failure-2"; // Redirect to a failure page
            }
        }
    }
}
