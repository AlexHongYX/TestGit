package com.fehead.Timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class TimerTest {
    public static void main(String[] args){
        ActionListener listener =  new TimePrinter();

        //construct a timer that calls the listener
        //once every 10 seconds
        Timer t = new Timer(2000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"是不是越来越爱我了?");
        System.exit(0);
    }
}
