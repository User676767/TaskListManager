import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        @SuppressWarnings("unchecked")
        Collection<MyObject> objects = (Collection<MyObject>)req.getAttribute("objects");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("<STYLE>");
        w.println("TABLE {");
        w.println("border-collapse: collapse;");
        w.println("}");
        w.println("TH, TD {");
        w.println("border: 1px solid black;");
        w.println("padding: 5px 30px 5px 10px;");
        w.println("}");
        w.println("</STYLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"delete.html\" method=\"post\">");
        w.println("<TABLE>");
        w.print("<TR>");
        w.print("<TH>&nbsp;</TH>");
        w.print("<TH>Поле A</TH>");
        w.print("<TH>Поле B</TH>");
        w.print("<TH>Поле C</TH>");
        w.println("</TR>");
        for(MyObject object : objects) {
        //
            w.print("<TR>");
            w.printf("<TD>");
            w.printf("<INPUT type=\"checkbox\" name=\"id\" value=\"%d\">",
                     object.getId());
            w.printf("</TD>");
            w.printf("<TD><A href=\"edit.html?id=%d\">%s</A></TD>",
                     object.getId(), object.getFieldA());
            w.printf("<TD>%.2f</TD>", object.getFieldB());
            w.printf("<TD>%s</TD>", object.getFieldC() ? "Да" : "Нет");
            w.println("</TR>");
        }
        w.println("</TABLE>");
        w.println("<P>");
        w.println("<A href=\"edit.html\">Добавить</A>");
        w.println("<BUTTON type=\"submit\">Удалить</BUTTON>");
        w.println("</P>");
        w.println("</FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
    }
}
