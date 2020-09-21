package com.yjf.servlet;

import com.yjf.entity.Area;
import com.yjf.service.AreaService;
import com.yjf.userdao.AreaDao;
import com.yjf.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/21 18:06
 * @Description
 */
@WebServlet("/area")
public class AreaServlet extends HttpServlet {
    AreaDao areaDao=new AreaService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name!=null&&!name.equals("")){
            if (name.equals("province")){
                List<Area> list = areaDao.selectProvince();
                JsonUtils.responseJSON(resp,list);
                return;
            }
        }
        String parentId=req.getParameter("parentId");
        List<Area> list = areaDao.selectAreaByParentId(Integer.parseInt(parentId));
        JsonUtils.responseJSON(resp,list);
    }
}
