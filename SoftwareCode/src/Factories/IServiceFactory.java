package Factories;

import Service.*;

public interface IServiceFactory {
    public Iservice makeObj(int choice);
}
