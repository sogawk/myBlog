package back.servlet;

import back.bean.Pagebean;
import back.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/FrontDeskServlet")
public class FrontDeskServlet extends HttpServlet {
    BlogService blogService=new BlogService();
    Pagebean pagebean = new Pagebean();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            pagebean.setTotalDate(blogService.totalBlog());
            pagebean.setPageDate(6);
            blogService.displayBlog(pagebean,"order by id desc");
            req.setAttribute("blogPagebean", pagebean);
            req.getRequestDispatcher("front.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
