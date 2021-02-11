package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {


//    This shows the initial view of the page.
    @GetMapping("/roll-dice")
    public String showDiceRoll(){
        return "diceroll";
    }

//Takes you to the rolleddice view

    @GetMapping("/roll-dice/{pickedNum}")
    public String rollDice(@PathVariable int pickedNum, Model model){
        String message;
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        if(pickedNum == randomNum){
            message = "You chose wisely.";
        }else {
            message = "You chose poorly";
        }
        model.addAttribute("randomNumber", randomNum);
        model.addAttribute("pickedNumber", pickedNum);
        model.addAttribute("message", message);

        return "rolleddice";

    }








}

