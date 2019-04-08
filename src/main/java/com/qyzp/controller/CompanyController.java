package com.qyzp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyzp.annotation.ValidParam;
import com.qyzp.bean.Company;
import com.qyzp.bean.enums.RoleType;
import com.qyzp.service.CompanyService;
import com.qyzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/company")
public class CompanyController extends BaseApiController {
    @Autowired
    private CompanyService companyService;

//    @ValidParam("") == @ValidParam(value = "",required = false)
//    @ValidParam("test")  == @ValidParam(value = "test",required = false)


    @PostMapping("/annotationTest")
    public Map<String,Object> annotationTest(@RequestParam String param , @ValidParam(notblank = true) String param2) {
        Map<String,Object> map  = new HashMap<>();
        map.put("param",param);
        map.put("param2",param2);
        return resp(200,"",map);
    }


    @PostMapping("/register")//注册公司用户
    //uname,password,email,tel,companyName,address,headPic,detail,role_type
    public Map<String,Object> register(String uname,String password,String email,String tel,String companyName,String address,String headPic,String detail,Integer roleType){
        Company company =null ;
        if(VaildUtil.isPhone(uname)){
            company = companyService.loginByPhone(uname);
        }else if(VaildUtil.isEmail(uname)){
            company = companyService.loginByEmail(uname);
        }else {
            company = companyService.loginByUname(uname);
        }
        if(company == null){
            company = new Company()
                    .setUname(uname).setPassword(password)
                    .setEmail(email).setTel(tel).setRoleType(RoleType.valueOf(roleType))
                    .setAddress(address).setHeadPic(headPic).setDetail(detail).setCompanyName(companyName);
            if (companyService.registerCompany(company)==0) {
                return resp(405,"系统错误，注册失败",company);
            }
        }else{
            return resp(405,"注册失败,用户已存在");
        }

        return resp(200,"注册成功",company);
    }

    @PostMapping("/login")//登录
    public Map<String,Object> login(String uname, String password, HttpSession session) {
        Company company =null ;
        if(VaildUtil.isPhone(uname)){
            company = companyService.loginByPhone(uname);
        }else if(VaildUtil.isEmail(uname)){
            company = companyService.loginByEmail(uname);
        }else {
            company = companyService.loginByUname(uname);
        }
        if(company == null){return request(400,"该用户不存在",null);}
        if(!company.getPassword().equals(password)){return request(400,"密码错误",null);}
        session.setAttribute("company",company);
        return resp(200,"登录成功",company);
    }

    @PostMapping("/loginCheck")//登录用户名验证
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

    @PostMapping("/registerCheck")//注册公司验证
    public boolean registerCheck(String uname,String password) {
        //User user = new User().setUname(uname).setPassword(password);
        Company user = companyService.loginByUname(uname);
        //User user = userService.login(uname);
        if(user != null){return true;}
        else {
            return false;
        }
    }

    @PostMapping("/updateCompany")//修改公司信息
    public Map<String,Object> updateUser(Integer id,String uname,String password,String email,String tel,String companyName,String address,String headPic,String detail,Integer roleType){
        Company company = new Company().setId(id)
                .setUname(uname)
                .setPassword(password).setEmail(email).setTel(tel).setCompanyName(companyName)
                .setAddress(address).setDetail(detail).setHeadPic(headPic)
                .setRoleType(RoleType.valueOf(roleType)).setHeadPic(headPic).setDetail(detail);
        if(companyService.updateCompany(company)==0) {
            return resp(405,"修改失败");
        }
        return respUpdateSuccess();
    }

    //修改密码
    @PostMapping("updatePassword")
    public Map<String,Object> updatePassword(Integer id,String oldPassword,String newPassword) {
        Company company = companyService.queryCompanyById(id);
        if (company!=null) {
            if (!company.getPassword().equals(oldPassword)) {
                return resp(405,"原密码错误");
            }else {
                if (companyService.updatePassword(id,newPassword)==0) {
                    return resp(500,"修改密码失败遇到系统错误");
                }
            }
        }else {
            return resp(405,"用户不存在");
        }
        return resp(200,"修改密码成功",company);
    }

    /*@PostMapping("/updateCompanys")//批量修改用户信息
    public Map<String,Object> updateUsers(Integer id,String uname,String password){
        User user = new User().setId(id)
                .setUname(uname).
                        setPassword(password);
        userService.updateUser(user);
        return respUpdateSuccess();
    }*/

    @PostMapping("/delete")
    public Map<String,Object> deleteById(Integer id) {
        return respDelSuccess(companyService.deleteCompanyById(id));
    }

  /*  @PostMapping("/deletes")
    public Map<String,Object> deleteByIds(int... id) {
        return respDelSuccess(userService.deleteUserByIds(id));
    }*/

    @GetMapping("/queryAllCompany")
    public Map<String,Object> queryAllUser(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Company> users = companyService.queryAllCompany();
        PageInfo<Company> pageInfo = new PageInfo<>(users);
        return resp(200,"查询全部成功",pageInfo);
    }

    @GetMapping("/queryCompanyById")
    public Map<String,Object> queryCompanyById(Integer id) {
        Company company = companyService.queryCompanyById(id);
        return resp(200,"查询全部成功",company);
    }

    @PostMapping("/exceptionTest")
    public Map<String,Object> exceptionTest() throws Exception {
        Company company = null;
        throw  new Exception("抛出异常测试");
    }

    /*// 根据用户id查询用户信息
    User queryUserById();
    //查询所有用户信息
    List<User> queryAllUser();
    //修改用户信息
    int updateUser(User user);
    //根据id删除用户
    int deleteUserById(Integer id);*/
}

