package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Department obj = new Department(1, "Books");
		Seller sel = new Seller(1,"Edir Herison", "edir.ti@minhaempresa.com.br",
				new Date(),3500.0, obj);
		
	
		System.out.print(sel);

	}

}
