package back.servlet;

import back.bean.Pagebean;
import back.service.FriendLinkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/SelectFriendLinkServlet")
public class SelectFriendLinkServlet extends HttpServlet {
    FriendLinkService friendLinkService=new FriendLinkService();
    Pagebean pagebean=new Pagebean();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            pagebean.setTotalDate(friendLinkService.totalLink());
            pagebean.setPageDate(8);

            if(req.getParameter("pagenumber")!=null){
                int currentPage=Integer.parseInt(req.getParameter("pagenumber"));
                if(currentPage>pagebean.getTotalPage()||currentPage<1)currentPage=pagebean.getCurrentPage();
                pagebean.setCurrentPage(currentPage);
            }

             pagebean=friendLinkService.displayFiendLink(pagebean);

            HttpSession session=req.getSession();
            session.setAttribute("friendLinkPagebean",pagebean);
            req.getRequestDispatcher("friend.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
