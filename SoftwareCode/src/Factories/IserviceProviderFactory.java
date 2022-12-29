package Factories;
import ServiceProvider.*;
public interface IserviceProviderFactory {
    public IserviceProvider makeObj(int choice);
}
