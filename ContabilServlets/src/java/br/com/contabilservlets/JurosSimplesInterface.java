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
interface JurosSimplesInterface {
    
    /**
     * Calculo de juro simples.
     * @param capital float
     * @param taxa float
     * @param periodo int
     */
    public float calculoJurosSimples(float capital, float taxa, int periodo);
   
}
