package back.servlet;

import back.service.KindSignService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddKindSignServlet")
public class AddKindSignServlet extends HttpServlet {
    KindSignService kindSignService = new KindSignService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String kind = req.getParameter("kind");
            if (kind != null) {
                int id = kindSignService.getKindsign("kind", kind);
                if (id == 0) {
                    kindSignService.addKindSign("kind", kind);
                    SysNoteService sysNoteService=new SysNoteService();
                    sysNoteService.addSysNote("新增分类");
                }
            }
            req.getRequestDispatcher("SelectKindSignServlet").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
