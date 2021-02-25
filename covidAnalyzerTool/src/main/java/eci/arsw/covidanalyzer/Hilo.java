package eci.arsw.covidanalyzer;

import sun.awt.Mutex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Hilo extends Thread{
    TestReader testReader;
    ResultAnalyzer resultAnalyzer;
    CovidAnalyzerTool covid;
    ArrayList<File> listaCovid;
    Mutex mutex;
    boolean isPause;
    public Hilo(TestReader testReader,ResultAnalyzer resultAnalyzer,CovidAnalyzerTool covid ){
        this.testReader = testReader;
        this.resultAnalyzer=resultAnalyzer;
        this.covid = covid;
        this.listaCovid = new ArrayList<File>();
        mutex = new Mutex();
        isPause=false;
    }
}