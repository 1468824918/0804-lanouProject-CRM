package com.lanou.crm.dao.impl;

import com.lanou.crm.dao.StaffDao;
import com.lanou.crm.domain.Staff;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImplTest extends HibernateDaoSupport implements StaffDao{


    @Override
    public Staff login(Staff staff) {
        return null;
    }

    @Test
    @Override
    public List<Staff> find(Staff staff) {
        List<Staff> list = (List<Staff>) getHibernateTemplate().find("from Staff where loginName=?");
        return list;
    }
}