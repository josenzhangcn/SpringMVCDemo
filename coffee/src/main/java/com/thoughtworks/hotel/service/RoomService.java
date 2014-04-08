package com.thoughtworks.hotel.service;

import com.thoughtworks.hotel.model.Room;

public interface RoomService {
    public Room getRoom(String number);

    public void deleteRoom(String number);

    public void addRoom(Room room);
}
