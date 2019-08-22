package cn.zyuanyuan.controller;

import cn.zyuanyuan.common.ApplicationContextHelper;
import cn.zyuanyuan.common.JsonData;
import cn.zyuanyuan.dao.SysAclModuleMapper;
import cn.zyuanyuan.exception.ParamException;
import cn.zyuanyuan.exception.PermissionException;
import cn.zyuanyuan.model.SysAclModule;
import cn.zyuanyuan.param.TestVo;
import cn.zyuanyuan.util.BeanValidator;
import cn.zyuanyuan.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new PermissionException("test exception");
        // return JsonData.success("hello, permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException{
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));

        BeanValidator.check(vo);
     /*   try{
            Map<String,String> map = BeanValidator.validateObject(vo);
            if(MapUtils.isNotEmpty(map)){
                for(Map.Entry<String,String> entry: map.entrySet()){
                    log.info("{}->{}",entry.getKey(),entry.getValue());
                }
            }
        }catch (Exception e){
        }*/
        return JsonData.success("test validate");
    }

}
