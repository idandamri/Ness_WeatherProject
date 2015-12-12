package com.company;

public class ThreadCityUpdate extends Thread {

    private Thread t;
    private String threadName;

    ThreadCityUpdate( String name){
        threadName = name;
    }

    public void run() {
//        System.out.println("Running " +  threadName );
        try {
            jsonToArray();
            updateCitiesFromUrl();
            // Let the thread sleep for a while.
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
//        System.out.println("Thread " +  threadName + " exiting.");
    }

    private void jsonToArray(){
        try {
            Menu.citesJson[0] = TParse.readJsonFromUrl(CitiesEName.BEERSHEBA);
            Menu.citesJson[1] = TParse.readJsonFromUrl(CitiesEName.HAIFA);
            Menu.citesJson[2] = TParse.readJsonFromUrl(CitiesEName.TELAVIV);
            Menu.citesJson[3] = TParse.readJsonFromUrl(CitiesEName.NEWYORK);
            Menu.citesJson[4] = TParse.readJsonFromUrl(CitiesEName.MADRID);
            Menu.citesJson[5] = TParse.readJsonFromUrl(CitiesEName.BARCELONA);
            Menu.citesJson[6] = TParse.readJsonFromUrl(CitiesEName.ROME);
            Menu.citesJson[7] = TParse.readJsonFromUrl(CitiesEName.PARIS);
            Menu.citesJson[8] = TParse.readJsonFromUrl(CitiesEName.LONDON);
            Menu.citesJson[9] = TParse.readJsonFromUrl(CitiesEName.ISTANBUL);
        }
        catch (Exception e) {
            System.out.println("city json failed\n\n" + e);
        }
    }

    private void updateCitiesFromUrl() {
        try {
            for (int i=0; i<10; i++) {
                Menu.citiesJsonToString[i] = Menu.citesJson[i].toJSONString();
            }
        }
        catch (Exception e){
            System.out.println("city json failed\n\n"+e);
        }
    }

    public void start ()
    {
//        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            jsonToArray();
            updateCitiesFromUrl();
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
