package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that prints out the param1, param2, and param3 request parameters. Does not
 * filter out html tags.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the coreservlets.com
 * tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */
@WebServlet("/three-params")
public class ThreeParams
  extends HttpServlet {

  private static final long serialVersionUID = -8116975173488212346L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String docType = "<!doctype html>\n";
    out.println(docType + "<html>\n"
                + "<head><title>"
                + title
                + "</title></head>\n"
                + "<body style=\"background-color: #FDF5E6\">\n"
                + "<h1 style=\"text-align: center;\">"
                + title
                + "</h1>\n"
                + "<ul>\n"
                + "  <li><b>param1</b>: "
                + request.getParameter("param1")
                + "</li>\n"
                + "  <li><b>param2</b>: "
                + request.getParameter("param2")
                + "</li>\n"
                + "  <li><b>param3</b>: "
                + request.getParameter("param3")
                + "</li>\n"
                + "</ul>\n"
                + "</body></html>");
  }
}
