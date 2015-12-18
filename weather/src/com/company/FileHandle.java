package com.company;

import java.io.*;
import java.time.LocalDate;


public class FileHandle {


    public void writeFile(String city, String JsonString) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(city + ".txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        LocalDate nowDate = LocalDate.now();
        String currFile = readFile(city);
        currFile = updateFile(currFile);
        LocalDate[] filesDates = getDatesFromFile(currFile);
        LocalDate now = LocalDate.now();
        String toFile = currFile;
        toFile = addNewLineDel(toFile);
        try {//erase text from existing file
            fw = new FileWriter(city + ".txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!isDateInArr(now, filesDates)) {
            pw.print("@@@@@@@@@@\n");
            pw.print(nowDate.getDayOfMonth() + "." + nowDate.getMonth().getValue() + "." + nowDate.getYear() + "\n");
            pw.print(JsonString /*+ "\n"*/);
        }
        pw.print(toFile);
        pw.close();
    }

    private String addNewLineDel(String toFile) {
        String ans = "";
        for (int startDel = toFile.indexOf("@@@@@@@@@@")
             ; startDel != (-1);
                ) {
            if (startDel != 1) {
                toFile = toFile.substring(startDel);
                startDel = 0;
                int enDel = startDel + 10;
                int enDate = enDel + 10;
                String s0 = toFile.substring(0, startDel);
                String s1 = toFile.substring(startDel, enDel);
                String s2 = toFile.substring(enDel, enDate);
                int startNextDel = toFile.indexOf("@@@@@@@@@@", startDel + 1);
                if (startNextDel != (-1)) {
                    String s3 = toFile.substring(enDate, startNextDel);
                    ans += s0 + "\n" + s1 + "\n" + s2 + "\n" + s3;
                } else {
                    String s3 = toFile.substring(enDate);
                    ans += s0 + "\n" + s1 + "\n" + s2 + "\n" + s3;
                }
                startDel = startNextDel;
            }
        }
        return ans;
    }

    private String updateFile(String file) {
        String ans = file;
        int num = getNumberOfJsons(file);
        int i = 0;
        int toSubStringIndx = 0;
        while (num > 0) {
            i = file.indexOf("@@@@@@@@@@");
            toSubStringIndx += i + 10;
            if (i != (-1)) {
                String date = file.substring(10 + i, 20 + i);
                int year = Integer.valueOf(date.substring(6));
                int month = Integer.valueOf(date.substring(3, 5));
                int day = Integer.valueOf(date.substring(0, 2));
                LocalDate localDateFromFile = LocalDate.parse(year + "-" + month + "-" + day);
                LocalDate limitDateFromFile = LocalDate.now().minusDays(3);
                if (localDateFromFile.isBefore(limitDateFromFile)) {
                    break;
                }
                file = file.substring(i + 10);
            }
            num--;
        }
        toSubStringIndx -= 10;
        if (toSubStringIndx > 10) {
            ans = ans.substring(0, toSubStringIndx);
        }
        return ans;
    }

    public String readFile(String city) {
        String ans = "";
        FileReader fr = null;
        try {
            fr = new FileReader(city + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("\nFile not does not exist.. \nCreating new file to record history!\n");
            createFile(city);
            try {
                fr = new FileReader(city + ".txt");
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
        while (line != null) {
            if (line != null) ans += line;
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

    public void createFile(String city) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(city + ".txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.close();
    }

    public int getNumberOfJsons(String s) {
        int counter = s.length() - s.replaceAll("@@@@@@@@@@", "").length();
        return counter / 10;
    }

    public boolean isDateInArr(LocalDate date, LocalDate[] dates) {
        for (int i = 0; i < 3; i++) {
            if (dates[i] == date) return true;
        }
        return false;
    }

    public LocalDate[] getDatesFromFile(String fileString) {
        LocalDate[] ans = new LocalDate[3];
        String allFile = fileString;
        int jsons = getNumberOfJsons(allFile);
        while (jsons > 0) {
            int date = allFile.indexOf("@@@@@@@@@@");
            String dateStr = allFile.substring(10 + date, 20 + date);
            int year = Integer.valueOf(dateStr.substring(6));
            int month = Integer.valueOf(dateStr.substring(3, 5));
            int day = Integer.valueOf(dateStr.substring(0, 2));
            LocalDate ld = LocalDate.parse(year + "-" + month + "-" + day);
            ans = fillDates(ans, ld);
            jsons--;
        }
        return ans;
    }

    private LocalDate[] fillDates(LocalDate[] ans, LocalDate parse) {
        if ((compareTwoCells(ans[0], parse) > 0) || ans[0] == null) {
            sortDates(ans);
            ans[0] = parse;
        } else {
            if (compareTwoCells(ans[1], parse) > 0) {
                sortDates(ans);
                ans[1] = parse;
            } else {
                if (compareTwoCells(ans[2], parse) > 0) {
                    sortDates(ans);
                    ans[0] = parse;
                }
            }
        }
        return ans;
    }

    private void sortDates(LocalDate[] ans) {
        if (compareTwoCells(ans[1], ans[2]) > 0) {
            ans[2] = ans[1];
            ans[1] = ans[0];
            ans[0] = null;
        }
    }

    public int compareTwoCells(LocalDate early, LocalDate late) {
        if (early == null || late == null) return 1;
        if (early.getYear() > late.getYear()) {
            return 1;
        } else {
            if (early.getMonthValue() > late.getMonthValue()) {
                return 1;
            } else {
                if (early.getDayOfMonth() > late.getDayOfMonth()) {
                    return 1;
                }
            }
        }
        return 0;
    }
}