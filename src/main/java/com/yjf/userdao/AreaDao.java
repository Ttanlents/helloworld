package com.yjf.userdao;

import com.yjf.entity.Area;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/21 17:29
 * @Description
 */
public interface AreaDao {
    List<Area> selectProvince();
    List<Area> selectAreaByParentId(Integer parentId);
}
