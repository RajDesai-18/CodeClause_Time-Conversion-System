package com.time.timeconversion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class HelloController implements Initializable {
   @FXML
    ComboBox<String> countries;
   ObservableList<String>listOfCountries = FXCollections.observableArrayList("India", "Japan", "America", "Australia", "China", "United Kingdom", "France", "Spain");

   @FXML
    Label time_initialize = new Label();
   @FXML
    Label time_result = new Label();

   private static final String DateFormat = "dd-mm-yyyy hh:mm:ss a";
   SimpleDateFormat formater = new SimpleDateFormat(DateFormat);
   Date d1 = new Date();
   String date1 = formater.format(d1)+"";
   Date date2;
   TimeZone time = TimeZone.getDefault();

   @Override
    public void initialize(URL arg0, ResourceBundle arg1){
       countries.setItems(listOfCountries);
       try {
           date2 = formater.parse(date1);
       } catch (ParseException e){
           e.printStackTrace();
       }
       time_initialize.setText(formater.format(d1));
   }
   public void displayTime(){
       String selectTz = countries.getValue();
       String tz = selectTimezone(selectTz);
       SimpleDateFormat sdfJapan = new SimpleDateFormat(DateFormat);
       TimeZone japanTimeZone = TimeZone.getTimeZone(tz);
       sdfJapan.setTimeZone(japanTimeZone);
       String sDateInJapan = sdfJapan.format(date2);
       Date dateInJapan = null;
       try{
           dateInJapan = formater.parse(sDateInJapan);
       } catch (ParseException e){
           e.printStackTrace();
       }
       time_result.setText(formater.format(dateInJapan)+"");
   }

   private String selectTimezone(String timeZone){
       switch (timeZone){
           case "India":
               return "Asia/Kolkata";
           case "Japan":
               return "Asia/Tokyo";
           case "America":
               return "America/New_York";
           case "Australia":
               return "Europe/Vienna";
           case "China":
               return "Asia/Shanghai";
           case "United Kingdom":
               return "Europe/London";
           case "France":
               return "Europe/Paris";
           case "Spain":
               return "Europe/Madrid";
           default:
               break;
       }
    return "Asia/Kolkata";
   }
}