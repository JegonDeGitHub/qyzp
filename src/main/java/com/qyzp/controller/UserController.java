package com.qyzp.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyzp.annotation.ValidParam;
import com.qyzp.bean.Job;
import com.qyzp.bean.enums.RoleType;
import com.qyzp.bean.User;
import com.qyzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/user")
//@SessionAttributes(types = User.class)//Session域中存放User类的对象
public class UserController extends BaseApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadController uploadController;

//    @ValidParam("") == @ValidParam(value = "",required = false)
//    @ValidParam("test")  == @ValidParam(value = "test",required = false)


    @PostMapping("/annotationTest")
    public Map<String,Object> annotationTest(@RequestParam String param , @ValidParam(notblank = true) String param2) {
        Map<String,Object> map  = new HashMap<>();
        map.put("param",param);
        map.put("param2",param2);
        return resp(200,"",map);
    }


    @PostMapping("/register")//注册用户
    //uname,password,email,tel,willPosition,roleType,sex,headPic,detail,userName
    public Map<String,Object> register(String uname,String password,String email,String tel,String willPosition,Integer roleType,String sex,String headPic,String detail,String userName){
        User  user =null ;
        if(VaildUtil.isPhone(uname)){
            user = userService.loginByPhone(uname);
        }else if(VaildUtil.isEmail(uname)){
            user = userService.loginByEmail(uname);
        }else {
            user = userService.loginByUname(uname);
        }
        if(user == null){
            user = new User()
                    .setUname(uname).setPassword(password)
                    .setEmail(email).setTel(tel)
                    .setWillPosition(willPosition).setRoleType(RoleType.valueOf(roleType))
                    .setSex(sex).setHeadPic(headPic).setDetail(detail).setUserName(userName);
            if (userService.registerUser(user)==0) {
                return resp(405,"系统错误，注册失败",user.getId());
            }
        }else{
            return resp(405,"注册失败,用户已存在");
        }

        return resp(200,"注册成功",user.getId());
    }

    @Transactional
    @PostMapping("/registers")//批量注册用户
    public Map<String,Object> registers(Boolean cancel) throws Exception{
        User user = new User()
                .setUname(new Random().nextInt(1000) + "")
                .setPassword("454sdfgdf")
                .setEmail(new Random().nextInt(1000) + "43543gfd@qq.com")
                .setTel(new Random().nextInt(100) + "5435435")
                .setRoleType(RoleType.ADMIN)
                .setSex("男");
        if(userService.registerUsers(user)==0) {
            return resp(405, "添加失败");
        }
        System.out.println("添加成功"+user.getId());
        if(Boolean.TRUE.equals(cancel)) throw  new RuntimeException("抛出异常测试");
        return resp(200, "添加成功", user);
    }

    @PostMapping("/login")//登录
    public Map<String,Object> login(String uname, String password, HttpSession session) {
        User  user =null ;
        if(VaildUtil.isPhone(uname)){
            user = userService.loginByPhone(uname);
        }else if(VaildUtil.isEmail(uname)){
            user = userService.loginByEmail(uname);
        }else {
            user = userService.loginByUname(uname);
        }
        if(user == null){return request(400,"该用户不存在",null);}
        if(!user.getPassword().equals(password)){return request(400,"密码错误",null);}
        session.setAttribute("user",user);//session域中放入用户对象
        return resp(200,"登录成功",user);
    }

    @PostMapping("/loginCheck")//注册用户名验证
    public int loginCheck(String uname) {
        boolean tel  = true;//是数字
        for(int i=uname.length()-1;i>=0;i--){
            if(uname.charAt(i)=='@'){
                return 1;
            }else if( !Character.isDigit(uname.charAt(i)) ){ //不是数字
                tel = false;
            }
        }
        if(tel){
            return 2;
        }
        return 0;
    }

    @PostMapping("/registerCheck")//注册用户名验证
    public boolean registerCheck(String uname,String password) {
        //User user = new User().setUname(uname).setPassword(password);
        User user = userService.loginByUname(uname);
        //User user = userService.login(uname);
        if(user != null){return true;}
        else {
            return false;
        }
    }

    @PostMapping("/updateUser")//修改用户信息
    //Integer id,String uname,String password,String email,String tel,String willPosition,Integer roleType,String sex,String headPic,String detail,String userName
    public Map<String,Object> updateUser(Integer id,String uname,String password,String email,String tel,String willPosition,Integer roleType,String sex,String headPic,String detail,String userName){
        User user = new User().setId(id)
                                .setUname(uname)
                .setPassword(password).setEmail(email).setTel(tel).setWillPosition(willPosition)
                .setRoleType(RoleType.valueOf(roleType)).setHeadPic(headPic).setDetail(detail).setUserName(userName);
        if(userService.updateUser(user)==0) {
            return resp(405,"修改失败");
        }
        return resp(200,"修改成功",user);
    }

    //修改密码
    @PostMapping("/updatePassword")
    public Map<String,Object> updatePassword(Integer id,String oldPassword,String newPassword) {
        User user = userService.queryUserById(id);
        if (user!=null) {
            if (!user.getPassword().equals(oldPassword)) {
                return resp(405,"原密码错误");
            }else {
                if (userService.updatePassword(id,newPassword)==0) {
                    return resp(405,"修改密码失败遇到未知错误");
                }
            }
        }else {
            return resp(405,"用户不存在");
        }
        return resp(200,"修改密码成功",user);
    }

    //修改头像
    @PostMapping("/updateHead")
    public Map<String,Object> updateHead(Integer id,String headPic) {
        User user = userService.queryUserById(id);
        if (user!=null) {
            if (userService.updateHead(id,headPic)==0) {
                return resp(405,"修改头像失败遇到未知错误");
            }
        }else {
            return resp(405,"用户不存在");
        }
        return resp(200,"修改头像成功",user);
    }

    @PostMapping("/updateUsers")//批量修改用户信息
    public Map<String,Object> updateUsers(Integer id,String uname,String password){
        User user = new User().setId(id)
                .setUname(uname).
                        setPassword(password);
        userService.updateUser(user);
        return respUpdateSuccess();
    }

    @PostMapping("/delete")
    public Map<String,Object> deleteById(Integer id) {
        return respDelSuccess(userService.deleteUserById(id));
    }

    @PostMapping("/deletes")
    public Map<String,Object> deleteByIds(int... id) {
        return respDelSuccess(userService.deleteUserByIds(id));
    }

    @GetMapping("/queryAllUser")
    public Map<String,Object> queryAllUser(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userService.queryAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        if(users==null){
            return resp(400,"岗位不存在",users);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @PostMapping("/testRoleType")
    public Map<String,Object> add(RoleType roleType) {
        System.out.println("roletype:"+roleType.toString());
        return null;
    }

    @PostMapping("/queryUserById")
    public  Map<String,Object> queryUserById( Integer id) {
        User user = userService.queryUserById(id);
        if(user==null){
            return resp(400,"用户不存在",user);
        }
        return resp(200,"查询成功",user);
    }

    @PostMapping("/exceptionTest")
    public Map<String,Object> exceptionTest() throws Exception {
        User user =null;
        throw  new Exception("抛出异常测试");
    }

}
