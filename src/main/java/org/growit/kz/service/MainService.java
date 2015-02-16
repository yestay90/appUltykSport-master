package org.growit.kz.service;


import org.growit.kz.model.*;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 19.11.2014.
 */
public interface MainService {



    //cars entity

    public List<Cars> getAllCars();

    public void addRecordCars(Cars cars);

    public void deleteRecordCar(Cars cars);

    public Cars findByIdCars(int id);

    public String updateRecordsCars(Cars cars);


    // User dao

    public List<Users> getAllRecordsUserEntity();

    public void addRecordsUsers(Users usersEntity);

    public void deleteRecordUsers(Users usersEntity);

    public Users findByIdUser(int id);

    public String updateRecordsUsers(Users usersEntity);

    // group part entity
    public List<GroupParts> getGroupPartsByCarID(int id);

    public List<GroupParts> getAllGroups();

    public List<GroupParts> getGroupWithCarID(int id);

    // sub group part entity
    public List<SubGroups> getSubGroupByGroupID(int id);

    //parts entity
    public List<Parts> getPartsBySubGroupID(int id);
}
