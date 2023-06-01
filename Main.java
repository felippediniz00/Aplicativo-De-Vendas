
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //1) Armazene os dados em vetores e exiba na tela.
        String nome[] = {"Ivo","Leia","Susi","Alan","Ian","Bia","Gil"};
        double salarioBase[] = {3000.00,2200.00,2400.00,2000.00,2500.00,2600.00,3500.00};
        double vendas[] = {7000.00,20000.00,15000.00,6000.00,5000.00,22000.00,8000.00};
        char categoria[] = {'b','e','e','b','b','e','b'};

        for (int i = 0; i < nome.length; i++) {
            System.out.printf("%10s %10.2f %10.2f %10c\n", nome[i], salarioBase[i], vendas[i], categoria[i]);
        }


        //2) Calcule e escreva a média dos salários base dos vendedores externos.
        double medSal, somaSal = 0;
        int qtdExterno = 0;


        //3) Exiba os nomes e os salários finais de todos os vendedores, sendo que o vendedor externo recebe seu salário
        //base mais 20% de suas vendas e o vendedor do balcão recebe seu salário base mais 5% de suas vendas.
        double salFinal;
        double porcExterno, porcBalcao;

        //4) Solicite que o usuário digite uma categoria e calcule e exiba a porcentagem de vendedores da categoria
        //digitada.
        char categDig;
        int contador = 0;
        double porcVendedores;

        //5) Qual é o nome e a categoriado vendedor que fez a menor venda?
        String menosVendeu = nome[0];
        double menorVenda = vendas[0];
        char categMenorVenda = categoria[0];

        int opcao;

        do {
            System.out.print("\nMenu\n" +
                    "1- Média salários vendedores Externo\n" +
                    "2- Salário Final com as porcentagem de vendas\n" +
                    "3- Porcentagem de vendedores por categoria\n" +
                    "4- Menor Venda\n" +
                    "5- Sair\n" +
                    "Digite a opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    //1) Calcule e escreva a média dos salários base dos vendedores externos.
                    for (int i = 0; i < salarioBase.length; i++) {
                        if (categoria[i] == 'e') {
                            qtdExterno++;
                            somaSal += salarioBase[i];
                        }
                    }
                    medSal = somaSal/qtdExterno;
                    System.out.printf("\nA média dos salarios bases dos vendedores externos é: %.2f reais\n",medSal);
                    break;
                case 2:
                    //2) Exiba os nomes e os salários finais de todos os vendedores, sendo que o vendedor externo recebe seu salário
                    //base mais 20% de suas vendas e o vendedor do balcão recebe seu salário base mais 5% de suas vendas.
                    for (int i = 0; i < salarioBase.length; i++) {
                        if (categoria[i] == 'e') {
                            salFinal = salarioBase[i] + (vendas[i] * (20.0/100));
                        }else {
                            salFinal = salarioBase[i] + (vendas[i] * (5.0/100));
                        }
                        System.out.printf("%10s %6.2f reais\n", nome[i], salFinal);
                    }
                    break;
                case 3:
                    //3) Solicite que o usuário digite uma categoria e calcule e exiba a porcentagem de vendedores da categoria
                    //digitada.
                    boolean achou = false;
                    System.out.printf("Digite uma categoria: ");
                    categDig = scan.next().charAt(0);
                        for (int i = 0; i < salarioBase.length; i++) {
                            if (categDig == categoria[i]) {
                                achou = true;
                                contador++;
                            }
                        }
                        if (!achou) {
                            System.out.println("\nCategoria não encontrada!");
                        } else {
                            porcVendedores = (double) contador / categoria.length * 100;
                            System.out.printf("\nA porcentagem de vendedores dessa categoria é: %.2f \n",porcVendedores);
                        }
                    break;
                case 4:
                    //5) Qual é o nome e a categoriado vendedor que fez a menor venda?
                    for (int i = 0; i < categoria.length; i++) {
                       if (vendas[i] < menorVenda) {
                           menorVenda = vendas[i];
                           menosVendeu = nome[i];
                           categMenorVenda = categoria[i];
                       }
                    }
                    System.out.println("\nMenor venda é de: " + menosVendeu);
                    System.out.println("A categoria do vendedor é: " + categMenorVenda);
                    System.out.printf("O valor da venda é: %.2f\n", menorVenda);
                    break;
                case 5:
                    System.out.println("Encerrado!");
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        } while (opcao != 5);
    }
}