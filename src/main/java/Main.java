import soap.countryws.client.generated.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.err.println("hello");
        System.out.println();
        CountryInfoService countryIS = new CountryInfoService();
        CountryInfoServiceSoapType countryISS = countryIS.getCountryInfoServiceSoap();

        ArrayOftCountryCodeAndName arrayOftCountryCodeAndName = countryISS.listOfCountryNamesByName();
        List<TCountryCodeAndName> tCountryCodeAndNames = arrayOftCountryCodeAndName.getTCountryCodeAndName();
        CountryFlag countryFlag = new CountryFlag();
        countryFlag.setSCountryISOCode("DZ");
        CountryFlagResponse countryFlagResponse = new CountryFlagResponse();
        countryFlagResponse.setCountryFlagResult(countryFlag.getSCountryISOCode());
        System.out.println(countryFlagResponse.getCountryFlagResult());
        System.out.println(tCountryCodeAndNames.get(1).getSISOCode());


//        ArrayOftContinent arrayOftContinent = countryISS.listOfContinentsByName();
//        List<TContinent> tContinent = arrayOftContinent.getTContinent();
//        for (TContinent continent : tContinent) {
//            System.out.println("continent - " + continent.getSName());
//        }
    }
}

//C:/Program Files/Java/jdk1.8.0_301/bin/wsimport -s src -keep -p kz.iitu.soap.countryws.client.generated http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL
// C:\Program Files\Java\jdk1.8.0_301\bin\wsimport -s src -keep -p kz.iitu.soap.ws.client.generated http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL
