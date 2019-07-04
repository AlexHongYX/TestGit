package com.fehead.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

public class TimePrinter implements ActionListener{
    public void actionPerformed(ActionEvent event){
        System.out.println("I love you in " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
