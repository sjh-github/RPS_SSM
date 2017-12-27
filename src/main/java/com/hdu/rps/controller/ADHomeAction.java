package com.hdu.rps.controller;

import com.hdu.rps.model.RecommendedPerson;
import com.hdu.rps.model.ScoreRule;
import com.hdu.rps.model.User;
import com.hdu.rps.service.ADServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by DJX on 2017/11/23.
 * @author DJX
 * 管理员控制层
 */
@Transactional
@Controller
@RequestMapping("/ad")
public class ADHomeAction {

    private Logger logger = Logger.getLogger(String.valueOf(ADHomeAction.this));
    private ArrayList<User> userArrayList;
    private User user;
    private ArrayList<RecommendedPerson> recommendedPersonArrayList;
    private RecommendedPerson recommendedPerson;
    private ScoreRule scoreRule;

    @Autowired
    private ADServiceImpl adServiceImpl;

    /**
     * 用户信息管理
     * @param modelMap
     * @return 进入在职职工人员信息管理界面
     */
    @RequestMapping("/userManage")
    public String userManage(ModelMap modelMap) {
        logger.info("-----------/ad/userManage---------");
        userArrayList = adServiceImpl.findAllUserByJob("re");
        modelMap.addAttribute("userArrayList",userArrayList);
        return "thymeleaf/userManage";
    }

    /**
     * 用户信息编辑
     * @param userID 用户ID
     * @param modelMap
     * @return 进入在职职工信息编辑界面
     */
    @RequestMapping("/userManage/edit")
    public String userEdit(@RequestParam String userID, ModelMap modelMap) {
        logger.info("-----------/ad/userManage/edit---------");
        user = adServiceImpl.userManageEditByUserNO(Integer.parseInt(userID));
        modelMap.addAttribute("user",user);
        return "thymeleaf/userManageEdit";
    }

    /**
     * 用户信息编辑后提交
     * @param userno 用户ID
     * @param name 用户姓名
     * @param phone 用户手机号
     * @param email 用户邮箱
     * @param password 用户密码
     * @param sex 用户性别
     * @param score 用户所得分
     * @return 返回至用户信息管理界面
     */
    @RequestMapping("/userManage/edit/submit/{userno}")
    public String userManageEditSubmit(@PathVariable String userno, @RequestParam String name, @RequestParam String phone,
                                       @RequestParam String email, @RequestParam String password, @RequestParam String sex,
                                       @RequestParam String score) {
        adServiceImpl.userManageEditSubmit(Integer.parseInt(userno),name,phone,email,password,sex,score);
        return "redirect:/ad/userManage";
    }

    /**
     * 删除用户
     * @param userID 用户ID
     * @return 返回至用户信息管理界面
     */
    @RequestMapping("/userManage/del")
    public String userDel(@RequestParam String userID) {
        logger.info("-----------/ad/userManage/del?userID=" + userID);
        adServiceImpl.userManageDelByUserNO(Integer.parseInt(userID));
        return "redirect:/ad/userManage";
    }

    /**
     * 已审核人才库
     * @param modelMap
     * @return 进入已审核人才库信息界面
     */
    @RequestMapping("/recommendedPersonHaveChecked")
    public String recommendedPersonHaveChecked(ModelMap modelMap) {
        recommendedPersonArrayList = adServiceImpl.selectRecommendedPersonHaveChecked();
        modelMap.addAttribute("recommendedPersonArrayList",recommendedPersonArrayList);
        modelMap.addAttribute("adchecked",true);
        return "thymeleaf/recommend";
    }

    /**
     * 已审核人才库信息编辑
     * @param recommendedPersonID 用户ID
     * @param modelMap
     * @return 进入已审核人才库信息编辑界面
     */
    @RequestMapping("/recommendedHaveChecked/edit")
    public String recommendedHaveCheckedEdit(@RequestParam String recommendedPersonID, ModelMap modelMap) {
        recommendedPerson = adServiceImpl.selectRecommendPersonByRdpno(Integer.parseInt(recommendedPersonID));
        modelMap.addAttribute("recommendedPerson",recommendedPerson);
        return "thymeleaf/recommendedhavepassededit";
    }

