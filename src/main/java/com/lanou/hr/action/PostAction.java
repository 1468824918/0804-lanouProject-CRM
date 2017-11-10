package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller("postAction")
public class PostAction extends ActionSupport implements ModelDriven<Post> {

    private Post post = new Post();

    @Resource(name = "postService")
    private PostService postService;
//    private List<Department> department;
    private List<Post> postAndDepartment;

    /**
     * 职务管理(插入职务)
     *
     * @return
     */
    public String addSavePost() {
        postService.addSavePost(post);
        return SUCCESS;
    }

    /**
     * 查询所有职务
     *
     * @return
     */
    public String findPost() {
        postAndDepartment = postService.findPostAndDepartment();
        System.out.println(postAndDepartment);
        return SUCCESS;
    }

    @Override
    public Post getModel() {
        return post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



//    public List<Department> getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(List<Department> department) {
//        this.department = department;
//    }

    public List<Post> getPostAndDepartment() {
        return postAndDepartment;
    }

    public void setPostAndDepartment(List<Post> postAndDepartment) {
        this.postAndDepartment = postAndDepartment;
    }

}
