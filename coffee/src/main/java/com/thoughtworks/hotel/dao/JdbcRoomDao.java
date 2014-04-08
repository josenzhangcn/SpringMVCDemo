package com.thoughtworks.hotel.dao;

import com.thoughtworks.hotel.model.Level;
import com.thoughtworks.hotel.model.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcRoomDao implements RoomDao {

    public static final String SELECT_ROOM_BY_NUMBER_STATEMENT = "select * from Room where numer=?";
    public static final String INSERT_ROOM_STATEMENT = "insert into Room(numer,price,level) values (:number, :price, :level)";
    public static final String DELETE_ROOM_STATEMENT = "delete from Room where numer=?";
    private SimpleJdbcOperations jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Room getRoomByNumber(String number) {
        return jdbcTemplate.query(SELECT_ROOM_BY_NUMBER_STATEMENT,
                new org.springframework.jdbc.core.RowMapper<Room>() {
                    @Override
                    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
                        Room room = new Room();
                        room.setNumber(resultSet.getString("numer"));
                        room.setPrice(resultSet.getInt("price"));
                        room.setLevel(Level.valueOf(resultSet.getString("level")));
                        return room;
                    }
                }, number).get(0);
    }

    @Override
    public void addRoom(Room room) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number", room.getNumber());
        params.put("price", room.getPrice());
        params.put("level", room.getLevel().name());
        jdbcTemplate.update(INSERT_ROOM_STATEMENT, params);
    }

    @Override
    public void removeRoomByNumber(String number) {
         jdbcTemplate.update(DELETE_ROOM_STATEMENT,number);
    }


}
