package org.growit.kz.model;

import javax.persistence.*;

/**
 * Created by ymuratov on 2/12/15.
 */
@Entity
@Table(name="PartDetails")
public class PartDetails {
    private String partNumber;
    private Parts partsByPartId;

    //relationship with parts
    private Parts parts;

    @ManyToOne
    @JoinColumn(name="PartID")
    public Parts getParts(){
        return this.parts;
    }
    public void setParts(Parts parts){
        this.parts = parts;
    }

    @Id
    @Column(name = "partNumber", nullable = false, insertable = true, updatable = true, length = 255)
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartDetails that = (PartDetails) o;

        if (partNumber != null ? !partNumber.equals(that.partNumber) : that.partNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return partNumber != null ? partNumber.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "partID", referencedColumnName = "id")
    public Parts getPartsByPartId() {
        return partsByPartId;
    }

    public void setPartsByPartId(Parts partsByPartId) {
        this.partsByPartId = partsByPartId;
    }
}
