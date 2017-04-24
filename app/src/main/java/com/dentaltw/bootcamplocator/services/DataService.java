package com.dentaltw.bootcamplocator.services;

import com.dentaltw.bootcamplocator.models.Develops;

import java.util.ArrayList;

/**
 * Created by Scott on 2017/4/24.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {

    }
    public ArrayList<Develops> getData(int zipcode){
        ArrayList<Develops> list = new ArrayList<Develops>();
        list.add(new Develops(24.998240f, 121.573145f,"木柵捷運","356苗栗縣後龍鎮","slo"));
        return list;
    }
}