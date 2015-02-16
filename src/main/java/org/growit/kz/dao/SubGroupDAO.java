package org.growit.kz.dao;

import org.growit.kz.model.Parts;
import org.growit.kz.model.SubGroups;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ymuratov on 2/16/15.
 */
public interface SubGroupDAO {

    public List<Parts> getPartsBySubGroupID(int id);

}
