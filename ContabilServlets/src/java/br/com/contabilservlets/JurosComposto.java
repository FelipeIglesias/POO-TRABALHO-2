/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.contabilservlets;

import java.text.DecimalFormat;

/**
 *
 * @author tiago
 */
public final class JurosComposto extends Juros implements JurosCompostoInterface{

    private double jurosComposto = 0;
    private String strJurosComposto = "";
    
    
    @Override
    public double calculoJurosComposto(double capital, double taxa, int periodo) {
        
        jurosComposto = capital*(Math.pow((1 + (double)taxa/100), (double)periodo));
        
        double juros = capital;
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        
        for (int i = 1; i <= periodo; ++i){
              juros += ((taxa/100) * juros);
              this.strJurosComposto += "<tr><td>"+i+"º Mês</td><td>"+df.format(juros)+"</td></tr>";
        }
        
        return this.jurosComposto;
    }

    @Override
    public String toString() {
        return this.strJurosComposto; //To change body of generated methods, choose Tools | Templates.
    }    
}
