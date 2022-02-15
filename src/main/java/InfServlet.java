import soap.countryws.client.generated.CountryInfoService;
import soap.countryws.client.generated.TCountryInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;


public class InfServlet extends HttpServlet {
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
        TCountryInfo tCountryInfo =
                countryIS.getCountryInfoServiceSoap().fullCountryInfo(request.getParameter("countryCode"));

        response.setContentType("text/html; charset=UTF-8");
        ResultSet resultSet = null;
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Country</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>" + "Info of " + tCountryInfo.getSName() + ": </h1>");
        out.println("<table cellpadding=\"4\">");

        out.print("<tr><td>" + "The name of the country: " + "</td>");
        out.print("<td>" + tCountryInfo.getSName() + "</td></tr>");
        out.print("<tr><td>" + "Capital name: " + "</td>");
        out.print("<td>" + tCountryInfo.getSCapitalCity() + "</td></tr>");
        out.print("<tr><td>" + "Telephone code: " + "</td>");
        out.print("<td>" + tCountryInfo.getSPhoneCode() + "</td></tr>");
        out.print("<tr><td>" + "Continent code: " + "</td>");
        out.print("<td>" + tCountryInfo.getSContinentCode() + "</td></tr>");
        out.print("<tr><td>" + "Currency code: " + "</td>");
        out.print("<td>" + tCountryInfo.getSCurrencyISOCode() + "</td></tr>");
        out.print("<tr><td>" + "Flag: " + "</td>");
        out.print("<td>" + "<img src=\"" + tCountryInfo.getSCountryFlag() + "\" " +
                "alt=\"flag of " + tCountryInfo.getSName() + "\">" + "</td></tr>");


        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}
