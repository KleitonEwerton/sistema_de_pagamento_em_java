/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistemadepagamento;

import java.util.Collections;
import java.util.Comparator;
import static com.kleitonewerton.sistemadepagamento.Utils.cabecalhoTabela2;
import static com.kleitonewerton.sistemadepagamento.Utils.leitura;
import static com.kleitonewerton.sistemadepagamento.Utils.teclado;
import static com.kleitonewerton.sistemadepagamento.Utils.cabecalhoTabela1;
import static com.kleitonewerton.sistemadepagamento.Utils.cabecalhoTabela5;
import static com.kleitonewerton.sistemadepagamento.Utils.leituraSalario;
import static com.kleitonewerton.sistemadepagamento.Utils.leituraVenda;
import javax.swing.JOptionPane;


/**
 *
 * @author KleitonEwerton
 */
public class Funcoes {
    
    /**
    * @brief                                         Funcao que verifica se existe funcionario com esse codigo
    * @codigo                                        Codigo do funcionario
    * @return                                        Se exixte esse funcionario ou não
    */
    public static boolean verificaCodigo(String codigo){
        
        return !(Vendedor.verificaCodigoVendedor(codigo) != -1 ||  Gerente.verificaCodigoGerente(codigo) != -1);
    }
    
    /**
    * @brief                                          Função que printa a tabela de funcionarios relacionados         
    */
    private void printFuncionariosRelacionados(){
        
        cabecalhoTabela2();
        
        for(Gerente ger: Gerente.listGerentes)
            if(ger.getListVendedoresAssociados().size() > 0){
                
                System.out.print("\n| " + ger.getCodigo());
                for(int i = 0; i < 40 - ger.getCodigo().length();i++)System.out.print(" ");

                System.out.print(" | ");
                for(String codigo: ger.getListVendedoresAssociados()) System.out.print(codigo+"; ");
                    
            }
        System.out.print(  "\n|-------------------------------------------------------------------------------------------------------|\n");
        
    }
    
    /**
    * @brief                                          Função que printa a tabela de funcionarios         
    */
    private void printFuncionarios(){

       cabecalhoTabela1();

       for(Funcionarios funcionarios : Funcionarios.listFuncionarios){

               System.out.print("| " + funcionarios.getNome());
               for(int i = 0; i < 40 - funcionarios.getNome().length();i++)System.out.print(" ");

               System.out.print(" | " + funcionarios.getCodigo());
               for(int i = 0; i < 40 - funcionarios.getCodigo().length();i++)System.out.print(" ");



               System.out.print("  | " + funcionarios.getFuncao());
               for(int i = 0; i < 15 - funcionarios.getFuncao().length();i++)System.out.print(" ");

               System.out.println("|");

       }
       System.out.println("|-------------------------------------------------------------------------------------------------------|\n");
    }
    
    /**
    * @brief                                          Função permite cadastrar um vendedor         
    */
    public void cadatroVendedor(){
        
        printFuncionarios();
        
        System.out.println("\nPARA CADASTRA UM VENDEDOR DIGITE OS VALORES DOS CAMPOS REFERENTE AO CADASTRO.");
            
        String nome = leitura("\nDIGITE O NOME DO VENDEDOR (MAX: 40). PARA CANCELAR DIGITE 'CANCELAR'", true);
        if( nome.equals("CANCELAR"))return;
        
        String codigo = leitura("\nDIGITE O CODIGO DE REGISTRO DESSE VENDEDOR (MAX: 40). PARA CANCELAR DIGITE 'CANCELAR'",false);
        if( codigo.equals("CANCELAR"))return;
        
        //ADD O NOVO VENDEDOR NA LISTA DE FUNCIONARIOS
        Funcionarios.listFuncionarios.add(new Vendedor(codigo,nome,leituraSalario()));
        
        //ORDENA AS LISTA POR ORDEM ALFABETICA USANDO NOME E DEPOIS POR SUA FUNÇÃO, PRIMEIRO OS GERETES DEPOIS O VENDEDORES
        Collections.sort(Funcionarios.listFuncionarios, Comparator.comparing(Funcionarios::getNome));
        Collections.sort(Funcionarios.listFuncionarios, Comparator.comparing(Funcionarios::getFuncao));
        
        printFuncionarios();
        
    }
    
