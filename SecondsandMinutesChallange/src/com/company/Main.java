package com.company;

public class Main {

    public static void main(String[] args) {

        getDurationString(22323, 4232323);
//        getDurationString(1000);
    }

    public static String getDurationString(int minutes, int seconds){

        if ((minutes < 0) || ((seconds < 0) && (seconds > 59))) {
            System.out.println("invalid value method 1");
            return "Invalid Value";
        }
        int transformSecondsToMinutes = seconds / 60;
        int restfromSecondsToMinutes = seconds % 60;
        int transfromMinutestoHours = minutes / 60;
        int restfromMinutestoHours = minutes % 60;
        int day = transfromMinutestoHours / 24;
        int restofDays = transfromMinutestoHours % 24;

        String daysString = day + restofDays + "d";
        if (day + restofDays < 10){
            daysString = "0" + daysString;
        }

        String hoursString = transfromMinutestoHours + "h";
        if (transfromMinutestoHours < 10){
            hoursString = "0" + hoursString;
        }

        String minutesString = restfromMinutestoHours + "m ";
        if (restfromMinutestoHours < 10){
            minutesString = "0" + minutesString;
        }

        String secondsString = restfromSecondsToMinutes + "s";
        if (restfromSecondsToMinutes < 10){
            secondsString = "0" + secondsString ;
        }



         System.out.println(daysString + " " + hoursString + " " + minutesString + " " + secondsString + " ");
        return daysString + " " + hoursString + " " + minutesString + " " + secondsString + " ";
    }

    public static String getDurationString(int seconds) {

        if (seconds < 0) {
            System.out.println("invalid value method 2");
            return "invalid value";
        }
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return getDurationString(minutes,remainingSeconds );
    }
}


