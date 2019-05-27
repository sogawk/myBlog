package back.servlet;

import back.service.KindSignService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/SelectKindSignServlet")
public class SelectKindSignServlet extends HttpServlet {
    KindSignService kindSignService = new KindSignService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List signList = kindSignService.selectKindSign("sign");
            List kindList = kindSignService.selectKindSign("kind");
            req.setAttribute("signList", signList);
            req.setAttribute("kindList", kindList);
            String pathh = req.getParameter("pathh");
            String blogId = req.getParameter("blogId");
            if (blogId != null) {
                req.setAttribute("blogId", blogId);
                req.getRequestDispatcher("addBlog.jsp").forward(req, resp);
            }

            if (pathh != null) {
                req.getRequestDispatcher("addBlog.jsp").forward(req, resp);
            }

            req.getRequestDispatcher("kindSign.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
