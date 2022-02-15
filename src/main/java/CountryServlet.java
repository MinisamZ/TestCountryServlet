import soap.countryws.client.generated.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;


public class CountryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateView(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateView(request, response);
    }

    public void generateView(HttpServletRequest request,
                             HttpServletResponse response)
            throws IOException {

        CountryInfoService countryIS = new CountryInfoService();
        CountryInfoServiceSoapType countryISS = countryIS.getCountryInfoServiceSoap();

        ArrayOftContinent arrayOftContinent = countryISS.listOfContinentsByName();
        List<TContinent> tContinent = arrayOftContinent.getTContinent();
        System.out.println("tut");
        response.setContentType("text/html; charset=UTF-8");
        ResultSet resultSet = null;
        PrintWriter out = response.getWriter();
        System.out.println("tut1");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add a new DVD Library</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Add DVD</h1>");
        out.println("<table cellpadding=\"4\">");
        out.println("<tr>\n" +
                "        <th>Title</th>\n" +
                "        <th>Year</th>\n" +
                "    </tr>");
        System.out.println("tut3");
        System.out.println(tContinent.toString());
        for (TContinent continent : tContinent) {
            System.out.println("tut4");
            System.out.println("continent - " + continent.getSName());
            out.print("<tr>");
            out.print(" <td>" + continent.getSName() + "</td>");
            out.print(" <td>" + "</td>");
            out.print(" <td>" + "</td>");
            out.print("</tr>");
        }
        System.out.println("tut5");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}