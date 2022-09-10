package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department dp;
		
		int op;
		System.out.println("========= Escolha a opcao ============= \n"
				+ " 1 - Cadastrar \n"
				+ " 2 - Cosnultar por ID: \n"
				+ " 3 - consultar todos: \n"
				+ " 4 - atualizar Departamento \n"
				+ " 5 - deletar Departamento: \n");
		op = sc.nextInt();
		switch(op) {
		case 1:{
			System.out.println("escolheu a opcao 1");
			System.out.println("========= Insert Department ========");
			System.out.print("Informe o nome do departmento: ");
			String nome = sc.next();
			dp = new Department(null, nome); 
			departmentDao.insert(dp);
			System.out.println("Novo departamento cadastrado com sucesso. Novo ID = " + dp.getId());

			break;
		}
		case 2:{
			System.out.println("escolheu a opcao 2:");
			System.out.print("Didgite o id do departamento: ");
			int id = sc.nextInt();
			dp = departmentDao.findById(id);
			System.out.println(dp);
			
			break;
		}
		case 3:{
			System.out.println("escolheu 3:");
			break;
		}
		case 4:{
			System.out.println("escolheu opcao 4:");
			System.out.print("Didgite o id do departamento: ");
			int id = sc.nextInt();
			dp = departmentDao.findById(id);
			System.out.print("Informe o nome do departmento: ");
			String nome = sc.next();
			dp.setName(nome);
			departmentDao.update(dp);
			
			break;
		}
		case 5:{
			System.out.println("escolheu 5:");
			break;
		}
		
		}
		

       sc.close();
	}

}
