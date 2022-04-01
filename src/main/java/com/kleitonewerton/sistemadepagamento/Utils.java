/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistemadepagamento;

import static com.kleitonewerton.sistemadepagamento.Funcoes.verificaCodigo;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */
public class Utils {
    
    static Scanner teclado = new Scanner(System.in);
    
    /**
    * @brief                Função que permite escolher um opcao do menu do menu 
    */
    public static int escolhaDoMenu(){
        
        while(true){
            
            System.out.println("1. Cadastrar Vendedor;\n2. Cadastrar Gerente;\n3. Associar um Vendedor a um Gerente;");
            System.out.println("4. Registrar as vendas realizadas por um Vendedor;");
            System.out.println("5. Calcular o valor que ser\u00e1 pago a cada Funcion\u00e1rio no final do dia;\n6. Sair.");
            String leitor = teclado.next();
            
            switch(leitor){
                
                case "1" : 
                    return 1;
                
                case "2" : 
                    return 2;
                
                case "3" :
                    return 3;
                
                case "4" :
                    return 4;
                
                case "5" :
                    return 5;
                
                case "6" :
                    return 6;
                
                default : JOptionPane.showMessageDialog(null, "OPCAO INVALIDA, ESCOLHA NOVAMENTE", "ERRO",JOptionPane.ERROR_MESSAGE);
                    
            }
            
        }
        
    }
    
    /**
    *@brief                                 Função que exibe uma mensagem de boas vindas ao usuário
    */
    public static void mensagemBemVindo(){
        
        JOptionPane.showMessageDialog(null, "BEM-VINDO USUARIO AO SISTEMA DE PAGAMENTOS", "BEM-VINDO",JOptionPane.DEFAULT_OPTION);
    }
    
    /**
    * @brief                                    Função de leitura do teclado, usado para validadar se é um codigo e se já está registrado no sistema
    * @param mensagem                           Mensagem a ser exibida ao usuario
    * @param isName                             Se a leitura e para um nome, permite repetições, ou não é um nome, sem repetições
    * @return                                   A String lida
    */
    public static String leitura(String mensagem,boolean isName){
        
        while(true){
            System.out.println(mensagem);
            String lido = teclado.nextLine();
            if(lido.length()<1 || lido.length() > 40)
                JOptionPane.showMessageDialog(null, "TAMANHO INVALIDO! MIN: 1 MAX: 40", "ERRO",JOptionPane.ERROR_MESSAGE);
                
            else 
                if( isName || verificaCodigo(lido))
                    return lido;
                else
                    JOptionPane.showMessageDialog(null, "CODIGO JA CADASTRADO NO SISTEMA", "ERRO",JOptionPane.ERROR_MESSAGE);
                    
        }
        
    }
    
    /**
    * @brief                                    Função de leitura de um numero double para o valor das vendas
    * @return                                   Retorna o numero lido pelo teclado
    */
    public static double leituraVenda(){
        double numero;
        while(true)
            
            try{
                System.out.println("\nDIGITE O VALOR DE VENDA. PARA CANCELAR DIGITE ALGUM VALOR MENOR QUE '0'");
                String number = teclado.nextLine();
                numero = Double.parseDouble(number);
                return numero;
                
            }catch(Exception ex){JOptionPane.showMessageDialog(null, "ERRO NA LEITURA", "ERRO",JOptionPane.ERROR_MESSAGE);}
    }
    
    /**
    * @brief                                    Função de leitura de um numero double para o valor do salario
    * @return                                   Retorna o numero lido pelo teclado
    */
    public static double leituraSalario(){
        double numero;
        while(true)
            
            try{
                System.out.println("\nDIGITE O VALOR DO SALARIO DIARIO");
                String number = teclado.nextLine();
                numero = Double.parseDouble(number);
                return numero;
                
            }catch(Exception ex){JOptionPane.showMessageDialog(null, "ERRO NA LEITURA", "ERRO",JOptionPane.ERROR_MESSAGE);}
    }
    
    /**
    * @brief                                      Função do cabeçalho padrão para a tabela de funcionários cadastrados
    */
    public static void cabecalhoTabela1(){
        
        System.out.println("\n|-------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                      TABELA DE FUNCIONARIOS CADASTRADOS                               |");
        System.out.println("|--------------------------------------------------------------------------------------|----------------|");
        System.out.println("|                    NOME                  |                  CODIGO                   |     FUNCAO     |");
        System.out.println("|--------------------------------------------------------------------------------------|----------------|");
        
    }
    
    /**
    * @brief                                      Função do cabeçalho padrão para a tabela de associados
    */
    public static void cabecalhoTabela2(){
        
        System.out.println("\n|-------------------------------------------------------------------------------------------------------|");
        System.out.println("|                              TABELA DE ASSOCIACAO DE VENDEDORES AOS GERENTES                          |");
        System.out.println("|-------------------------------------------------------------------------------------------------------|");
        System.out.println("|              CODIGO DO GERENTE           |                      CODIGO DOS VENDEDORES                 |");
        System.out.print(  "|-------------------------------------------------------------------------------------------------------|");
        
    }
    
    /**
    * @brief                                      Função do cabeçalho padrão para a tabela de vendas
    */
    public static void cabecalhoTabela4(){
        
        System.out.println("\n|----------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                       TABELA DE VENDAS                                                           |");
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|              CODIGO DO VENDEDOR          |               VALOR DA VENDA             |                   DESCRICAO                |");
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
        
    }
    /**
    * @brief                                      Função do cabeçalho padrão para a tabela de ganhos pessoais
    */
    public static void cabecalhoTabela5(){
        
        System.out.println("\n|------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                   TABELA DE GANHOS PESSOAIS                                            |");
        System.out.println("|------------------------------------------|------------------------------------------|----------------------------------|");
        System.out.println("|                    NOME                  |                  CODIGO                  |GANNHO PESSOAL SALARIO + COMISSÃO |");
        System.out.println("|------------------------------------------|------------------------------------------|----------------------------------|");
        
    }
}
