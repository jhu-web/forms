package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Shows all the parameters sent to the servlet via either GET or POST. Specially marks
 * parameters that have no values or multiple values.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the coreservlets.com
 * tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */
@WebServlet("/show-params")
public class ShowParameters
  extends HttpServlet {

  private static final long serialVersionUID = -3800694340590458851L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType = "<!doctype html>\n";
    String title = "Reading All Request Parameters";
    out.println(docType + "<html>\n"
                + "<head><title>"
                + title
                + "</title></head>\n"
                + "<body style=\"background-color: #FDF5E6;\">\n"
                + "<h1 style=\"text-align: center;\">"
                + title
                + "</h1>\n"
                + "<table style=\"border: 1px solid black; margin: 0px auto;\">\n"
                + "<tr style=\"background-color: #FFAD00\">\n"
                + "<th>Parameter Name</th><th>Parameter Value(s)</th>");
    Enumeration<String> paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      out.print("<tr><td>" + paramName + "</td>\n<td>");
      String[] paramValues = request.getParameterValues(paramName);
      if (paramValues.length == 1) {
        String paramValue = paramValues[0];
        if (paramValue.length() == 0) {
          out.println("<i>No Value</i>");
        }
        else {
          out.print(paramValue);
        }
      }
      else {
        out.println("<ul>");
        for (int i = 0; i < paramValues.length; i++) {
          out.println("<li>" + paramValues[i]);
        }
        out.println("</ul>");
      }
      out.print("</td></tr>");
    }
    out.println("</table>\n</body></html>");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    doGet(request, response);
  }
}
