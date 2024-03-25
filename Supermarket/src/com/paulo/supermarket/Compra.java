package com.paulo.supermarket;

import java.util.Scanner;

public class Compra {


    private int user_id;
    private int prod_id;
    private String prod_name;




   public void choice_compra(){

       System.out.println("O que você deseja, 1- Add prod carrinho , 2- Excluir prod carrinho");

       Scanner input = new Scanner(System.in);

       int choice = input.nextInt();

       if(choice==1){




       }
       if(choice==2){


       }

   }




    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }








}
