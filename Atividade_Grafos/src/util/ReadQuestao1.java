/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import grafo.Grafo;
import grafo.Vertice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author marce
 */
public class ReadQuestao1 {
     
    public   static  void readVertices(Grafo<Integer> g) throws FileNotFoundException, IOException{
        BufferedReader bf = new BufferedReader(new FileReader("src\\Questao_1\\entrada\\Vertice.txt") );
        
        String linha = bf.readLine();// lendo a primeira linha do arquivo
            try{    
                while(linha != null ){
                    //String[] L = linha.split(";");
                    
                    
                    g.adicionarVertice( Integer.parseInt(linha) );
                    
                    /*Cliente novo = new Cliente(Integer.parseInt(L[0]),L[1]);
                    Node<Cliente> n = new Node<>(novo,novo.getId());
                    tab.inserir(n, novo.getId());*/
                    linha = bf.readLine();
                }
            }catch(NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
    }
    public   static  void readArestas(Grafo<Integer> g) throws FileNotFoundException, IOException{
        
        BufferedReader bf = new BufferedReader(new FileReader("src\\Questao_1\\entrada\\Aresta.txt") );
        
        String linha = bf.readLine();// lendo a primeira linha do arquivo
            try{    
                while(linha != null ){
                    String[] L = linha.split(";");
                    //g.adicionarVertice( Integer.parseInt(linha) );
                    g.adicionarAresta(Integer.parseInt(L[0]), Integer.parseInt(L[1]));
                
                    linha = bf.readLine();
                }
            }catch(NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
    }
    public   static  void readVertices2(Grafo<String> g) throws FileNotFoundException, IOException{
        BufferedReader bf = new BufferedReader(new FileReader("src\\Questao_1\\entrada\\Vertice2.txt") );
        
        String linha = bf.readLine();// lendo a primeira linha do arquivo
            try{    
                while(linha != null ){
                    //String[] L = linha.split(";");
                    
                    
                    g.adicionarVertice( linha );
                    
                    /*Cliente novo = new Cliente(Integer.parseInt(L[0]),L[1]);
                    Node<Cliente> n = new Node<>(novo,novo.getId());
                    tab.inserir(n, novo.getId());*/
                    linha = bf.readLine();
                }
            }catch(NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
    }
    public   static  void readArestas2(Grafo<String> g) throws FileNotFoundException, IOException{
        
        BufferedReader bf = new BufferedReader(new FileReader("src\\Questao_1\\entrada\\Aresta2.txt") );
        //BufferedReader bf = new BufferedReader(new FileReader(path) );
        
        String linha = bf.readLine();// lendo a primeira linha do arquivo
            try{    
                while(linha != null ){
                    String[] L = linha.split(";");
                    //g.adicionarVertice( Integer.parseInt(linha) );
                    g.adicionarAresta(L[0], L[1]);
                
                    linha = bf.readLine();
                }
            }catch(NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
    }
    
}
