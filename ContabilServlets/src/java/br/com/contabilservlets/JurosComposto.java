/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.contabilservlets;

/**
 *
 * @author tiago
 */
public final class JurosComposto extends Juros implements JurosCompostoInterface{

    private double jurosComposto = 0;
    
    
    @Override
    public double calculoJurosComposto(double capital, double taxa, int periodo) {
        
        jurosComposto = capital*(Math.pow((1 + (double)taxa/100), (double)periodo));
        
        return this.jurosComposto;
    }

    
    
}
