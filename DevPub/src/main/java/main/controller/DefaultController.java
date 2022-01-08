package main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// для обычных запросов не через API (главная страница - /, в частности)
@Controller
public class DefaultController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(Model model) {

        return "index";
    }

}
