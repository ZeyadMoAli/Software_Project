package com.fawrydemo.Fawry.Factories;
import com.fawrydemo.Fawry.ServiceProvider.*;
public interface IserviceProviderFactory {
    public IserviceProvider makeObj(int choice);
}
