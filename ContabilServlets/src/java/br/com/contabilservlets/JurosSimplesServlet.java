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
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/jurossimples.html"})
public class JurosSimplesServlet extends HttpServlet {
    
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
        
        float capital = 0;
        float taxa = 0;
        int periodo = 0;
        float juros = 0;
        
        try {
            capital = Float.parseFloat(request.getParameter("capital"));
            taxa = Float.parseFloat(request.getParameter("taxa"));
            periodo = Integer.parseInt(request.getParameter("periodo"));
        } catch (Exception e) {
            e.getMessage();
        }
        
        JurosSimples js = new JurosSimples();
        juros = js.calculoJurosSimples(capital, taxa, periodo);
        
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        df.format(juros);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='js/bootstrap.min.js'>");
            out.println("<title>Servlet Calculo de Juros Simples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container-fluid'>");
            out.println("<h1>Calculo de juro simples</h1>");
            out.println("<form name='formCalculoJuroSimples' method='post'>");
            out.println("<div class='row'>");
            out.println("<div class='col-md-3'>");
            out.println("<label for='capital'>Capital R$:</label><input type='text' class='form-control' name='capital' value='"+capital+"' />");
            out.println("</div>");
            out.println("<div class='col-md-3'>");
            out.println("<label for='taxa'>Taxa:</label><input type='text' class='form-control' name='taxa' value='"+taxa+"' />");
            out.println("</div>");
            out.println("<div class='col-md-3'>");
            out.println("<label for='periodo'>Periodo (em dias):</label><input type='text' class='form-control' name='periodo' value='"+periodo+"' placeholder='Ex.: 100 = 100 dias' />");
            out.println("</div>");
            out.println("<div class='col-md-3'>");
            out.println("<label>&nbsp;</label><br/>");
            out.println("<button type='submit' name='btnCalcularJurosSimples' class='btn btn-primary'>Calcular <i class='glyphicon glyphicon-eye-open'></i></button>");
            out.println("</div></div>");
            out.println("</form>");
            // TODO: ajustar o template, adicionar uma estilização / tabela / whateverelse
            if(juros > 0){
                out.println("<h3>Valor total: R$ "+ df.format(juros) +"</h3>");
                out.println("<h3>Juros: R$ "+ (df.format(juros-capital)) +"</h3>");
            }
            out.println("</div>");
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
