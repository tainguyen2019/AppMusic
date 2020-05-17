package com.tainguyen.uit.appmusic.Service;

public class APIService {
//    private  static String base_url = "http://192.168.1.5/Server/";
//    private  static String base_url = "http://10.0.2.2/Server/";
    private  static String base_url = "http://10.0.2.2/Server/";



    public static IDataService getService(){
        return APIRetrofitClient.getClient(base_url).create(IDataService.class);
    }

}
