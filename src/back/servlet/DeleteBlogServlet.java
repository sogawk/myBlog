package back.servlet;

import back.service.BlogService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/DeleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
    BlogService blogService = new BlogService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("blogId"));
            blogService.deleteBlog(id);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("删除文章");
            req.getRequestDispatcher("SelectBlogServlet").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
