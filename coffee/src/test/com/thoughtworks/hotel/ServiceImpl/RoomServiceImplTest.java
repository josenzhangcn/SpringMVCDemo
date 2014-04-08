package com.thoughtworks.hotel.ServiceImpl;

import com.thoughtworks.hotel.dao.RoomDao;
import com.thoughtworks.hotel.model.Room;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class RoomServiceImplTest {

    private RoomServiceImpl roomService;
    private RoomDao roomDao;

    @Before
    public void before() {
        roomDao = createMock(RoomDao.class);
        roomService = new RoomServiceImpl();
        roomService.setRoomDao(roomDao);
    }

    @Test
    public void testQueryInvalidRoom() throws Exception {
        expect(roomDao.getRoomByNumber(anyObject(String.class))).andReturn(null);

        replay(roomDao);
        assertNull(roomService.getRoom("1"));
        verify(roomDao);
    }

    @Test
    public void testQueryValidRoom() throws Exception {
        Room room = createMock(Room.class);
        expect(roomDao.getRoomByNumber(anyObject(String.class))).andReturn(room);

        replay(roomDao);
        assertSame(room, roomService.getRoom("1"));
        verify(roomDao);
    }

    @Test
    public void testDeleteRoom() throws Exception {
        roomDao.removeRoomByNumber(anyObject(String.class));
        expectLastCall().atLeastOnce();

        replay(roomDao);
        roomService.deleteRoom("1");
        verify(roomDao);
    }

    @Test
    public void testAddRoom() throws Exception {
        Room room = createMock(Room.class);
        roomDao.addRoom(anyObject(Room.class));
        expectLastCall().atLeastOnce();

        replay(roomDao);
        roomService.addRoom(room);
        verify(roomDao);
    }
}
