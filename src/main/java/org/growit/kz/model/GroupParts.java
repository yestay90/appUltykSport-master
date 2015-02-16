package org.growit.kz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ymuratov on 2/12/15.
 */
@Entity
@Table(name = "GroupParts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupParts{
    private int id;
    private String groupName;
    private Cars carsByCarId;



    // relationshop with cars

    private Cars cars;

    @JsonIgnore
    @JsonSerialize
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CarID")
    public Cars getCars(){
        return this.cars;
    }
    public void setCars(Cars cars){
        this.cars = cars;
    }

    // relationship with SubGroups
    private Set<SubGroups> subGroups = new HashSet<SubGroups>();

    @JsonIgnore
    @JsonSerialize
    @OneToMany(mappedBy = "groupParts", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<SubGroups> getSubGroups(){
        return subGroups;
    }
    public void setSubGroups(Set<SubGroups> subGroups){
        this.subGroups = subGroups;
    }
    public void addSubGroups(SubGroups subGroups){
        subGroups.setGroupParts(this);
        getSubGroups().add(subGroups);
    }
    public void removeSubGroup(SubGroups subGroups){
        getSubGroups().remove(subGroups);
    }

    @JsonSerialize
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @JsonSerialize
    @Column(name = "groupName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupParts that = (GroupParts) o;

        if (id != that.id) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "carID", referencedColumnName = "id")
//    public Cars getCarsByCarId() {
//        return carsByCarId;
//    }
//
//    public void setCarsByCarId(Cars carsByCarId) {
//        this.carsByCarId = carsByCarId;
//    }
}
