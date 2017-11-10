package com.lanou.hr.action;

import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();
    @Resource(name = "staffService")
    private StaffService staffService;

    /**
     * 员工登录
     *
     * @return
     */
    public String login() {
        ServletActionContext.getRequest().getSession().setAttribute("staff",staff);
        staffService.login(staff);
        return SUCCESS;
    }

    /**
     *员工登录验证
     */
    public void validateLogin() {

        List<Staff> staffs = staffService.find(staff);
        for (Staff staff1 : staffs) {
            if (staff1.getLoginName().equals(staff.getLoginName())) {
                if (staff.getLoginPwd().equals(staff1.getLoginPwd())) {
                    break;
                } else {
                    addFieldError("password", "密码错误");
                }
            }
            break;
        }
    }

    /**
     * 登录拦截
     * @return
     */
    @SkipValidation
    public String interceptor(){
        return SUCCESS;
    }

    @Override
    public Staff getModel() {
        return staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
