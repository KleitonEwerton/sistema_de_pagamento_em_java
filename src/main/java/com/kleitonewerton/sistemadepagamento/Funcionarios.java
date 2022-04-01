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
abstract class Funcionarios {
    
    private final String nome;
    private final String codigo;
    private final String funcao;
    private double salarioDiario;
    
    //Lista de funcionarios registrados
    public static List<Funcionarios> listFuncionarios = new ArrayList<>();
    
    /**
    *@brief                 Construtor da classe funcionários
    * 
    * @param cadigo         Codigo de registro que será usado como forma de identificação
    * @param nome           Nome do funcionario
    * @param funcao         Funcao do determinado funcionario
    */
    public Funcionarios(String codigo, String nome, String funcao, double salario){
        this.nome   = nome;
        this.codigo = codigo;
        this.funcao = funcao;
        this.salarioDiario = salario;
    }
    
    /**
    * @brief                Metodo abstrato que calcula a comição individual de cada um
    * @return               o valor da comição
    */
    public abstract double comisao();
    
    /**
    * @brief                Metodo get que retorna o codigo do funcionario
    * @return               Retorna o codigo do funcionario
    */
    public String getCodigo() {
        return codigo;
    }

    /**
    * @brief                Metodo get que retorna o nome
    * @return               Retorna o nome do funcionario
    */
    protected String getNome() {
        return nome;
    }

    /**
    * @brief                Metodo get que retorna o funcao
    * @return               Retorna a funcao
    */
    public String getFuncao() {
        return funcao;
    }

    public double getSalariodiario() {
        return salarioDiario;
    }

}
