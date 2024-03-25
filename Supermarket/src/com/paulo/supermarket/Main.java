package com.paulo.supermarket;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static Estoque Vendedor(int u_id, boolean consum) {
        ArrayList<Produto> produtos= new ArrayList<Produto>();
        Estoque estoque = new Estoque();


        //memória fixa
        AddEstoque addProd = new AddEstoque();

        addProd.setU_id(12);
        addProd.setP_id(18);
        addProd.setP_name("Rádio");

        produtos.add(addProd);
        estoque.setProduto_lista(produtos);


        if(consum==false){
            System.out.println("O que vc deseja, 1- Add ao estoque, 2- Remover do estoque ?"+"\n");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();



        //add ao estoque
        if(choice==1) {


            System.out.println("Digite o nome produto: ");
            input = new Scanner(System.in);

            String p_nome = input.next();

            System.out.println("Digite o ID produto: ");
            input = new Scanner(System.in);

            int p_id = input.nextInt();

            addProd = new AddEstoque();
            addProd.setU_id(u_id);
            addProd.setP_id(p_id);
            addProd.setP_name(p_nome);

            produtos.add(addProd);
            estoque.setProduto_lista(produtos);

            for(Produto i : estoque.getProduto_lista()){
              if(i.getU_id()==u_id){
                  System.out.println("Estoque:\n" + "ID Vendedor: " + i.getU_id() + "\n" + "ID Prod: " + i.getP_id() + "\n" + "Nome Prod: " + i.getP_name() + "\n");
              }

            }



        }




        //remover do estoque
        if(choice==2) {

            for( int i = 0; i < estoque.getProduto_lista().size(); i++) {

                if (estoque.getProduto_lista().get(i).getU_id() == u_id && estoque.getProduto_lista().get(i).getP_id() == 18) {

                    estoque.getProduto_lista().remove(i);
                    System.out.println("Detectou.");

                }

            }

            for(Produto i : estoque.getProduto_lista()){
                if(i.getU_id()==u_id){
                    System.out.println("Estoque:\n" + "ID Vendedor: " + i.getU_id() + "\n" + "ID Prod: " + i.getP_id() + "\n" + "Nome Prod: " + i.getP_name() + "\n");
                }

            }

        }

      }




        return estoque;
    }


    static void Comprador(int u_id, boolean consum) {



        ArrayList<Produto> produtos = new ArrayList<Produto>();

        //memória fixa
        Produto prod1 = new Produto();
        prod1.setU_id(45);
        prod1.setP_name("Vassoura");
        prod1.setP_id(34);

        Produto prod2 = new Produto();
        prod2.setU_id(39);
        prod2.setP_name("Arroz");
        prod2.setP_id(28);

        produtos.add(prod1);
        produtos.add(prod2);


        Produto prod = new Produto();
        Carrinho carrinho = new Carrinho();
        carrinho.setProduto_lista(produtos);


        System.out.println("O que vc deseja, 1- Add ao carrinho, 2- Ver carrinho ?"+"\n");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        Estoque estoque = Vendedor(u_id, true);

        if(consum==false) {
            //add ao carrinho
            if (choice == 1) {

                System.out.println("Digite o ID do produto: ");
                input = new Scanner(System.in);

                int c_id_prod = input.nextInt();


                for (Produto i : estoque.getProduto_lista()) {

                    if (i.getU_id() == u_id && i.getP_id() == c_id_prod) {
                        //  System.out.println("Consumindo de Estoque:\n"+"ID Vendendor: "+i.getU_id()+"\n"+"ID Prod: "+i.getP_id()+"\n"+"Nome Prod: "+i.getP_name()+"\n");


                        prod.setU_id(i.getU_id());
                        prod.setP_name(i.getP_name());
                        prod.setP_id(i.getP_id());

                        produtos.add(prod);
                        carrinho.setProduto_lista(produtos);

                        estoque.getProduto_lista().remove(i);
                        System.out.println("Adicionado com sucesso.");
                        System.out.println("Carrinho:\n" + "ID Comprador: " + i.getU_id() + "\n" + "ID Prod: " + i.getP_id() + "\n" + "Nome Prod: " + i.getP_name() + "\n");
                        break;

                    }

                }

            }

            //ver carrinho
            if (choice == 2) {

                for (Produto i : carrinho.getProduto_lista()) {

                    if (i.getU_id() == u_id){
                        System.out.println("Carrinho:\n" + "ID Comprador: " + i.getU_id() + "\n" + "ID Prod: " + i.getP_id() + "\n" + "Nome Prod: " + i.getP_name() + "\n");
                    }else{
                       System.out.println("Carrinho vazio.");
                    }


                }
            }

          /*  for( int i = 0; i < estoque.getProduto_lista().size(); i++) {
                if(carrinho.getProduto_lista().get(i).getU_id() == u_id){
                    System.out.println("Estoque:\n"+"ID Vendendor: "+estoque.getProduto_lista().get(i).getU_id()+"\n"+"ID Prod: "+estoque.getProduto_lista().get(i).getP_id()+"\n"+"Nome Prod: "+estoque.getProduto_lista().get(i).getP_name()+"\n");
                }
            }*/

        }





    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        
        User user = new User();
        
        System.out.println("Digite seu nome: ");
        Scanner input = new Scanner(System.in);
        String u_name = input.next();
        user.setU_name(u_name);

        System.out.println("Digite sua senha(id): ");
        input = new Scanner(System.in);
        int u_id = input.nextInt();
        user.setU_id(u_id);




        System.out.println("O que você deseja, 1- Vender, 2- Comprar");
        input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice==1){
            Vendedor(u_id,false);
        }
        if(choice==2){
            Comprador(u_id,false);


        }
















    }


}