package org.growit.kz.dao;

import org.growit.kz.model.GroupParts;
import org.growit.kz.model.Parts;
import org.growit.kz.model.SubGroups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymuratov on 2/16/15.
 */
@Repository
public class SubGroupDAOImple implements SubGroupDAO {

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
    public List<Parts> getPartsBySubGroupID(int id) {
        SubGroups subGroups= (SubGroups)currentSession().createQuery("from SubGroups c where c.id =:id").setParameter("id", id).uniqueResult();

        if (subGroups.getParts().size()==0){
            subGroups.getParts().clear();
        }

        // otbiraem subgroup parts of particular group
        List<Parts> partses = new ArrayList<Parts>();

        if (subGroups != null) {
            if (subGroups.getParts() != null) {
                for (Parts part: subGroups.getParts()) {
                    if (part == null){
                        continue;
                    }
                    else {
                        partses.add(part);
                    }
                }
            } else {
                System.out.println("subgroup doesn't have any parts");
            }
        }
        else {
            System.out.println("subgroup entity is null");
        }
        return partses;

    }
}
