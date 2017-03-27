package com.vpcodingclub.constants;



import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//import static constants.WebDriverManager.*;
public class WebDriverTest extends browser {
    protected static String globalORGtimestamp = "0";
    protected static String globalnametimestamp = "0";
    protected static String QA1CLientID = "0";
    protected static String QA1CLientTempPassword = "0";
    protected static String QA1CLientHRADMINID = "0";
    protected static String QA1CLientHRADMINTempPassword = "0";
    protected static int currentrow1 = 0;

    private static Logger log = Logger.getLogger(Test.class);





    /**
     * Method to print in logs and system
     *
     * @param printreportlog
     */
    public static void prl(String printreportlog) {

        String p = printreportlog;

        System.out.println(p);
        Reporter.log(p);
        log.info(p);
    }





}