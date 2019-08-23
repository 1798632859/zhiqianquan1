package com.huyang.zhiqianquan.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.dialect.AbstractDialect;
import com.github.pagehelper.dialect.helper.HsqldbDialect;
import com.huyang.zhiqianquan.entity.Admin;
import com.huyang.zhiqianquan.entity.Tenancy;
import com.huyang.zhiqianquan.entity.User;
import com.huyang.zhiqianquan.service.ChatroomService;
import com.huyang.zhiqianquan.service.UserService;
import com.huyang.zhiqianquan.vo.JsonResult;
import com.huyang.zhiqianquan.vo.MyCollection;
import com.huyang.zhiqianquan.vo.MySend;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class UserApi {
    @Autowired
    UserService UserServiceImpl;

    @Autowired
    ChatroomService chatroomServiceimpl;
    @Value("${web.upload.image-path}")
    String uploadpath;
    /**
     *带分页查询所有用户
     * @return
     */
    @RequestMapping("/api/user/queryalluser")
    public JsonResult queryalluser(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize){

        JsonResult result=null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List users = UserServiceImpl.queryalluser();
            if (users != null) {
                PageInfo pageInfo = new PageInfo(users);
                result = new JsonResult("200", "查询成功", pageInfo);
                return result;
            } else {
                result = new JsonResult("404", "查询失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }

    }

    /***
     * 查询用户发布的房源信息
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/queryhousebyuserid")
    public  JsonResult queryhousebyuserid(String userId){
        return new JsonResult("200","success",UserServiceImpl.queryhousebyuserid(userId));
    }

    /***
     * 查询用户发布的求职信息
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/queryworkbyuserid")
    public JsonResult queryworkbyuserid(String userId){
        return new JsonResult("200","success",UserServiceImpl.queryworkbyuserid(userId));
    }

    /***
     * 查询用户发送的求租
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/querytenancybyuserid")
    public JsonResult querytenancybyuserid(String userId){
        return new JsonResult("200","success",UserServiceImpl.querytenancybyuserid(userId));
    }
    /***
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/queryuserbyuserid")
    public JsonResult queryuserbyuserid(String userId){
        JsonResult result=null;
        try {
        User user=UserServiceImpl.queryuserbyuserid(userId);
        if(user!=null){
            result=new JsonResult("200","查询成功",user);
        }else {
            result=new JsonResult("400","查询失败","");
        }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }

    /***
     * 查询用户发布的职言
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/querychatroombyuserid")
    public JsonResult querychatroombyuserid(String userId){
        JsonResult result=null;
        try {
            List chatrooms=UserServiceImpl.querychatroombyuserid(userId);
            if(chatrooms.size()!=0){
                result=new JsonResult("200","查询成功",chatrooms);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }

    /***
     * 根据用户ID更新用户信息
     * @param userSex
     * @param userSchool
     * @param userCompany
     * @param userPost
     * @param userVx
     * @param userTelephone
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/updateuserbyid")
    public  JsonResult updateuserbyid(String userSex,String userSchool,String userCompany,String userPost,String userVx,String userTelephone,String userId){
        HashMap map =new HashMap();
        map.put("userSex",userSex);
        map.put("userSchool",userSchool);
        map.put("userCompany",userCompany);
        map.put("userPost",userPost);
        map.put("userVx",userVx);
        map.put("userTelephone",userTelephone);
        map.put("userId",userId);
        JsonResult result=null;
        try {
            int i=UserServiceImpl.updateuserbyid(map);
            if(i!=0){
                result=new JsonResult("200","修改成功",i);
            }else {
                result=new JsonResult("400","修改失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }
    /***
     * 查询用户收藏的实习信息
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/querycollectionworkbyuserid")
    public JsonResult querycollectionworkbyuserid(String userId){
        JsonResult result=null;
        System.out.println(userId);
        try {
            List collections=UserServiceImpl.querycollectionworkbyuserid(userId);
            if(collections.size()!=0){
                result=new JsonResult("200","查询成功",collections);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }

    /***
     * 查询用户收藏的求租信息
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/querycollectiontenancybyuserid")
    public JsonResult querycollectiontenancybyuserid(String userId){
        JsonResult result=null;
        System.out.println(userId);
        try {
            List collections=UserServiceImpl.querycollectiontenancybyuserid(userId);
            if(collections.size()!=0){
                result=new JsonResult("200","查询成功",collections);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }
    /***
     * 查询用户收藏的房源信息
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/querycollectionhousebyuserid")
    public JsonResult querycollectionhousebyuserid(String userId){
        JsonResult result=null;
        System.out.println(userId);
        try {
            List collections=UserServiceImpl.querycollectionhousebyuserid(userId);
            if(collections.size()!=0){
                result=new JsonResult("200","查询成功",collections);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }

    /***
     * 查询用户的收藏的所有信息。
     * @param userId
     * @return
     */
    @RequestMapping("/api/user/querycollection")
    public JsonResult querycollection(String userId){
        JsonResult result=null;
        System.out.println(userId);
        try {
            List chouses=UserServiceImpl.querycollectionhousebyuserid(userId);
            List ctenancys=UserServiceImpl.querycollectiontenancybyuserid(userId);
            List cworks=UserServiceImpl.querycollectionworkbyuserid(userId);
            MyCollection collections=new MyCollection(cworks,ctenancys,chouses);
            if(collections!=null){
                result=new JsonResult("200","查询成功",collections);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }


    /***
     * 上传图片接口实现
     * @param file
     * @return
     */
    @RequestMapping("/api/user/uploadimage")
    public JsonResult upload(@RequestParam("photo") MultipartFile file){
        JsonResult result =null;
        String [] a=file.getOriginalFilename().split("\\.");
        if(!file.isEmpty()){
            try{
                String filename= UUID.randomUUID().toString().replaceAll("-","");
                file.transferTo(new File(uploadpath+"\\"+filename+"."+a[1]));
                result=new JsonResult("200","上传成功",filename+"."+a[1]);
            }catch(Exception e){
                e.printStackTrace();
                result=new JsonResult("500","上传异常",a[0]);
            }
        }else{
            result=new JsonResult("404","找不到文件","");
        }

        return result;
    }


    /***
     * 用户发布的所有帖子
     */
    @RequestMapping("/api/user/mysend")
    public JsonResult querycsend(String userId){
        JsonResult result =null;
        try {
            List SChartroom=chatroomServiceimpl.selectchatroomallbyId(userId);
            List STenancy=UserServiceImpl.querytenancybyuserid(userId);
            List SWork= UserServiceImpl.queryworkbyuserid(userId);
            List SHouse =UserServiceImpl.queryhousebyuserid(userId);
            MySend sends=new MySend(SChartroom,STenancy,SWork,SHouse);

            if(sends!=null){
                result=new JsonResult("200","查询成功",sends);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            result= new JsonResult("500","异常","");
        }
    return result;

    }


    /***
     * admin登陆接口
     */
    @RequestMapping("/api/admin/login")
    public JsonResult loginadmin(String userName ,String password){
        JsonResult result =null;
        HashMap map=new HashMap();
        map.put("userName",userName);
        map.put("password",password);
        try {
            Admin admin =UserServiceImpl.loginadmin(map);
            if(admin!=null){
                result=new JsonResult("200","登陆成功",admin);
            }else {
                result=new JsonResult("400","登陆失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;
    }

    /***
     *
     * @param name
     * @param password
     * @param realname
     * @param age
     * @param hobby
     * @param vx
     * @param describe
     * @return
     */
    @RequestMapping("/api/user/registeradmin")
public JsonResult registeradmin(String name,String password,String realname,int age,String hobby,String vx,String describe){
    Admin admin =new Admin();
    admin.setName(name);
    admin.setPassword(password);
    admin.setRealname(realname);
    admin.setAge(age);
    admin.setHobby(hobby);
    admin.setVx(vx);
    admin.setDescribe(describe);
    JsonResult result =null;
    try {
        Integer i=UserServiceImpl.registeradmin(admin);
        if(i!=0){
            result=new JsonResult("200","注册成功",admin.getId());
        }else {
            result=new JsonResult("400","注册失败","");
        }
    }catch (Exception e){
        e.printStackTrace();
        return new JsonResult("500","异常","");
    }
    return result;
}



    @RequestMapping("/api/user/updateadminbyid")
    public JsonResult updateadminbyid(String id,String name,String password,String realname,String age,String hobby,String vx,String describe) {
        JsonResult result =null;
        HashMap map =new HashMap();
        map.put("id",id);
        map.put("name",name);
        map.put("password",password);
        map.put("realname",realname);
        map.put("age",age);
        map.put("hobby",hobby);
        map.put("vx",vx);
        map.put("describe",describe);
        try {
            Integer i=UserServiceImpl.updateadminbyid(map);
            if(i!=0){
                result=new JsonResult("200","修改成功",i);
            }else {
                result=new JsonResult("400","修改失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult("500","异常","");
        }
        return result;


    }


    }
