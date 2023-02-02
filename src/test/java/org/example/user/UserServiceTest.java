package org.example.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
private UserDao userdao;
@BeforeEach
    public void setup(){
    System.out.println("My Test before call   dsddf" );
       userdao=mock(UserDao.class);
    }

    @Test
    public void getNameByIdTest(){
    UserService userser=new UserService(userdao);
    when(userser.getNameById(101)).thenReturn("Nick");
    when(userser.getNameById(103)).thenReturn("John");
    when(userser.getNameById(102)).thenReturn("Mark");
    assertEquals("Nick",userser.getNameById(101));

    }
    @Test
    public void getEmailByIdTest(){
        UserService userser=new UserService(userdao);
        when(userser.getEmailById(101)).thenReturn("Nick@gmail.com");
        when(userser.getEmailById(103)).thenReturn("John@gmail.com");
        when(userser.getEmailById(102)).thenReturn("Mark12@gmail.com");
        assertEquals("Nick@gmail.com",userser.getEmailById(101));

    }
}