package back.servlet;

import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddFilesServlet")
@MultipartConfig
public class AddFilesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String savePath = "E:\\idea\\myBlog\\web\\WEB-INF\\uploadFiles";
            Part part = req.getPart("files");
            String head = part.getHeader("content-disposition");
            String fileName = getFileName(head);
            part.write(savePath + File.separator + fileName);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("上传文件");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFileName(String target) {
        String[] tempArr1 = target.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
        return fileName;
    }
}
