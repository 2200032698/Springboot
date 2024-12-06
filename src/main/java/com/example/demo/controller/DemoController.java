package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private CustomerRepository customerRepository;

    // Maps to /demo1, returns an integer
    @RequestMapping("/demo1")
    public int demo1() {
        return 100;
    }

    // Maps to /demo2, returns a double value
    @RequestMapping("/demo2")
    public double demo2() {
        return 3.14;
    }

    // Maps to /demo3, returns a formatted HTML string
    @GetMapping("/demo3")
    public String demo3() {
        return "<html><body><h1>Welcome to Demo 3</h1></body></html>";
    }

    // Maps to /demo4, initializes and returns a concatenated string
    @GetMapping("/demo4")
    public String demo4() {
        String university = "KLEF";
        return "I Study at " + university;
    }

    // Maps to /demo5/{id}, accepts a path variable and returns it
    @GetMapping("/demo5/{id}")
    public String demo5(@PathVariable("id") int id) {
        return "ID: " + id;
    }

    // Maps to /demo6/{a}/{b}, accepts two path variables and returns their sum
    @GetMapping("/demo6/{a}/{b}")
    public String demo6(@PathVariable("a") int a, @PathVariable("b") int b) {
        return "Sum: " + (a + b);
    }

    // Maps to /demo7, accepts a request parameter and returns it
    @GetMapping("/demo7")
    public String demo7(@RequestParam("id") String id) {
        return "ID: " + id;
    }

    // Maps to /demo8/{name}, accepts a path variable and returns it
    @GetMapping("/demo8/{name}")
    public String demo8(@PathVariable("name") String name) {
        return "Name: " + name;
    }

    // Maps to /addcustomer, accepts a Customer object and adds it to the database
    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Customer Added Successfully";
    }

    // Maps to /viewcustomer, retrieves and returns the list of customers
    @GetMapping("/viewcustomer")
    public List<Customer> viewCustomers() {
        return customerRepository.findAll();
    }
}
