package com.thoughtworks.hotel.dao;

import com.thoughtworks.hotel.model.Room;

public interface RoomDao {
    Room getRoomByNumber(String number);

    void addRoom(Room room);

    void removeRoomByNumber(String number);
}
