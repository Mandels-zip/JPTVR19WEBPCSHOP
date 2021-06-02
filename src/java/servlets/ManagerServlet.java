/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Computer;
import entity.History;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ComputerFacade;
import session.CustomerFacade;
import session.HistoryFacade;
import session.UserFacade;
import session.UserRolesFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "ManagerServlet", urlPatterns = {
    "/addPCForm",
    "/createComputer",
    "/changeComputer",
    "/boughtComputer",
    "/discountForm",
    "/setDiscount"

})
public class ManagerServlet extends HttpServlet {
    @EJB
    private ComputerFacade computerFacade;
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private HistoryFacade historyFacade;
    @EJB
    private UserFacade userFacade;
    @EJB private UserRolesFacade userRolesFacade;
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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        boolean isRole = userRolesFacade.isRole("MANAGER",user);
        if(!isRole){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите с соответствующими правами!");
            request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        
        String path = request.getServletPath();
        switch (path) {
            case "/addPCForm":
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addPCForm")).forward(request, response);
                break;
            case "/createComputer":
                String manufacturer = request.getParameter("manufacturer");
                String model = request.getParameter("model");
                String procmodel = request.getParameter("procmodel");
                String videocard = request.getParameter("videocard");
                String ram= request.getParameter("ram");
                String soundboard= request.getParameter("soundboard");
                String harddrive = request.getParameter("harddrive");
                String ssd = request.getParameter("ssd");
                String power = request.getParameter("power");
                String price = request.getParameter("price");
                String quantity = request.getParameter("quantity");
                Computer computer = new Computer(manufacturer, model, procmodel, videocard, ram, soundboard, harddrive, ssd, power, Integer.parseInt(price), Integer.parseInt(quantity));
                computerFacade.create(computer);
                request.setAttribute("info", "Новый ПК был добавлен");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;     
                
            case "/discountForm":
                
                break;
            case   "/setDiscount":
                
                break;
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

