package back.servlet;

import back.bean.Blog;
import back.bean.Pagebean;
import back.service.BlogService;
import back.service.CommentService;
import back.service.FriendLinkService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    FriendLinkService friendLinkService = new FriendLinkService();
    SysNoteService sysNoteService = new SysNoteService();
    CommentService commentService = new CommentService();
    Pagebean pagebean1 = new Pagebean();
    Pagebean pagebean2 = new Pagebean();
    Pagebean pagebean3 = new Pagebean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int blogNumber = blogService.totalBlog();
            int linkNumber = friendLinkService.totalLink();

            pagebean1.setTotalDate(blogService.totalBlog());
            pagebean1.setPageDate(4);
            blogService.displayBlog(pagebean1, "order by id desc");


            int commentNumber = commentService.totalComment();
            pagebean2.setTotalDate(commentNumber);
            pagebean2.setPageDate(pagebean2.getTotalDate());
            Blog blog = (Blog) req.getAttribute("blog");
            commentService.displayRencentComment(pagebean2);
            req.setAttribute("commentPageBean", pagebean2);

            sysNoteService.selectSysNote(pagebean3);

            req.setAttribute("commentNumber", commentNumber);
            req.setAttribute("blogPagebean", pagebean1);
            req.setAttribute("sysNotePagebean", pagebean3);
            req.setAttribute("blogNumber", blogNumber);
            req.setAttribute("linkNumber", linkNumber);
            req.getRequestDispatcher("dashBoard.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
