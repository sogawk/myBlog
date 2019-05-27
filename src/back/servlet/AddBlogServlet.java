package back.servlet;

import back.bean.User;
import back.service.BlogService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddBlogServlet")
public class AddBlogServlet extends HttpServlet {
    BlogService blogService = new BlogService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            String way = req.getParameter("way");
            String sign = req.getParameter("sign");
            String kind = req.getParameter("kind");
            String content = req.getParameter("content");
            User loginUser = (User) req.getSession().getAttribute("loginUser");
            blogService.addBlog(loginUser, title, way, sign, kind, content);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("发布文章");
            req.getRequestDispatcher("SelectBlogServlet").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
