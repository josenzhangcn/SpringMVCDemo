package com.thoughtworks.hotel.api;

import com.thoughtworks.hotel.model.Room;
import com.thoughtworks.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired
    @Qualifier("roomService")
    public void setRoomService(RoomService roomService){
        this.roomService=roomService;
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET, headers = {"Accept=text/xml,application/json"})
    @ResponseBody
    public Room getRoom(@PathVariable String number) {
        return roomService.getRoom(number);
    }

    @RequestMapping(value="/{number}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable String number){
         roomService.deleteRoom(number);
    }
}
