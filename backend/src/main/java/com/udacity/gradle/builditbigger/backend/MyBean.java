package com.udacity.gradle.builditbigger.backend;



/** The object model for the data we are sending through endpoints */
//public class MyBean {
//
//    private JokeTelling myData;
//
//   public MyBean(){
//    myData= new JokeTelling();
//    }
//    public String getData() {
//        return myData.getRandomJoke();
//    }
//
//
//}

public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    void setData(String data) {
        myData = data;
    }
}