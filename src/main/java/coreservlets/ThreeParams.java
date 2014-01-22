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
 * filter out HTML tags.
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
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
    out.println(docType + "<HTML>\n"
                + "<HEAD><TITLE>"
                + title
                + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<H1 ALIGN=\"CENTER\">"
                + title
                + "</H1>\n"
                + "<UL>\n"
                + "  <LI><B>param1</B>: "
                + request.getParameter("param1")
                + "\n"
                + "  <LI><B>param2</B>: "
                + request.getParameter("param2")
                + "\n"
                + "  <LI><B>param3</B>: "
                + request.getParameter("param3")
                + "\n"
                + "</UL>\n"
                + "</BODY></HTML>");
  }
}
