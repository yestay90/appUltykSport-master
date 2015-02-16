package org.growit.kz.service;

import org.growit.kz.dao.CarsDAO;
import org.growit.kz.dao.GroupPartsDAO;
import org.growit.kz.dao.SubGroupDAO;
import org.growit.kz.dao.UserDAO;
import org.growit.kz.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Естай on 18.11.2014.
 */
@Service
public class MainServiceImpl implements MainService {


    private UserDAO userDAO;
    private CarsDAO carsDAO;
    private GroupPartsDAO groupPartsDAO;
    private SubGroupDAO subGroupDAO;



    @Autowired
    public MainServiceImpl(
            UserDAO userDAO,
            CarsDAO carsDAO,
            GroupPartsDAO groupPartsDAO,
            SubGroupDAO subGroupDAO) {
        this.userDAO = userDAO;
        this.carsDAO = carsDAO;
        this.groupPartsDAO = groupPartsDAO;
        this.subGroupDAO = subGroupDAO;
    }


    @Override
    @Transactional
    public List<Cars> getAllCars(){

        return carsDAO.getAllCars();

    }

    @Override
    public void addRecordCars(Cars cars) {

    }

    @Override
    public void deleteRecordCar(Cars cars) {

    }

    @Override
    @Transactional
    public Cars findByIdCars(int id) {
        return carsDAO.findByIdCars(id);
    }

    @Override
    public String updateRecordsCars(Cars cars) {
        return null;
    }


    @Override
    @Transactional
    public List<Users> getAllRecordsUserEntity() {
        return userDAO.getAllRecordsUserEntity();
    }

    @Override
    @Transactional
    public void addRecordsUsers(Users usersEntity) {
        userDAO.addRecordsUsers(usersEntity);
    }

    @Override
    @Transactional
    public void deleteRecordUsers(Users usersEntity) {
        userDAO.deleteRecordUsers(usersEntity);
    }

    @Override
    @Transactional
    public Users findByIdUser(int id) {
        return userDAO.findByIdUser(id);
    }

    @Override
    @Transactional
    public String updateRecordsUsers(Users usersEntity) {
        return userDAO.updateRecordsUsers(usersEntity);
    }

    @Override
    @Transactional
    public List<GroupParts> getGroupPartsByCarID(int id) {
        return groupPartsDAO.getGroupPartsByCarID(id);
    }

    @Override
    @Transactional
    public List<GroupParts> getAllGroups(){
        return groupPartsDAO.getAllGroups();
    }

    @Override
    @Transactional
    public List<GroupParts> getGroupWithCarID(int id) {
        return carsDAO.getGroupWithCarID(id);
    }

    @Override
    @Transactional
    public List<SubGroups> getSubGroupByGroupID(int id) {
        return groupPartsDAO.getSubGroupByGroupID(id);
    }

    @Override
    @Transactional
    public List<Parts> getPartsBySubGroupID(int id) {
        return subGroupDAO.getPartsBySubGroupID(id);
    }
}