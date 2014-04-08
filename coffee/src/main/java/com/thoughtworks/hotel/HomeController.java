package com.thoughtworks.hotel;

import com.thoughtworks.hotel.model.Room;
import com.thoughtworks.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    private RoomService roomService;
    @Value("${hotel.appTitle}")
    private String applicationTitle;

    @Autowired
    public HomeController(RoomService roomService) {
        this.roomService = roomService;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("appTitle", "ddd");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addRoom(@Valid Room room, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            roomService.addRoom(room);
        }
        return "redirect:/home";
    }
}
