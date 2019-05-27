package back.servlet;

import back.bean.User;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = (User) req.getSession().getAttribute("loginUser");
            String xingming = req.getParameter("xingming");
            String email = req.getParameter("email");
            User user1 = new User(user.getId(), user.getName(), user.getPassword(), xingming, email);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("保存用户信息");
            req.getSession().setAttribute("loginUser", user1);
            req.getRequestDispatcher("sysSetting.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
