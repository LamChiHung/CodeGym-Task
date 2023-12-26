package test;

import dao.CustomerDAO;
import model.entity.Customer;

public class Test {
    public static void main(String[] args) {
        Customer customer1 = new Customer(11, "Lam Vinh Giai", 27);
        Customer customer2 = new Customer(12, "Phan Kim", 24);

        CustomerDAO.getCustomerDAO().Insert(customer2);
//        CustomerDAO.getCustomerDAO().Update(customer1);
        CustomerDAO.getCustomerDAO().Delete(customer2);
//        ArrayList <Customer> list = CustomerDAO.getCustomerDAO().SelectAll();
//        for (Customer customer : list) {
//            System.out.println(customer);
//        }

//        CustomerDAO.getCustomerDAO().SelectByID(customer1);
//        CustomerDAO.getCustomerDAO().SelectByCondition("age > 22");

    }
}
