package back.servlet;

import back.bean.User;
import back.service.SysNoteService;
import back.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();
    SysNoteService sysNoteService=new SysNoteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String ck = req.getParameter("ck");
            User user = userService.loginJudge(name, password);
            if (user == null) {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
            if (ck != null && ck.equals("on")) {
                Cookie loginUserCookie = new Cookie("loginUser", URLEncoder.encode(name, "utf8") + "-" + URLEncoder.encode(password, "utf8"));
                loginUserCookie.setMaxAge(5 * 365 * 24 * 60 * 60);
                resp.addCookie(loginUserCookie);
            } else {
                Cookie deleteCookie = new Cookie("loginUser", URLEncoder.encode(name, "utf8") + "-" + URLEncoder.encode(password, "utf8"));
                deleteCookie.setMaxAge(0);
                resp.addCookie(deleteCookie);
            }
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", user);
            sysNoteService.addSysNote("登陆系统");
            req.getRequestDispatcher("DashBoardServlet").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