    /**
    * @brief                                          Função permite cadastrar um gerente   
    */
    public void cadatroGerente(){
        
        printFuncionarios();
        
        System.out.println("\nPARA CADASTRA UM GERENTE DIGITE OS VALORES DOS CAMPOS REFERENTE AO CADASTRO");
            
        String nome = leitura("\nDIGITE O NOME DO GERENTE (MAX: 40). PARA CANCELAR DIGITE 'CANCELAR'", true);
        if( nome.equals("CANCELAR"))return;
        
        String codigo = leitura("\nDIGITE O CODIGO DE REGISTRO DESSE GERENTE (MAX: 40). PARA CANCELAR DIGITE 'CANCELAR'",false);
        if( codigo.equals("CANCELAR"))return;
        
        //ADD O NOVO GERENTE NA LISTA DE FUNCIONARIOS
        Funcionarios.listFuncionarios.add(new Gerente(codigo,nome,leituraSalario()));
        
        //ORDENA AS LISTA POR ORDEM ALFABETICA USANDO NOME E DEPOIS POR SUA FUNÇÃO, PRIMEIRO OS GERETES DEPOIS O VENDEDORES
        Collections.sort(Funcionarios.listFuncionarios, Comparator.comparing(Funcionarios::getNome));
        Collections.sort(Funcionarios.listFuncionarios, Comparator.comparing(Funcionarios::getFuncao));
        
        printFuncionarios();
        
    }
    
    /**
    * @brief                                          Função para associar um vendedor a um gerente        
    */
    public void associaVendedorGerente(){
        String codigoGerente;
        String codigoVendedor;
        
        printFuncionarios();
        
        while(true){
            
            System.out.println("\nDIGITE O CODIGO DO GERENTE QUE TERA UM ASSOCIADO. PARA CANCELAR DIGITE 'CANCELAR'");
            codigoGerente = teclado.nextLine();
            
            if(codigoGerente.equals("CANCELAR"))return;
            
            int indexGerente = Gerente.verificaCodigoGerente(codigoGerente);
            
            if( indexGerente == -1){
                
                
                JOptionPane.showMessageDialog(null, "CODIGO DO GERENTE NAO ENCONTRADO", "ERRO",JOptionPane.ERROR_MESSAGE);
                printFuncionarios();
            
            }else{
                
                while(true){
                    
                    System.out.println("\nDIGITE O CODIGO DO VENDEDOR A SER ASSOCIADO A ESSE GERENTE. PARA CANCELAR DIGITE 'CANCELAR'");
                    codigoVendedor = teclado.nextLine();
                    if(codigoVendedor.equals("CANCELAR"))return;
                    
                    if(Vendedor.verificaCodigoVendedor(codigoVendedor) == -1){
                        
                        JOptionPane.showMessageDialog(null, "CODIGO DO VENDEDOR NAO ENCONTRADO", "ERRO",JOptionPane.ERROR_MESSAGE);
                        printFuncionarios();
                        
                    }else{
                        
                        Gerente.listGerentes.get(indexGerente).associaVendedor(codigoVendedor);
                        break; 
                    }
                }
                System.out.println("\n O vendedor com o codigo '" + codigoVendedor+ "' foi associado ao gerente de codigo '" + codigoGerente+"'\n");
                break; 
            }
        }
        printFuncionariosRelacionados();
    }
    
    /**
    * @brief                                          Função para realizar uma venda      
    */
    public void realizarVendas(){
        
        Venda.printVendas();
        String codigoVendedor;
        while(true){
            System.out.println("\nDIGITE O CODIGO DO VENDEDOR A REALIZAR UMA VENDA. PARA CANCELAR DIGITE 'CANCELAR'");
            codigoVendedor = teclado.nextLine();

            if(codigoVendedor.equals("CANCELAR"))return;

            int index = Vendedor.verificaCodigoVendedor(codigoVendedor);

            if( index != -1){

                System.out.println("\nDIGITE A DESCRICAO DA VENDA. PARA CANCELAR DIGITE 'CANCELAR'");
                String descricao = teclado.nextLine();

                if(descricao.equals("CANCELAR"))return;

                double valor = leituraVenda();
                if(valor < 0)return;

                Vendedor.listVendedores.get(index).realizarVenda(descricao, valor);
                break;
            }
            else 
                JOptionPane.showMessageDialog(null, "CODIGO DE VENDEDORES NAO ENCONTRADO", "ERRO",JOptionPane.ERROR_MESSAGE);
        }
        
    Venda.printVendas();
    }
    
    /**
    * @brief                                          Função para calcular os ganhos        
    */
    public void calcularGanhos(){
         
        cabecalhoTabela5();
        
        for(Funcionarios fun:Funcionarios.listFuncionarios){
            
            System.out.print("  " + fun.getNome());
            for(int i = 0; i < 40 - fun.getNome().length();i++)System.out.print(" ");
            
            System.out.print(" | " + fun.getCodigo());
            for(int i = 0; i < 40 - fun.getCodigo().length();i++)System.out.print(" ");
            
            double sal = fun.getSalariodiario();
            double comissao = fun.comisao();
            
            System.out.print(" | R$ " + sal + " + "+ comissao+ " = R$ " + (sal+comissao) + "\n");
            
        }
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|\n");
           
    }
   
}
