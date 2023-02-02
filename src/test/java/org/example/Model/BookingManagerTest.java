package org.example.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class BookingManagerTest {

    private HotelDao hotelDaoMock;
    private BookingManager bookingManager;

    @BeforeEach
    public void setup() throws SQLException {

        hotelDaoMock = mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDaoMock);

        List<String> availableRooms = Arrays.asList("A","B");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

    }
    @Test
    void test() {
        List<String> mockList = mock(List.class);
        mockList.add("Pankaj");
        mockList.size();
        then(mockList)
                .should().
        add("Pankaj");
        verify(mockList).add("Pankaj");
        verify(mockList, times(1)).size(); //same as normal verify method
        verify(mockList, atLeastOnce()).size(); // must be called at least once
        verify(mockList, atMost(2)).size(); // must be called at most 2 times
        verify(mockList, atLeast(1)).size(); // must be called at least once
        verify(mockList, never()).clear(); // must never be called
    }
    @Test
    public void checkAvailableRoomsTrue() throws SQLException {
        assertTrue(bookingManager.checkRoomAvailability("A"));
    }

    @Test
    public void checkAvailableRoomsFalse() throws SQLException {
        assertTrue(bookingManager.checkRoomAvailability("B"));
    }
    @Test
    public void testMethod() {
        ArrayList mockedList = mock(ArrayList.class);

        when(mockedList.get(0)).thenReturn("first-element");

        System.out.println(mockedList.get(0));
        assertEquals("first-element", mockedList.get(0));

        // "null" gets printed as get(1) is not stubbed
        System.out.println(mockedList.get(1));
    }
}