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
        Storage.create(object);

        /* отправка ответа в браузер с указанием перейти по другому URL */
        resp.sendRedirect(req.getContextPath() + "/index.html");

    }
}