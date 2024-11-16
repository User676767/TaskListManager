import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        MyObject object = new MyObject();
        object.setFieldA(req.getParameter("field-a"));
        object.setFieldB(Double.parseDouble(req.getParameter("field-b")));
        object.setFieldC(req.getParameter("field-c") != null);

        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Storage.create(object);
        } else {
            Storage.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}