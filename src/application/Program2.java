package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("========= Insert Department ========");
		System.out.print("Informe o nome do departmento: ");
		String nome = sc.next();
		Department dp = new Department(null, nome); 
		departmentDao.insert(dp);
		System.out.println("Novo departamento cadastrado com sucesso. Novo ID = " + dp.getId());
		System.out.print("=======================================");

       sc.close();
	}

}
