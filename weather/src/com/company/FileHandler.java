package com.company;


import java.io.*;
import java.time.LocalDate;

public class FileHandler {


    public void writeFile(String city, String JsonString){
        FileWriter fw = null;
        try {
            fw = new FileWriter(city+".txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        LocalDate nowDate = LocalDate.now();
        pw.print("@@@@@@@@@@\n");
        pw.print(nowDate.getDayOfMonth()+"."+nowDate.getMonth().getValue()+"."+nowDate.getYear()+"\n");
        pw.print(JsonString+"\n");
        pw.close();
    }

    public String readFile(String  city){
        String ans = "";
        FileReader fr = null;
        try {
            fr = new FileReader(city+".txt");
        } catch (FileNotFoundException e) {
            System.out.println("\nFile not found\n");
            createFile(city);
            try {
                fr = new FileReader(city+".txt");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(line != null){
            if(line != null) ans += line;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public void createFile(String city){
        FileWriter fw = null;
        try {
            fw = new FileWriter(city+".txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.close();
    }

    public int getNumberOfJsons(String city){
        String s = readFile(city);
        int counter = s.length() - s.replaceAll("@@@@@@@@@@", "").length();
        return counter/10;

    }

//    public static void main(String[] args) {
//        FileHandler rf = new FileHandler();
//        int i=0;
//        while(i<4) {
//            if(rf.getNumberOfJsons("Beer-Sheba")<3) {
//                rf.writeFile("Beer-Sheba", "string to json o10c2ij03inc023-xkq[xko130c13n20v9cj-1k3k]{:};fffsf[;.d[");
////                rf.writeFile("Beer-Sheba", "appended string?? success????");
//            }
//            i++;
//        }
////        System.out.println(rf.readFile("Beer-Sheba"));
//        System.out.println("\nNumber of JSONs:\n"+rf.getNumberOfJsons("Beer-Sheba"));
//    }
}
