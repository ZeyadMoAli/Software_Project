package com.fawrydemo.Fawry.Controllers;
import com.fawrydemo.Fawry.Database.*;
import com.fawrydemo.Fawry.Service.Iservice;
import com.fawrydemo.Fawry.Transactions.AddtoWalltedTransaction;
import com.fawrydemo.Fawry.Transactions.PaymentTransaction;
import com.fawrydemo.Fawry.User.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class MainController {
    static CustomerDataManager customerDataManager =new CustomerDataManager();
    static ServiceDataManger serviceDataManger =new ServiceDataManger();
    static TransactionDataManager transactionDataManager=new TransactionDataManager();
    CustomerController customerController =new CustomerController();
    AdminController adminController =new AdminController();
    @GetMapping(value = "/Admin/ListPaymentTransactions")
    public ArrayList<PaymentTransaction> ListPaymentTransactions()
    {
        return adminController.ListPaymentTransactions(transactionDataManager);
    }
    @GetMapping(value = "/Admin/ListRefundTransactions")
    public ArrayList<PaymentTransaction> ListRefundTransactions()
    {
        return adminController.ListRefundTransactions(transactionDataManager);
    }

    @GetMapping(value = "/Admin/ListAddtoWalletTransactions")
    public ArrayList<AddtoWalltedTransaction> ListAddtoWalletTransactions()
    {
        return adminController.ListAddtoWalletTransactions(transactionDataManager);
    }
//    @PostMapping(value = "/Admin/MakeDiscount/{discount}/{choice}/{discount}")
//    public ResponseEntity<Void> MakeDiscount(@PathVariable ("discount") double discountAmount ,@PathVariable ("choice") int choice )
//    {
//        adminController.MakeDiscount(discountAmount,customerDataManager,choice);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
    @PostMapping(value = "Customer/SignUp")
    public ResponseEntity<Void> SignUp(@RequestBody Customer customer) {
        if(customerController.SignUp(customer,customerDataManager) == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "Customer/Signin")
    public Customer SignIn(@RequestBody Customer customer) {
        return customerController.SignIn(customer,customerDataManager);
    }


    @GetMapping(value = "/Customer/SearchService/{service}")
    public ResponseEntity<Void> SearchService(@RequestBody Customer customer, @PathVariable ("service") String serviceName)
    {
        if(customerController.SearchService(customer,serviceName, serviceDataManger) == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/Customer/RefundRequest/{id}")
    public ResponseEntity<Void> RefundRequest(@RequestBody Customer customer , @PathVariable("id") int id) {
        if(customerController.RefundRequest(customer,id,transactionDataManager))
        {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/Customer/AddToWallet/{amount}")
    public ResponseEntity<Void> AddToWallet(@RequestBody Customer customer,  @PathVariable("amount") double balance)
    {
        if(customerController.AddToWallet(customer,balance,transactionDataManager))
        {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @GetMapping(value = "/Customer/checkServiceDiscount/{choice}")
    public double checkServiceDiscount(@RequestBody Customer customer ,@PathVariable("choice") int choice)
    {
        return customerController.checkServiceDiscount(customer,choice);
    }

    @PostMapping(value = "/Customer/makeService/{serviceChoice} /{serviceProviderChoice}/ {paymentChoice}/{amount}")
    public PaymentTransaction makeService(@RequestBody Customer customer,@PathVariable("serviceChoice") int serviceChoice, @PathVariable("serviceProviderChoice") int serviceProviderChoice,@PathVariable("paymentChoice") int paymentChoice, @PathVariable("amount") double amount)
    {
        return customerController.makeService(customer,serviceChoice,serviceProviderChoice,paymentChoice,amount,transactionDataManager);
    }

    @PostMapping(value = "/Admin/HandleRefund/{id}/{state}")
    public  void HandleRefund(@PathVariable("id") int id,@PathVariable("state") boolean state)
    {
        adminController.HandleRefund(id, state,transactionDataManager);
    }

}
