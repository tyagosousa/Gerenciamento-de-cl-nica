package projeto;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		Scanner text = new Scanner(System.in);
		Scanner number = new Scanner(System.in);
		
		int opcao, opcao2, aux = 0, opcao3, index = 0;
		String cpf;
		
		System.out.println("#################### Bem vindo a Policlinia de Patos! ####################");
		do {
			menu();
			opcao = number.nextInt();
			
			switch(opcao) {
			case 1:
				p = new Paciente();
				System.out.print("Informe o nome completo:..... ");
				p.setNome(text.nextLine());
				System.out.print("Informe o CPF:..... ");
				p.setCpf(text.nextLine());
				System.out.print("Informe a data de nascimento:..... ");
				p.setNascimento(text.nextLine());
				do {
					System.out.println("Informe a especialidade:..... ");
					especialidade();
					opcao2 = number.nextInt();
					
					if(opcao2 == 1) {
						reumatologista.add(p);
						pacientes.add(p);
						System.out.println("Paciente adicionado com sucesso!");
					}else if(opcao2 == 2) {
						dermatologista.add(p);
						pacientes.add(p);
						System.out.println("Paciente adicionado com sucesso!");
					}else if(opcao2 == 3) {
						pneumologista.add(p);
						pacientes.add(p);
						System.out.println("Paciente adicionado com sucesso!");
					}else if(opcao2 == 4) {
						proctologista.add(p);
						pacientes.add(p);
						System.out.println("Paciente adicionado com sucesso!");
					}else {
						System.out.println("Opção inválida");
					}
					
				}while(opcao2 <= 0 || opcao2 > 4);
				break;
				
			case 2:
				if(proctologista.size()==0 && reumatologista.size()==0 && dermatologista.size()==0 && pneumologista.size()==0) {
					System.out.println("Não há pacientes aqui!");
				}else {
				System.out.print("Informe o cpf do paciente (sem espaço e sem símbolos):..... ");
				cpf = text.nextLine();
				for(int i = 0; i<pacientes.size(); i++) {
					if(pacientes.get(i).getCpf().equalsIgnoreCase(cpf)) {
						pacientes.remove(i);
						aux++;
					}
				}
				for(int i = 0; i<reumatologista.size(); i++) {
					if(reumatologista.get(i).getCpf().equalsIgnoreCase(cpf)) {
						reumatologista.remove(i);
						aux++;
					}
				}
				for(int i = 0; i<dermatologista.size(); i++) {
					if(dermatologista.get(i).getCpf().equalsIgnoreCase(cpf)) {
						dermatologista.remove(i);
						aux++;
					}
				}
				for(int i = 0; i<pneumologista.size(); i++) {
					if(pneumologista.get(i).getCpf().equalsIgnoreCase(cpf)) {
						pneumologista.remove(i);
						aux++;
					}
				}
				for(int i = 0; i<proctologista.size(); i++) {
					if(proctologista.get(i).getCpf().equalsIgnoreCase(cpf)) {
						proctologista.remove(i);
						aux++;
					}
				}
				if(aux > 0) {
					System.out.println("O cliente foi excluído");
				}else {
					System.out.println("O cliente não foi encontrado!");
					}
				}
				break;
				
			case 3:
				exibir();
				break;
				
			case 4:
				if(pacientes.size()>0) {
				System.out.println("Pacientes cadastrados");
				for(int i = 0; i<pacientes.size();i++) {
					System.out.println("Nome: " + pacientes.get(i).getNome());
					System.out.println("CPF: " + pacientes.get(i).getCpf());
					System.out.println("Nascimento: " + pacientes.get(i).getNascimento());
					System.out.println("__________________________________________________");
				}
				}else {
					System.out.println("Não há pacientes aqui");
				}
				break;
				
			case 5:
				do {
					System.out.println("Informe uma especialidade que deseja atender:..... ");
					especialidade();
					opcao3 = number.nextInt();
					
					if(opcao3 == 1 && reumatologista.size()>0) {
						System.out.println(reumatologista.get(0).getNome() + " foi atendido na fila do REUMATOLOGISTA");
						reumatologista.remove(0);
					}else if(opcao3 == 2 && dermatologista.size()>0) {
						System.out.println(dermatologista.get(0).getNome() + " foi atendido na fila do DERMATOLOGISTA" );
						dermatologista.remove(0);
					}else if(opcao3 == 3 && pneumologista.size()>0) {
						System.out.println(pneumologista.get(0).getNome() + " foi atendido na fila do PNEUMOLOGISTA");
						pneumologista.remove(0);
					}else if(opcao3 == 4 && proctologista.size()>0) {
						System.out.println(proctologista.get(0).getNome() + " foi atendido na fila do PROCTOLOGISTA");
						proctologista.remove(0);
					}else if(reumatologista.size()==0 && dermatologista.size()==0 && pneumologista.size()==0 && proctologista.size()==0){
						System.out.println("Não há niguém aqui");
					}else {
						System.out.println("Opção inválida");
					}
					
				}while(opcao3 <= 0 || opcao3 > 4);
				break;
			}
			
		}while(opcao != 0);
		
		System.out.println("O programa foi encerrado!");

	}
	
	public static Paciente p = new Paciente();
	public static  ArrayList<Paciente> reumatologista = new ArrayList<Paciente>();
	public static  ArrayList<Paciente> dermatologista = new ArrayList<Paciente>();
	public static  ArrayList<Paciente> pneumologista = new ArrayList<Paciente>();
	public static  ArrayList<Paciente> proctologista = new ArrayList<Paciente>();
	public static  ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	
	public static void menu() {
		System.out.println("Selecione a opção a seguir para continuar: ");
		System.out.println("1 -> adicionar paciente");
		System.out.println("2 -> excluir paciente");
		System.out.println("3 -> exibir lista de pacientes por especialidades");
		System.out.println("4 -> exibir lista de pacientes geral");
		System.out.println("5 -> atender pacientes");
		System.out.println("0 -> encerrar");
	}
	
	public static void especialidade() {
		System.out.println("1. reumatologista");
		System.out.println("2. dermatologista");
		System.out.println("3. pneumologista");
		System.out.println("4. proctologista");
	}
	
	public static void exibir() {
		if(proctologista.size()==0 && reumatologista.size()==0 && dermatologista.size()==0 && pneumologista.size()==0) {
			System.out.println("Não há pacientes aqui!");
		}else {
		if(reumatologista.size()>0) {
			System.out.println("Pacientes para o REUMATOLOGISTA");
			for(int i = 0; i<reumatologista.size(); i++) {
				System.out.println("Nome: " + reumatologista.get(i).getNome());
				System.out.println("CPF: " + reumatologista.get(i).getCpf());
				System.out.println("Nascimento: " + reumatologista.get(i).getNascimento());
				System.out.println("__________________________________________________");
			}
		}
		if(dermatologista.size()>0) {
			System.out.println("Pacientes para o DERMATOLOGISTA");
			for(int i = 0; i<dermatologista.size(); i++) {
				System.out.println("Nome: " + dermatologista.get(i).getNome());
				System.out.println("CPF: " +dermatologista.get(i).getCpf());
				System.out.println("Nascimento: " +dermatologista.get(i).getNascimento());
				System.out.println("__________________________________________________");
			}
		}
		if(pneumologista.size()>0) {
			System.out.println("Pacientes para o PNEUMOLOGISTA");
			for(int i = 0; i<pneumologista.size(); i++) {
				System.out.println("Nome: " +pneumologista.get(i).getNome());
				System.out.println("CPF: " +pneumologista.get(i).getCpf());
				System.out.println("Nascimento: " + pneumologista.get(i).getNascimento());
				System.out.println("__________________________________________________");
			}
		}
		if(proctologista.size()>0) {
			System.out.println("Pacientes para o PROCTOLOGISTA");
			for(int i = 0; i<proctologista.size(); i++) {
				System.out.println("Nome: " +proctologista.get(i).getNome());
				System.out.println("CPF: " +proctologista.get(i).getCpf());
				System.out.println("Nascimento: " + proctologista.get(i).getNascimento());
				System.out.println("__________________________________________________");
				}
			}
		}
	}
}