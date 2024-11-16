import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        for(String id : req.getParameterValues("id")) {
            try {
                Storage.delete(Integer.parseInt(id));
            } catch(NumberFormatException e) {}
        }
        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}