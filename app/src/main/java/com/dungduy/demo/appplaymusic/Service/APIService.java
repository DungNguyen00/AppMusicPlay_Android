package com.dungduy.demo.appplaymusic.Service;

public class APIService {
    private static String base_url = "https://appmusicplay.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
