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
@Table(name="Parts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parts {
    private int id;
    private String partName;

    //relationship with subgroup entity
    private SubGroups subGroups;


    @JsonIgnore
    @JsonSerialize
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SubGroupID")
    public SubGroups getSubGroups(){
        return this.subGroups;
    }
    public void setSubGroups(SubGroups subGroups){
        this.subGroups = subGroups;
    }

    //relationship with part details entity
    private Set<PartDetails> partDetails = new HashSet<PartDetails>();

    @JsonIgnore
    @JsonSerialize
    @OneToMany(mappedBy = "parts", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PartDetails> getPartDetails(){
        return this.partDetails;
    }
    public void setPartDetails(Set<PartDetails> partDetails){
        this.partDetails = partDetails;
    }
    public void addPartDetails(PartDetails partDetails){
        partDetails.setParts(this);
        getPartDetails().add(partDetails);
    }
    public void removePartDetails(PartDetails partDetails){
        getPartDetails().remove(partDetails);
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

    @JsonSerialize
    @Basic
    @Column(name = "partName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parts parts = (Parts) o;

        if (id != parts.id) return false;
        if (partName != null ? !partName.equals(parts.partName) : parts.partName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (partName != null ? partName.hashCode() : 0);
        return result;
    }
}
