/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import grafo.Grafo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author marce
 */
public class ReadQuestao4 {
    public   static  void readVertices4(Grafo<String> g) throws FileNotFoundException, IOException{
        BufferedReader bf = new BufferedReader(new FileReader("src\\Questao_4\\entrada\\Vertice.txt") );
        
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
    public   static  void readArestas4(Grafo<String> g) throws FileNotFoundException, IOException{
        
        BufferedReader bf = new BufferedReader(new FileReader("src\\Questao_4\\entrada\\Aresta.txt") );
        //BufferedReader bf = new BufferedReader(new FileReader(path) );
        
        String linha = bf.readLine();// lendo a primeira linha do arquivo
            try{    
                while(linha != null ){
                    String[] L = linha.split(";");
                    //System.out.println(L.length);
                    //g.adicionarVertice( Integer.parseInt(linha) );
                    //System.out.println(L[0].toString());
                    //System.out.println(L[1].toString());
                    //System.out.println(L[2].toString());
                    g.adicionarAresta(Double.parseDouble(L[0]), L[1] , L[2]);
                
                    linha = bf.readLine();
                }
            }catch(NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
    }
}
