package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.creatSellerDao();

        System.out.println("=== TEST 1: Seller  findById===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller  findByDepartament===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("\n=== TEST 3: Seller  findByDepartament===");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("\n=== TEST 4: Seller Insert===");
        Seller newSeller = new Seller(null, "Grege", "grege@gmail.com",new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());
    }
}
