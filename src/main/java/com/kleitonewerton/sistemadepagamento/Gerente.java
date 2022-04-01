/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistemadepagamento;


import static com.kleitonewerton.sistemadepagamento.Vendedor.verificaCodigoVendedor;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author KleitonEwerton
 */
public class Gerente extends Funcionarios{
    
    public final static double valorComicao =   0.05; //Comição sobre a venda dos vendedores relacionados
    
    private final List<String> listVendedoresAssociados = new ArrayList<>();
    
    public static List<Gerente> listGerentes = new ArrayList<>();
    
    public static int qntGerents = 0;
    
    
    
    /**
    * @brief                                                Metodo construtor da classe gerente
    * @param codigo                                         Codigo do gerente
    * @param nome                                           Nome do gerente
    */
    public Gerente(String codigo, String nome, double salarioDiario){
        
        super(codigo,nome, "Gerente", salarioDiario);
        Gerente.qntGerents += 1;
        Gerente.listGerentes.add(this);
       
    }
    
    /**
    * @brief                                                Metodo que associa um vendedor ao gerente 
    */
    public void associaVendedor(String codigoVendedor){
        
        if( !listVendedoresAssociados.contains(codigoVendedor)){
            listVendedoresAssociados.add(codigoVendedor);
        }
    }
    
    
    /**
    * @brief                                                Metodo que verifica o codigo de um gerente
    * @return                                               Retorna -1 caso não exista tal regente, caso exista retorna o index dela no Array
    */
    public static int verificaCodigoGerente(String codigo){
        
        for(int i = 0; i < listGerentes.size();i++)
            
            if(listGerentes.get(i).getCodigo().equals(codigo))
                return i;
       
        return -1;

    }
    
    /**
    * @brief                                                Metodo get quatidade de geretnes
    * @return                                               Retorna a quantidade de gerentes
    */
    public static int getQntGerents() {
        return Gerente.qntGerents;
    }

    /**
    * @brief                                                Metodo get lista do vendedores associados
    * @return                                               Retorna a lista dos vendedores associados
    */
    public List<String> getListVendedoresAssociados() {
        return this.listVendedoresAssociados;
    }
    
    @Override
    public double comisao() {
        double valorVendido = 0;
        
        for(String associados: listVendedoresAssociados){
            
            int index = verificaCodigoVendedor(associados);
            valorVendido += Vendedor.listVendedores.get(index).comisao();
            
        }
        return valorVendido * Gerente.valorComicao;
    }
}
