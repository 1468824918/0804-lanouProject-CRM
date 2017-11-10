package com.lanou.crm.service;

import com.lanou.crm.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService {
    Staff login(Staff staff);
    List<Staff> find(Staff staff);
}
