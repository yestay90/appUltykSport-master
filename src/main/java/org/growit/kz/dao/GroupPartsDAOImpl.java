package org.growit.kz.dao;

import org.growit.kz.model.GroupParts;
import org.growit.kz.model.SubGroups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymuratov on 2/13/15.
 */
@Repository
public class GroupPartsDAOImpl implements GroupPartsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //@Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory= sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<GroupParts> getGroupPartsByCarID(int id) {

        List<GroupParts> groupParts =  currentSession().createQuery("from GroupParts c").list();
        System.out.println("the process of 'getGroupby car id' started");
        List<GroupParts> returnedParts = new ArrayList<GroupParts>();

        for (GroupParts groupPart: groupParts){
            if(groupPart.getCars() != null){
                System.out.println("cars propery is not null test= " +id);
                System.out.println(groupPart.getCars().getId());
                if (groupPart.getCars().getId() == id){
                    System.out.println("cars id is equal to:" + id);
                    returnedParts.add(groupPart);
                    System.out.println(returnedParts);
                }
            }
        }

        return returnedParts;
    }

    @Override
    public List<GroupParts> getAllGroups() {
        List<GroupParts> groupParts = currentSession().createQuery("from GroupParts c").list();
        return groupParts;
    }

    @Override
    public List<SubGroups> getSubGroupByGroupID(int id) {

        GroupParts groupParts= (GroupParts)currentSession().createQuery("from GroupParts c where c.id =:id").setParameter("id", id).uniqueResult();

        if (groupParts.getSubGroups().size()==0){
            groupParts.getSubGroups().clear();
        }

        // otbiraem subgroup parts of particular group
        List<SubGroups> subGroupses = new ArrayList<SubGroups>();

        if (groupParts != null) {
            if (groupParts.getSubGroups() != null) {
                for (SubGroups subGroup: groupParts.getSubGroups()) {
                    if (subGroup == null){
                        continue;
                    }
                    else {
                        subGroupses.add(subGroup);
                    }
                }
            } else {
                System.out.println("group doesn't have any subparts");
            }
        }
        else {
            System.out.println("group entity is null");
        }
        return subGroupses;
    }

}
