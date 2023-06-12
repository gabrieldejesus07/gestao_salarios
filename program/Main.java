package program;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Funcionario> salario = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" +(i+1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            salario.add(new Funcionario(id, name, salary) );
            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the percentage: ");
        double porcentagem = sc.nextDouble();
        Integer pos = position(salario, id);
        if(pos == null){
            System.out.println("Id não existe!");
        }
        else{
            salario.get(pos).aumentaSalario(porcentagem);
        }
            System.out.println();

            sc.close();

        System.out.println("List of employees: ");
        for (Funcionario funcionario: salario){
            System.out.println(funcionario);
        }
    }

        public static Integer position(List<Funcionario> list, int id){
            for(int i = 0; i< list.size(); i++){
                if(list.get(i).getId() == id){
                    return i;
                }
            }
            return null;
        }
}