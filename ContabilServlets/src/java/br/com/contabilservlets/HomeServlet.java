/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.contabilservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PA01
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/index.html"})
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

	String menu = "<nav class='navbar navbar-default'>" +
				"<div class='container-fluid'>" +
				"<div class='navbar-header'>" +
				"    <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'>" +
				"		<span class='sr-only'>Toggle navigation</span>" +
				"		<span class='icon-bar'></span>" +
				"		<span class='icon-bar'></span>" +
				"		<span class='icon-bar'></span>" +
				"   </button>" +
				"   <a class='navbar-brand' href='index.html'>Juros</a>" +
				"</div>" +
				"<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>" +
				"	<ul class='nav navbar-nav'>" +
				"		<li class='active'><a href='index.html'>Home <span class='sr-only'>(current)</span></a></li>" +
				"		<li><a href='jurossimples.html'>Juros Simples</a></li>" +
				"		<li><a href='juroscomposto.html'>Juros Composto</a></li>" +
				"	</ul>" +
				"</div>" +
				"</div>" +
				"</nav>";

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println	("<!DOCTYPE html>");
            out.println	("<html>");
            out.println	("<head>");
            out.println		("<meta charset='utf-8'>");
            out.println		("<title>Juros Economico</title>");
            out.println		("<link rel='stylesheet' type='text/css' href='ecoCss.css'>");
			out.println     ("<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>");
            out.println     ("<link rel='stylesheet' type='text/css' href='js/bootstrap.min.js'>");
            out.println	("</head>");
            out.println	("<body>");
            out.println		(menu);
            out.println		("<div class='container-fluid' id='body'>");
            out.println                 ("<h1>JurosEco</h1><hr>");
            out.println				("<div id='titulo'>");
            out.println					("<h2>Seja bem-vindo ao JurosEco</h2><hr>");			
            out.println				("</div>");
            out.println				("<div id='meio'>");
            out.println					("<h2>Objetivo do Site</h2>");
            out.println					("<p>Site criado para auxiliar as pessoas a calcularem seus juros</p>");
            out.println				("</div>");
            out.println				("<hr>");
            out.println				("<div>");
            out.println					("<h3>Integrantes do Grupo</h3>");
            out.println					("<div id='integran'>");
            out.println						("<ul>");
            out.println							("<p>Felipe Iglesias</p>");
            out.println							("<p>Helaman Spadari</p>");
            out.println							("<p>Tiago Farias</p>");
            out.println							("<h5>FATECPG - ADS - 4º Ciclo</h5>");
            out.println						("</ul>");
            out.println					("</div>");
            out.println				("</div>");
            out.println		("<footer>");
            out.println			("<div id='rodape'>");
            out.println				("<hr><p>Projeto-02 - POO - Ricardo Pupo</p>");
            out.println			("</div>");
            out.println		("</footer>");
            out.println	("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
