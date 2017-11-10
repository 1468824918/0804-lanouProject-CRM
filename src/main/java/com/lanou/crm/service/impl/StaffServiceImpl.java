package com.lanou.crm.service.impl;

import com.lanou.crm.dao.StaffDao;
import com.lanou.crm.domain.Staff;
import com.lanou.crm.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource(name = "staffDao")
    private StaffDao userDao;


    /**
     * 员工登录
     */
    @Override
    public Staff login(Staff staff) {
        userDao.login(staff);
        return staff;
    }

    /**
     * 员工查询
     * @param staff
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return userDao.find(staff);
    }
}
