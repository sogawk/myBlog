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

@WebServlet(urlPatterns = "/UpdateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
    BlogService blogService=new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user= (User) req.getSession().getAttribute("loginUser");
            String title = req.getParameter("title");
            String sign = req.getParameter("sign");
            String kind = req.getParameter("kind");
            String content = req.getParameter("content");
            int id= Integer.parseInt(req.getParameter("blogId"));
            blogService.updateBlog(id,title,content,sign,kind);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("编辑文章");
            req.getRequestDispatcher("SelectBlogServlet").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
