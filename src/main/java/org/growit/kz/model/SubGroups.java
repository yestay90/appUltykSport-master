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
@Table(name ="SubGroups")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubGroups {
    private int id;
    private String subGroupName;
    private GroupParts groupPartsByGroupId;

    //relationsihip with group entity

    private GroupParts groupParts;
    
    @JsonIgnore
    @JsonSerialize
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "GroupID")
    public GroupParts getGroupParts(){
        return this.groupParts;
    }
    public void setGroupParts(GroupParts groupParts){
        this.groupParts = groupParts;
    }

    //relationship with
    private Set<Parts> parts = new HashSet<Parts>();

    @JsonIgnore
    @JsonSerialize
    @OneToMany(mappedBy = "subGroups", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Parts> getParts(){
        return this.parts;
    }
    public void setParts(Set<Parts> parts){
        this.parts = parts;
    }

    public void addParts(Parts parts){
        parts.setSubGroups(this);
        getParts().add(parts);
    }
    public void removeParts(Parts parts){
        getParts().remove(parts);
    }

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
    @Column(name = "subGroupName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubGroups subGroups = (SubGroups) o;

        if (id != subGroups.id) return false;
        if (subGroupName != null ? !subGroupName.equals(subGroups.subGroupName) : subGroups.subGroupName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subGroupName != null ? subGroupName.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "groupID", referencedColumnName = "id")
//    public GroupParts getGroupPartsByGroupId() {
//        return groupPartsByGroupId;
//    }
//
//    public void setGroupPartsByGroupId(GroupParts groupPartsByGroupId) {
//        this.groupPartsByGroupId = groupPartsByGroupId;
//    }
}
