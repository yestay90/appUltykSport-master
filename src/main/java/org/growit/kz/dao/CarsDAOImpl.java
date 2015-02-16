package org.growit.kz.dao;

import org.growit.kz.model.Cars;
import org.growit.kz.model.GroupParts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ymuratov on 2/13/15.
 */
@Repository
public class CarsDAOImpl implements CarsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory= sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }



    @Override
    public List<Cars> getAllCars() {
        return currentSession().createQuery("from Cars c").list();
    }

    @Override
    public void addRecordCars(Cars cars) {
        currentSession().saveOrUpdate(cars);
    }

    @Override
    public void deleteRecordCar(Cars cars) {
        currentSession().delete(cars);
    }

    @Override
    public Cars findByIdCars(int id) {
        Cars cars= (Cars)currentSession().createQuery("from Cars c where c.id =:id").setParameter("id", id).uniqueResult();

        if (cars.getGroupParts().size()==0){
            cars.getGroupParts().clear();
        }

        System.out.println("looking for car with id: " + id);
        return cars;
    }

    @Override
    public String updateRecordsCars(Cars cars) {
        return null;
    }
    @Override
    public List<GroupParts> getGroupWithCarID(int id){

        Cars car= (Cars)currentSession().createQuery("from Cars c where c.id =:id").setParameter("id", id).uniqueResult();

        System.out.println("printing car entity");
        System.out.println(car);
        System.out.println("looking for car with id : " + id);

        if (car.getGroupParts().size()==0){
            car.getGroupParts().clear();
        }


        // otbiraem group pars of particular car
        List<GroupParts> groupPartses = new ArrayList<GroupParts>();

        System.out.println("car -> id process started");


       if (car != null) {
            System.out.println("car is not null");
            if (car.getGroupParts() != null) {
                System.out.println("group part is not null");
                System.out.println("group parts are collecting");
                for (GroupParts groupPart : car.getGroupParts()) {
                    if (groupPart == null){
                        continue;
                    }
                    else {
                        System.out.println("group part is: " + groupPart);
                        groupPartses.add(groupPart);
                        System.out.println(car.getGroupParts());
                    }
               }
            } else {
                System.out.println("car don't have any parts");
            }
        }
        else {
            System.out.println("car entity is null");
        }

        return groupPartses;
    }
}
