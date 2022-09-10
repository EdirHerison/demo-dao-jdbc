package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
	    SellerDao sellerDao = DaoFactory.createSellerDao();
	    
	    System.out.println("===== Teste 1: findById Seller =====");
	    Seller seller = sellerDao.findById(3);
	    System.out.println(seller);
	    System.out.print("==============================");
	    System.out.println();
		
	    System.out.println("===== Teste 2: findById Department =====");
	    Department department = new Department(1, null);
	    List<Seller> list = sellerDao.findByDepartment(department);
	    for (Seller obj : list) {
	    	System.out.println(obj);
	    }
	    System.out.print("==============================");
	    System.out.println();

	    System.out.println("===== Teste 3: findALl =====");
	    list = sellerDao.findAll();
	    for (Seller obj : list) {
	    	System.out.println(obj);
	    }
	    System.out.print("==============================");
	    System.out.println();
	    
	    System.out.println("===== Teste 4: Insert Seller =====");
	    Seller newSeller = new Seller(null, "Ludmila Beatriz", "ludmila.com@ehsoft.com", new Date(), 4000.0, department);
	    sellerDao.insert(newSeller);
	    System.out.println("Inserido! Nova ID = " + newSeller.getId());
	    System.out.print("==============================");
	    System.out.println();
	    
	    System.out.println("===== Teste 5: Update Seller =====");
	    seller = sellerDao.findById(9);
	    seller.setName("Mailon Adriano");
	    sellerDao.update(seller);
	    System.out.println("Cadastro Atualizado");
	    System.out.print("==============================");
	    System.out.println();
	    
	    System.out.println("===== Teste 6: Delete Seller =====");
	    System.out.println("Infrome o ID do vendedor a ser deletado: ");
	    int id = sc.nextInt();
	    sellerDao.deleteById(id);
	    System.out.println("Deletado");
	    System.out.print("==============================");
	    System.out.println();

	    
	    sc.close();
	}
   
}
