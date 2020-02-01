package com.imooc.mmall.controller;


import com.imooc.mmall.pojo.User;
import com.imooc.mmall.qt.Const;
import com.imooc.mmall.service.IUserService;
import com.imooc.mmall.vo.ServerResponse;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-22:12
 * email 1437665365@qq.com
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    private Gson gson=new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @return
     */

    @RequestMapping(value = "login.do" ,method = RequestMethod.POST)
    @ResponseBody//返回json
    public ServerResponse<User> login(String username, String password,
                                      HttpSession session){
        ServerResponse<User> response = userService.login
                (username, password);
        log.info("result={}",gson.toJson(response));
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do" ,method = RequestMethod.GET)
    @ResponseBody//返回json
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        if(session==null){
            return ServerResponse.createBySuccess("退出成功");
        }
        
        return ServerResponse.createByMessage
                ("服务器异常");
    }

    @RequestMapping(value = "register.do" ,method = RequestMethod.GET)
    @ResponseBody//返回json
    public ServerResponse<String> register(User user){
        ServerResponse<String> register = userService.register(user);
        log.info("result={}",gson.toJson(register));
        return userService.register(user);
    }


}
