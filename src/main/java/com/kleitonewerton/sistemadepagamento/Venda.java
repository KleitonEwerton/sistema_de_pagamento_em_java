/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistemadepagamento;

import static com.kleitonewerton.sistemadepagamento.Utils.cabecalhoTabela4;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KleitonEwerton
 */
public class Venda {

    private double valorDaVenda = 0.0;
    private final String codigoDoVendedor;
    private final String descricao;
    
    public static List<Venda> listVendas = new ArrayList<>();

    
    /**
    * @brief                        Construtor da classe Venda
    * @param codigoDoVendedor       Codigo de identificação do vendedor que realizou a venda
    * @param descricao              Descrição da venda
    * @param valorDaVenda           Valor da venda realizada
    */
    public Venda(String codigoDoVendedor,String descricao, double valorDaVenda) {
        
        this.codigoDoVendedor = codigoDoVendedor;
        this.descricao = descricao;
        this.valorDaVenda = valorDaVenda;
    }

    /**
    * @brief                        Metodo get do valor de venda
    * @return                       Retoro o valor da venda
    */
    public double getValorDaVenda() {
        return valorDaVenda;
    }

    /**
    * @brief                        Metodo get da descrição
    * @return                       Retoro a descrição
    */
    public String getDescricao() {
        return descricao;
    }

    /**
    * @brief                        Metodo get do codigo do vendedor
    * @return                       Retoro o codigo do vendedor
    */
    public String getCodigoDoVendedor() {
        return codigoDoVendedor;
    }
    
    /**
    * @brief                        Metodo que imprime a tabela de vendas
    */
    public static void printVendas(){
        
        cabecalhoTabela4();
        
        for(Venda ven: listVendas){
            
            System.out.print("| " + ven.getCodigoDoVendedor());
            for(int i = 0; i < 40 - ven.getCodigoDoVendedor().length();i++)System.out.print(" ");

            System.out.print(" | " + ven.getValorDaVenda());
            String valor = Double.toString(ven.getValorDaVenda());
            
            for(int i = 0; i < 40 - valor.length();i++)System.out.print(" ");
            
            System.out.print(  " | ");
            System.out.println(ven.getDescricao());
        }
        System.out.println( "|----------------------------------------------------------------------------------------------------------------------------------|");
    
    }
    
}