    /**
     * 已审核人才库信息编辑提交
     * @param recommendedPersonID 用户ID
     * @param name 用户姓名
     * @param sex 用户性别
     * @param birthdate 用户出生日期
     * @param minzu 用户民族
     * @param mianmao 用户政治面貌
     * @param province 用户籍贯省份
     * @param city 用户籍贯城市
     * @param telphone 用户手机号
     * @param email 用户邮箱
     * @param address 用户住址
     * @param school 用户毕业学校
     * @param major 用户所学专业
     * @param xueli 用户学历
     * @param computer 用户计算机等级
     * @param english 用户英语等级
     * @param interest 用户兴趣爱好
     * @param file 用户照片文件
     * @return 返回至已审核人才库信息界面
     */
    @RequestMapping(value = "/recommendedHaveChecked/edit/submit",method = RequestMethod.POST)
    public String recommendedHaveCheckedEditSubmit(@RequestParam String recommendedPersonID, @RequestParam String name, @RequestParam String sex, @RequestParam String birthdate,
                                                   @RequestParam String minzu, @RequestParam String mianmao, @RequestParam String province,
                                                   @RequestParam String city, @RequestParam String telphone, @RequestParam String email,
                                                   @RequestParam String address, @RequestParam String school, @RequestParam String major,
                                                   @RequestParam String xueli, @RequestParam String computer, @RequestParam String english,
                                                   @RequestParam String interest, @RequestParam("file")MultipartFile file) {
        logger.info("--------/ad/recommendedHaveChecked/edit/submit-----");
        adServiceImpl.haveCheckedPersonEditSubmit(Integer.parseInt(recommendedPersonID),name,sex,birthdate,minzu,mianmao,province,city,telphone,email,address,school,major,xueli,computer,english,interest,file);
        return "redirect:/ad/recommendedPersonHaveChecked";
    }

    /**
     * 已审核人才库删除用户
     * @param recommendedPersonID 用户ID
     * @return 返回至已审核人才库信息界面
     */
    @RequestMapping("/recommendedHaveChecked/del")
    public String recommendedHaveCheckedDel(@RequestParam String recommendedPersonID) {
        logger.info("--------/ad/recommendedHaveChecked/del?recommendedPersonID=" + recommendedPersonID);
        adServiceImpl.delHavePassedRecommended(Integer.parseInt(recommendedPersonID));
        return "redirect:/ad/recommendedPersonHaveChecked";
    }

    /**
     * 进入待审核简历界面
     * @param modelMap
     * @return 进入待审核简历界面
     */
    @RequestMapping("/recommendedPersonNotChecked")
    public String recommendedPersonNotChecked(ModelMap modelMap) {
        recommendedPersonArrayList = adServiceImpl.selectRecommendedPersonNotChecked();
        if(recommendedPersonArrayList.size() == 0) {
            modelMap.addAttribute("allchecked",true);
        } else {
            modelMap.addAttribute("recommendedPersonArrayList",recommendedPersonArrayList);
        }
        modelMap.addAttribute("adnotchecked",true);
        return "thymeleaf/recommend";
    }

    /**
     * 查看待审核简历详情
     * @param recommendedPersonID 简历ID
     * @param modelMap
     * @return 进入待审核简历详情表单
     */
    @RequestMapping("/recommendedNotChecked/detail")
    public String recommendedNotCheckedDetail(@RequestParam String recommendedPersonID, ModelMap modelMap) {
        recommendedPerson = adServiceImpl.selectRecommendPersonByRdpno(Integer.parseInt(recommendedPersonID));
        modelMap.addAttribute("recommendedPerson",recommendedPerson);
        modelMap.addAttribute("adcheck",true);
        return "thymeleaf/recommendedPersonDetail";
    }

    /**
     * 通过简历审核
     * @param recommendedPersonID 简历ID
     * @return 返回至待审核简历界面
     */
    @RequestMapping("/recommendedNotChecked/pass")
    public String recommendedNotcheckedPass(@RequestParam String recommendedPersonID) {
        adServiceImpl.recommendedNotcheckedPass(Integer.parseInt(recommendedPersonID));
        return "redirect:/ad/recommendedPersonNotChecked";
    }

