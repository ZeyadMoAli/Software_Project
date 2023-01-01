package com.fawrydemo.Fawry.Factories;

import com.fawrydemo.Fawry.Receipts.Ireceipt;
import com.fawrydemo.Fawry.Receipts.MonthlyReceipt;
import com.fawrydemo.Fawry.Receipts.QuarterReceipt;

public class LandLineReceiptFactory {

    public Ireceipt makeObj(int choice)
    {
        if(choice==1)
        {
            MonthlyReceipt monthlyReceipt = new MonthlyReceipt();
             return monthlyReceipt;
        }else if(choice==2)
        {
             QuarterReceipt quarterReceipt =new QuarterReceipt();
            return quarterReceipt;
        }
        return null;

    }
}
