package back.servlet;

import back.bean.User;
import back.service.SysNoteService;
import back.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = (User) req.getSession().getAttribute("loginUser");
            String oldPass = req.getParameter("oldPass");
            String newPass = req.getParameter("newPass");
            String rePass = req.getParameter("rePass");
            if (oldPass.equals(user.getPassword()) && newPass.equals(rePass)) {
                userService.updatePassword(user);
                SysNoteService sysNoteService=new SysNoteService();
                sysNoteService.addSysNote("修改密码");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("sysSetting.jsp").forward(req, resp);
    }
}