    /**
     * 不通过简历审核
     * @param recommendedPersonID 简历ID
     * @return 返回至待审核简历界面
     */
    @RequestMapping("/recommendedNotChecked/notpass")
    public String recommendedNotcheckedNotPass(@RequestParam String recommendedPersonID) {
        adServiceImpl.recommendedNotcheckedNotPass(Integer.parseInt(recommendedPersonID));
        return "redirect:/ad/recommendedPersonNotChecked";
    }

    /**
     * HR信息管理界面
     * @param modelMap
     * @return 进入HR信息管理界面
     */
    @RequestMapping("/hrManage")
    public String hrManage(ModelMap modelMap) {
        userArrayList = adServiceImpl.findAllUserByJob("hr");
        if(userArrayList.size() == 0) {
            modelMap.addAttribute("empty",true);
        } else {
            modelMap.addAttribute("userArrayList",userArrayList);
        }
        return "thymeleaf/hrManage";
    }

    /**
     * 添加HR界面
     * @return 进入添加HR界面
     */
    @RequestMapping("/hrManage/add")
    public String hrManageAdd() {
        logger.info("-----/ad/hrManage/add-----");
        return "thymeleaf/hrManageAdd";
    }

    /**
     * 提交新增HR申请
     * @param name HR姓名
     * @param phone HR手机号
     * @param email HR邮箱
     * @param password HR密码
     * @param sex HR性别
     * @return 返回至HR信息管理界面
     */
    @RequestMapping("/hrManage/add/submit")
    public String hrManageAddSubmit(@RequestParam String name, @RequestParam String phone,
                                    @RequestParam String email, @RequestParam String password,
                                    @RequestParam String sex) {
        adServiceImpl.hrManageAddSubmit(name,phone,email,password,sex);
        return "redirect:/ad/hrManage";
    }

    /**
     * HR信息编辑界面
     * @param userID HR ID
     * @param modelMap
     * @return 进入HR信息编辑界面
     */
    @RequestMapping("/hrManage/edit")
    public String hrManageEdit(@RequestParam String userID, ModelMap modelMap) {
        user = adServiceImpl.userManageEditByUserNO(Integer.parseInt(userID));
        modelMap.addAttribute("user",user);
        return "thymeleaf/hrManageEdit";
    }

    /**
     * 提交HR编辑申请
     * @param userno HR ID
     * @param name HR姓名
     * @param phone HR手机号
     * @param email HR邮箱
     * @param password HR密码
     * @param sex HR性别
     * @return 返回至HR信息管理界面
     */
    @RequestMapping("/hrManage/edit/submit/{userno}")
    public String hrManageEditSubmit(@PathVariable String userno, @RequestParam String name, @RequestParam String phone,
                                     @RequestParam String email, @RequestParam String password, @RequestParam String sex) {
        adServiceImpl.hrManageEditSubmit(Integer.parseInt(userno),name,phone,email,password,sex);
        return "redirect:/ad/hrManage";
    }

    /**
     * HR信息删除
     * @param userID HR ID
     * @param modelMap
     * @return 返回至HR管理界面
     */
    @RequestMapping("/hrManage/del")
    public String hrManageDel(@RequestParam String userID, ModelMap modelMap) {
        adServiceImpl.delHR(Integer.parseInt(userID));
        return "redirect:/ad/hrManage";
    }

    /**
     * 积分规则管理界面
     * @param modelMap
     * @return 进入积分规则管理界面
     */
    @RequestMapping("/scoreRuleManage")
    public String scoreRuleManage(ModelMap modelMap) {
        scoreRule = adServiceImpl.selectScoreRule();
        modelMap.addAttribute("scoreRule",scoreRule);
        return "jsp/scoreRuleManage";
    }

    /**
     * 修改积分规则
     * @param scoreRule
     * @return 返回至积分规则管理界面
     */
    @RequestMapping("/updateScoreRule")
    public String updateScoreRule(@ModelAttribute ScoreRule scoreRule) {
        adServiceImpl.updateScoreRule(scoreRule);
        return "redirect:/ad/scoreRuleManage";
    }
}
