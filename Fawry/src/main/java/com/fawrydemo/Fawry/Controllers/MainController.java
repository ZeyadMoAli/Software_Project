package com.fawrydemo.Fawry.Controllers;
import com.fawrydemo.Fawry.Database.*;
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
    @PostMapping(value = "/Admin/MakeDiscount/{discount}/{choice}")
    public ResponseEntity<Void> MakeDiscount(@PathVariable ("discount") double discountAmount ,@PathVariable ("choice") int choice )
    {
        adminController.MakeDiscount(discountAmount,customerDataManager,choice);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "Customer/SignUp")
    public ResponseEntity<Void> SignUp(@RequestBody Customer customer) {
        if(customerController.SignUp(customer,customerDataManager) == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "Customer/Signin")
    public Customer SignIn(@RequestBody Customer customer) {
        return customerController.SignIn(customer,customerDataManager);
    }















    }
