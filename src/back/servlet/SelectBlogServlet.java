package back.servlet;

import back.bean.Pagebean;
import back.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/SelectBlogServlet")//必须加/
public class SelectBlogServlet extends HttpServlet {
    BlogService blogService=new BlogService();
    Pagebean pagebean=new Pagebean();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            pagebean.setTotalDate(blogService.totalBlog());
            pagebean.setPageDate(8);

            if(req.getParameter("pagenumber")!=null){
                int currentPage=Integer.parseInt(req.getParameter("pagenumber"));
                if(currentPage>pagebean.getTotalPage()||currentPage<1)currentPage=pagebean.getCurrentPage();
                pagebean.setCurrentPage(currentPage);
            }

            blogService.displayBlog(pagebean,"");

            HttpSession session=req.getSession();
            session.setAttribute("articalPagebean",pagebean);
            req.getRequestDispatcher("selectBlog.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
