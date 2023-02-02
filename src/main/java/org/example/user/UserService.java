package org.example.user;

public class UserService {
    private UserDao userdao;

    public UserService(UserDao userdao) {
        this.userdao = userdao;
    }
     public String getNameById(int id){
        return userdao.getNameById(id);

     }
    public String getEmailById(int id){
        return userdao.getEmailById(id);

    }
}
