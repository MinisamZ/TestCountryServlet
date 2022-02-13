import soap.countryws.client.generated.ArrayOftContinent;
import soap.countryws.client.generated.CountryInfoService;
import soap.countryws.client.generated.CountryInfoServiceSoapType;
import soap.countryws.client.generated.TContinent;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
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

        for (TContinent continent : tContinent) {
            System.out.println("continent - " + continent.getSName());

            out.print("<tr>");
            out.print(" <td>" + continent.getSName() + "</td>");
            out.print(" <td>" + "</td>");
            out.print(" <td>" + "</td>");
            out.print("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}