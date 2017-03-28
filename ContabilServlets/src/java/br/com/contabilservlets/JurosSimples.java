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
public final class JurosSimples extends Juros implements JurosSimplesInterface{

    private float jurosSimples = 0;
    
    
    @Override
    public float calculoJurosSimples(float capital, float taxa, int periodo) {
        
        this.jurosSimples = capital*(1+(((float)taxa/100f)*((float)periodo/DIAS_ANO_COMERCIAL)));
        
        return this.jurosSimples;
    }

    
    
}
