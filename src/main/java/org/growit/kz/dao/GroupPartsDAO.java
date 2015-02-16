package org.growit.kz.dao;

import org.growit.kz.model.GroupParts;
import org.growit.kz.model.SubGroups;

import java.util.List;

/**
 * Created by ymuratov on 2/13/15.
 */
public interface GroupPartsDAO {
    public List<GroupParts> getGroupPartsByCarID(int id);

    public List<GroupParts> getAllGroups();

    public List<SubGroups> getSubGroupByGroupID(int id);


}
