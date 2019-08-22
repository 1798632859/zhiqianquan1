package com.huyang.zhiqianquan.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyang.zhiqianquan.entity.Group;
import com.huyang.zhiqianquan.entity.UserGroup;
import com.huyang.zhiqianquan.service.GroupService;
import com.huyang.zhiqianquan.vo.JsonResult;
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
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
public class GroupApi {
    @Autowired
    GroupService GroupServiceImpl;

    @Value("${web.upload.image-path}")
    private String uploadpath;

    /**
     * 创建社区
     *
     * @param
     * @return
     */
    @RequestMapping("/api/group/add")
    public JsonResult addgroup(String groupImage, String groupCooment, String groupName, String userId) {
        JsonResult result = null;
        HashMap hashMap=new HashMap();
        Group group = new Group();
        group.setGroupId(UUID.randomUUID().toString());
        group.setGroupImage(groupImage);
        group.setGroupCooment(groupCooment);
        group.setGroupName(groupName);
        group.setFounderUser(userId);
        group.setGroupStatus("1");
        UserGroup userGroup=new UserGroup();
        userGroup.setGroupId(group.getGroupId());
        userGroup.setUserId(userId);
        userGroup.setUserGroupId(UUID.randomUUID().toString().replaceAll("-", ""));
        userGroup.setUserGroupStatus("1");
        hashMap.put("group",group);
        hashMap.put("userGroup",userGroup);
        try {
            if (group != null) {
                GroupServiceImpl.addgroup(hashMap);
                result = new JsonResult("200", "添加社区成功", group.getGroupId());
            } else {
                result = new JsonResult("400", "添加社区失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "添加社区异常", e.getMessage());
        }
        return result;
    }

    /**
     * 更改社区信息
     */
    @RequestMapping("/api/group/update")
    public JsonResult updategroup(String groupId, String groupImage, String groupCooment, String groupName) {
        JsonResult result = null;
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupImage(groupImage);
        group.setGroupCooment(groupCooment);
        group.setGroupName(groupName);
        try {
            if (group != null) {
                GroupServiceImpl.updategroup(group);
                result = new JsonResult("200", "修改社区成功", null);
            } else {
                result = new JsonResult("400", "修改社区失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "修改社区异常", e.getMessage());
        }
        return result;
    }

    /**
     * 查询社区，带模糊搜索，带Id搜索，或者查询所有社区
     */
    @RequestMapping("/api/group/query")
    public JsonResult querygroup(String groupId, String groupName,
                                 @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize) {
        JsonResult result = null;
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        try {
            PageHelper.startPage(pageNum, pageSize);
            List list = GroupServiceImpl.querygroup(group);
            PageInfo<Map> pageInfo = new PageInfo(list);
            if (list.size() > 0) {
                result = new JsonResult("200", "查询社区成功", pageInfo);
            } else {
                result = new JsonResult("400", "查询社区失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "查询社区异常", e.getMessage());
        }
        return result;
    }

    /**
     * 删除社区
     */
    @RequestMapping("/api/delete/group")
    public JsonResult deletegroup(String groupId) {
        JsonResult result = null;
        try {
            GroupServiceImpl.deletegroup(groupId);
            result = new JsonResult("200", "删除社区成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "删除社区异常", e.getMessage());
        }
        return result;
    }

    /**
     * 上传图片
     */
    @RequestMapping("/api/user/uploads")
    public JsonResult upload(@RequestParam("photo") MultipartFile file) {
        JsonResult result = null;
        String[] a = file.getOriginalFilename().split("\\.");
        if (!file.isEmpty()) {
            try {
                String filename = UUID.randomUUID().toString().replaceAll("-", "");
                file.transferTo(new File(uploadpath + "\\" + filename + "." + a[1]));
                result = new JsonResult("200", "上传成功", filename + "." + a[1]);
            } catch (Exception e) {
                e.printStackTrace();
                result = new JsonResult("500", "上传文件超过100kb", a[0]);
            }
        } else {
            result = new JsonResult("404", "找不到文件", "");
        }

        return result;
    }
    /**
     * 查询用户的所有群
     */
    @RequestMapping("/api/query/userallgroup")
    public JsonResult queryuserallgroup(String userId){
        JsonResult result = null;
        try {
            List list=GroupServiceImpl.queryuserallgroup(userId);
            result = new JsonResult("200", "查询所有社区成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "查询所有社区异常", e.getMessage());
        }
        return result;
    }

    /**
     * 查询该社区下所有的帖子
     */
    @RequestMapping("/api/query/groupchartroom")
    public JsonResult querygroupchartroom(String groupId) {
        JsonResult result = null;
        try {
            Group group = GroupServiceImpl.querygroupchartroom(groupId);
            result = new JsonResult("200", "查询所有社区成功", group);
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "查询所有社区异常", e.getMessage());
        }
        return result;
    }
    /**
     * 查询所有的群的人数，根据人数降序,并查询该用户已拥有的社区
     */
    @RequestMapping("/api/group/have")
    public JsonResult grouporder(String userId) {
        JsonResult result = null;
        try {
            HashMap map=GroupServiceImpl.grouporder(userId);
            if(map!=null){
                result = new JsonResult("200", "查询所拥有社区成功", map);
            }else{
                result = new JsonResult("400", "查询所拥有社区失败", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "查询所拥有社区异常", e.getMessage());
        }
        return result;
    }

}
