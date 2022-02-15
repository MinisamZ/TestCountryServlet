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
        CountryInfoService countryInfoService = new CountryInfoService();
        TCountryInfo tCountryInfo = countryInfoService.getCountryInfoServiceSoap().fullCountryInfo("DZ");

        System.out.println(tCountryInfo.getLanguages().getTLanguage().toString());
//        ArrayOftLanguage<TLanguage> tLanguage = tCountryInfo.getLanguages().getTLanguage();

        System.out.println(tCountryInfo.getSISOCode());
        System.out.println(tCountryInfo.getSName());
        System.out.println(tCountryInfo.getSCapitalCity());
        System.out.println(tCountryInfo.getSPhoneCode());
        System.out.println(tCountryInfo.getSContinentCode());
        System.out.println(tCountryInfo.getSCurrencyISOCode());
        System.out.println(tCountryInfo.getSCountryFlag());

        TCurrency tCurrency = new TCurrency();
        System.out.println(tCurrency.getSISOCode());
        tCurrency.setSISOCode(tCountryInfo.getSISOCode());
        System.out.println("jjjj " + tCurrency.getSName());


        System.out.println(tCountryInfo.getLanguages());
        ArrayOftLanguage arrayOftLanguage = new ArrayOftLanguage();
        arrayOftLanguage = tCountryInfo.getLanguages();
        List<TLanguage> tLanguages = tCountryInfo.getLanguages().getTLanguage();
        System.out.println(tLanguages);


//        System.out.println(countryInfoService.getCountryInfoServiceSoap().fullCountryInfo("DZ").getLanguages());


//        ArrayOftContinent arrayOftContinent = countryISS.listOfContinentsByName();
//        List<TContinent> tContinent = arrayOftContinent.getTContinent();
        for (TLanguage tl : tLanguages) {
            System.out.println("tLanguages - " + tl.getSName());
            System.out.println("tLanguages - " + tl.getSISOCode());
        }
    }
}

//C:/Program Files/Java/jdk1.8.0_301/bin/wsimport -s src -keep -p kz.iitu.soap.countryws.client.generated http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL
// C:\Program Files\Java\jdk1.8.0_301\bin\wsimport -s src -keep -p kz.iitu.soap.ws.client.generated http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL
