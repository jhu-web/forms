package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that reads a code snippet from the request and displays it inside a PRE tag.
 * Fails to filter the special HTML characters.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the coreservlets.com
 * tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */
@WebServlet("/code-preview-bad")
public class CodePreviewBad
  extends HttpServlet {

  private static final long serialVersionUID = -971029065205341649L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Code Sample";
    String docType = "<!doctype html>\n";
    out.println(docType + "<html>\n"
                + "<head><title>"
                + title
                + "</title></head>\n"
                + "<body style=\"background-color: #FDF5E6\">\n"
                + "<h1 style=\"text-align: center;\">"
                + title
                + "</h1>\n"
                + "<pre>\n"
                + getCode(request)
                + "</pre>\n"
                + "Now, wasn't that an interesting sample\n"
                + "of code?\n"
                + "</body></html>");
  }

  protected String getCode(HttpServletRequest request) {
    return (request.getParameter("code"));
  }
}
