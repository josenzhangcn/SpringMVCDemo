package com.thoughtworks.hotel.ServiceImpl;

import com.thoughtworks.hotel.dao.RoomDao;
import com.thoughtworks.hotel.model.Room;
import com.thoughtworks.hotel.service.RoomService;

public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao;

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public Room getRoom(String number) {
        return roomDao.getRoomByNumber(number);
    }

    @Override
    public void deleteRoom(String number) {
        roomDao.removeRoomByNumber(number);
    }

    @Override
    public void addRoom(Room room){
        roomDao.addRoom(room);
    }
}
