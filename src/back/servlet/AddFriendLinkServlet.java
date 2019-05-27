package back.servlet;

import back.service.FriendLinkService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddFriendLinkServlet")
public class AddFriendLinkServlet extends HttpServlet {
    FriendLinkService friendLinkService = new FriendLinkService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            String address = req.getParameter("address");
            String turn = req.getParameter("turn");
            friendLinkService.addFriendLink(title, address);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("保存友链");
            req.getRequestDispatcher("SelectFriendLinkServlet").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
