package com.lanou.crm.dao.impl;

import com.lanou.crm.dao.StaffDao;
import com.lanou.crm.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    /**
     * 员工的登录
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff) {
        getHibernateTemplate().save(staff);
        return staff;
    }

    @Override
    public List<Staff> find(Staff staff) {
        return (List<Staff>) getHibernateTemplate().find("from Staff crm_staff");
    }
}
