import soap.countryws.client.generated.CountryFlag;
import soap.countryws.client.generated.CountryFlagResponse;
import soap.countryws.client.generated.CountryInfoService;
import soap.countryws.client.generated.CountryInfoServiceSoapType;

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
        CountryInfoServiceSoapType countryISS = countryIS.getCountryInfoServiceSoap();
        CountryFlag countryFlag = new CountryFlag();
        countryFlag.setSCountryISOCode(request.getParameter("countryCode"));
        CountryFlagResponse countryFlagResponse = new CountryFlagResponse();
        countryFlagResponse.setCountryFlagResult(countryFlag.getSCountryISOCode());
        System.out.println(countryFlagResponse.getCountryFlagResult());

        response.setContentType("text/html; charset=UTF-8");
        ResultSet resultSet = null;
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Country</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>" + "Flag of " + request.getParameter("countryName") + " - " +
                countryFlagResponse.getCountryFlagResult() + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
