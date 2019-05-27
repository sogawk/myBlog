package back.servlet;

import back.service.FriendLinkService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/DeleteFriendLinkServlet")
public class DeleteFriendLinkServlet extends HttpServlet {
    FriendLinkService friendLinkService = new FriendLinkService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            friendLinkService.deleteFriendLink(id);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("删除友链");
            req.getRequestDispatcher("SelectFriendLinkServlet").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
