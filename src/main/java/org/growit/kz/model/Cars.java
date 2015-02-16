package org.growit.kz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymuratov on 2/12/15.
 */
@Entity
@Table(name = "Cars")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cars {
    private int id;
    private String carName;


    //relationship cars -< groups
    private Set<GroupParts> groupParts = new HashSet<GroupParts>();



    @JsonIgnore
    @JsonSerialize
    @OneToMany(mappedBy = "cars", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<GroupParts> getGroupParts(){

        return this.groupParts;

    }
    public void setGroupParts(Set<GroupParts> groupParts){

        this.groupParts = groupParts;

    }
    public void addGroupParts(GroupParts groupParts){

        groupParts.setCars(this);
        getGroupParts().add(groupParts);

    }
    public void removeGroupParts(GroupParts groupParts){
        getGroupParts().remove(groupParts);
    }


    @JsonSerialize
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic

    @JsonSerialize
    @Column(name = "carName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars = (Cars) o;

        if (id != cars.id) return false;
        if (carName != null ? !carName.equals(cars.carName) : cars.carName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carName != null ? carName.hashCode() : 0);
        return result;
    }
}
