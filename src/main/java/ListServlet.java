import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        Collection<MyObject> objects = Storage.readAll();
        req.setAttribute("objects", objects);
        getServletContext().getRequestDispatcher("/WEB-INF/index.html")
                                                      .forward(req, resp);
    }
}