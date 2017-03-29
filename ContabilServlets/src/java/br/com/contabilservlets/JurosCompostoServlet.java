/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.contabilservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PA01
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juroscomposto.html"})
public class JurosCompostoServlet extends HttpServlet {

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
				"		<li><a href='index.html'>Home</a></li>" +
				"		<li><a href='jurossimples.html'>Juros Simples</a></li>" +
                                "		<li class='active'><a href='juroscomposto.html'>Juros Composto <span class='sr-only'>(current)</span></a></li>" +
				"	</ul>" +
				"</div>" +
				"</div>" +
				"</nav>";
        
        
        double capital = 0;
        double taxa = 0;
        int periodo = 0;
        double juros = 0;
        
        try {
            capital = Double.parseDouble(request.getParameter("capital"));
            taxa = Double.parseDouble(request.getParameter("taxa"));
            periodo = Integer.parseInt(request.getParameter("periodo"));
        } catch (Exception e) {
            e.getMessage();
        }
        
        JurosComposto js = new JurosComposto();
        juros = js.calculoJurosComposto(capital, taxa, periodo);
        String strJuros = js.toString();
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        df.format(juros);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculo de Juros Composto</title>");   
            out.println("<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='js/bootstrap.min.js'>");
            out.println("</head>");
            out.println("<body>");
            out.println(menu);
            out.println("<div class='container-fluid'>");
            out.println("<h1>Calculo de juros composto</h1>");
            out.println("<form name='formCalculoJurosComposto' method='post'>");
            out.println("<div class='row'>");
            out.println("<div class='col-md-3'>");
            out.println("<label for='capital'>Capital R$:</label><input type='text' value='"+capital+"' class='form-control' name='capital' />");
            out.println("</div>");
            out.println("<div class='col-md-3'>");
            out.println("<label for='taxa'>Taxa:</label><input type='text' name='taxa' value='"+taxa+"' class='form-control' />");
            out.println("</div>");
            out.println("<div class='col-md-3'>");
            out.println("<label for='periodo'>Periodo (em meses):</label><input type='text' value='"+periodo+"' class='form-control' name='periodo' placeholder='Ex.: 100 = 100 meses' />");
            out.println("</div>");
            out.println("<div class='col-md-3'>");
            out.println("<label>&nbsp;</label><br/>");
            out.println("<input type='submit' name='btnCalcularJurosComposto' class='btn btn-primary' value='Calcular' />");
            out.println("</div></div>");
            out.println("</form>");
            // TODO: ajustar o template, adicionar uma estilização / tabela / whateverelse
            if(juros > 0){
                out.println("<h3>Valor total: R$ "+ df.format(juros) +"</h3>");
                out.println("<h3>Juros: R$ "+ (df.format(juros-capital)) +"</h3>");
                out.println("<div class='col-md-6'><table class='table table-condensed table-hover'>"+strJuros+"</table></div>");
            }
            out.println("</row>");
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
