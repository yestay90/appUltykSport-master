package org.growit.kz.dao;

import org.growit.kz.model.Cars;
import org.growit.kz.model.GroupParts;

import java.util.List;
import java.util.Set;

/**
 * Created by ymuratov on 2/13/15.
 */
public interface CarsDAO {
    public List<Cars> getAllCars();

    public void addRecordCars(Cars cars);

    public void deleteRecordCar(Cars cars);

    public Cars findByIdCars(int id);

    public String updateRecordsCars(Cars cars);

    public List<GroupParts> getGroupWithCarID(int id);
}
