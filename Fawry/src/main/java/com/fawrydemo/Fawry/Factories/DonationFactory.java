package com.fawrydemo.Fawry.Factories;

import com.fawrydemo.Fawry.ServiceProvider.CancerHospital;
import com.fawrydemo.Fawry.ServiceProvider.IserviceProvider;
import com.fawrydemo.Fawry.ServiceProvider.NGOS;
import com.fawrydemo.Fawry.ServiceProvider.Schools;

public class DonationFactory {
    public IserviceProvider makeObj(int choice) {
        if (choice == 1) {
            Schools schools = new Schools();
            return schools;
        } else if (choice == 2) {
            NGOS ngos = new NGOS();
            return ngos;
        } else if (choice == 3) {
            CancerHospital cancerHospital = new CancerHospital();
            return cancerHospital;
        }
        return null;
    }
}



