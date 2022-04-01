/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistemadepagamento;

import static com.kleitonewerton.sistemadepagamento.Utils.*;


/**
 *
 * @author KleitonEwerton
 */
public class Sistema {
    
    /**
    * @brief                Função do menu do programa principal
    */
    public static void menu(){
        
        while(true){
            
            int escolha = escolhaDoMenu();
            Funcoes programPrincipal = new Funcoes();
            String buffer;
            switch(escolha){
                
                case 6:
                    System.out.println("\nVOCE SAIU DO PROGRAMA, OBRIGADO POR USAR NOSSO SISTEMA\n");
                    
                    return;
                
                case 1:
                    System.out.println("\nCADASTRO DE UM VENDEDOR\n");
                    buffer = teclado.nextLine();
                    programPrincipal.cadatroVendedor();
                    break;
                case 2:
                    System.out.println("\nCADASTRO DE UM GERENTE\n");
                    buffer = teclado.nextLine();
                    programPrincipal.cadatroGerente();
                    break;
                case 3:
                    System.out.println("\nASSOCIAR VENDEDOR\n");
                    buffer = teclado.nextLine();
                    programPrincipal.associaVendedorGerente();
                    break;
                    
                case 4:
                    System.out.println("\nREGISTRAR UMA VENDA\n");
                    buffer = teclado.nextLine();
                    programPrincipal.realizarVendas();
                    break; 
                    
                case 5:
                    System.out.println("\nVALORES A SEREM PAGOS\n");
                    buffer = teclado.nextLine();
                    programPrincipal.calcularGanhos();
                    break; 
            }
               
            
        }
        
    }
    
    public static void main(String[] args){
    
       mensagemBemVindo();
       
        menu();
        
    }
    
}
