package com.thoughtworks.hotel;

import com.thoughtworks.hotel.model.Room;
import com.thoughtworks.hotel.service.RoomService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeControllerTest {

    Model model;
    private RoomService roomService;

    @Before
    public void before() {
        model = createMock(Model.class);
        roomService = createMock(RoomService.class);
    }

    @Test
    public void testCallHome() {
        HttpServletRequest request = createMock(HttpServletRequest.class);
        HttpServletResponse response = createMock(HttpServletResponse.class);
        HomeController controller = new HomeController(roomService);
        ModelAndView modelAndView = controller.index(request, response);

        replay(model, roomService);
        assertTrue(modelAndView.hasView());
        assertEquals(modelAndView.getViewName(), "home");
        verify(model, roomService);
    }

    @Test
    public void testAddRoomWhenVaidationFailed() {
        BindingResult bindingResult = createMock(BindingResult.class);
        expect(bindingResult.hasErrors()).andReturn(true);
        HomeController controller = new HomeController(roomService);
        Room room = createMock(Room.class);

        replay(bindingResult);
        assertEquals(controller.addRoom(room, bindingResult), "redirect:/home");
        verify(bindingResult);
    }

    @Test
    public void testAddRoomWhenVaidationSuccessed() {
        BindingResult bindingResult = createMock(BindingResult.class);
        expect(bindingResult.hasErrors()).andReturn(false);

        Room room = createMock(Room.class);
        roomService.addRoom(room);
        expectLastCall().atLeastOnce();

        HomeController controller = new HomeController(roomService);

        replay(bindingResult);
        assertEquals(controller.addRoom(room, bindingResult), "redirect:/home");
        verify(bindingResult);
    }
}
