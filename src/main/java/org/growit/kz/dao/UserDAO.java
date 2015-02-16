package org.growit.kz.dao;

import org.growit.kz.model.Users;

import java.util.List;

/**
 * Created by Администратор on 10.11.2014.
 */

public interface UserDAO {

    public List<Users> getAllRecordsUserEntity();

    public void addRecordsUsers(Users usersEntity);

    public void deleteRecordUsers(Users usersEntity);

    public Users findByIdUser(int id);

    public String updateRecordsUsers(Users usersEntity);



}
