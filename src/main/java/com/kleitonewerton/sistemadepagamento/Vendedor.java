/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistemadepagamento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KleitonEwerton
 */
public class Vendedor extends Funcionarios{

    public final static double valorComicao =   0.01;
    
    public static int qntVendedores = 0;
    public static List<Vendedor> listVendedores = new ArrayList<>();
    
    

    private double valorVendido = 0;
    
    /**
    * @brief                        Metodo construtor da classe
    * @param codigo                 Codigo de identificação do vendedor
    * @param nome                   Nome do devido vendedor
    */
    public Vendedor(String codigo, String nome, double salarioDiario){
        
      super(codigo,nome, "Vendedor", salarioDiario);
      Vendedor.qntVendedores += 1;
      Vendedor.listVendedores.add(this);
      
    }

    /**
    * @brief                        Metodo que verifica se existe um vendedor com esse codigo
    * @param codigo                 Codigo de identificação do vendedor
    * @return                       Retorna -1 caso não exista, retorno um int > 0 caso existe, esse int representa o index dele no Array
    */
    public static int verificaCodigoVendedor(String codigo){
        
        for(int i = 0; i < listVendedores.size();i++)
            
            if(listVendedores.get(i).getCodigo().equals(codigo))
                return i;
       
        return -1;
    }
    
    /**
    * @brief                        Metodo que realiza uma venda para esse funcionario
    * @param descricao              Descrição da venda
    * @param valorDeVenda           Valor da venda realizada
    */
    public void realizarVenda(String descricao, double valorDeVenda){
        
        Venda.listVendas.add(new Venda(this.getCodigo(), descricao, valorDeVenda));
        this.valorVendido += valorDeVenda;
    }
    
    @Override
    public double comisao() {
        
        return this.valorVendido * Vendedor.valorComicao;
    }

    
    
}
