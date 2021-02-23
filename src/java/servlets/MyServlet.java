/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
package servlets;

import entity.Computer;
import entity.Customer;
import entity.History;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ComputerFacade;
import session.CustomerFacade;
import session.HistoryFacade;

/**
 *
 * @author pupil

@WebServlet(name = "MyServlet", urlPatterns = {
    "/addPCForm",
    "/createComputer",
    "/createCustomer",
    "/addCustomerForm",
    "/listComputers",
    "/listCustomers",
    "/showBuyComputer",
    "/buyComputer",
    "/boughtComputer"})
public class MyServlet extends HttpServlet {

    @EJB
    ComputerFacade computerFacade;
    @EJB
    CustomerFacade customerFacade;
    @EJB
    HistoryFacade historyFacade;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        List<Customer> listCustomers = customerFacade.findAll();
        List<Computer> listComputers = computerFacade.findAll();
        switch(path) {
            case "/addPCForm":
                request.getRequestDispatcher("/WEB-INF/addPCForm.jsp").forward(request, response);
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
                Computer computer = new Computer(manufacturer, model, procmodel, videocard, ram, soundboard, harddrive, ssd, power, Integer.parseInt(price));
                computerFacade.create(computer);
                request.setAttribute("info", "Новый ПК был добавлен");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listComputers":
                request.setAttribute("listComputers", listComputers);
                request.getRequestDispatcher("/WEB-INF/listComputers.jsp").forward(request, response);
                break;
            case "/addCustomerForm":
                request.getRequestDispatcher("/WEB-INF/addCustomerForm.jsp").forward(request, response);
                break;
            case "/createCustomer":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String money = request.getParameter("money");
                Customer customer = new Customer(firstname, lastname, phone, email, Integer.parseInt(money));
                customerFacade.create(customer);
                request.setAttribute("info", "Новый Покупатель был добавлен");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listCustomers":
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher("/WEB-INF/listCustomers.jsp").forward(request, response);
                break;
            case "/showBuyComputer":
                listComputers = computerFacade.findAll();
                listCustomers = customerFacade.findAll();
                request.setAttribute("listComputers", listComputers);
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher("/WEB-INF/showBuyComputer.jsp").forward(request, response);
                break;
              case "/buyComputer":
                String computerId = request.getParameter("computerId");
                String customerId = request.getParameter("customerId");
                computer = computerFacade.find(Long.parseLong(computerId));
                customer = customerFacade.find(Long.parseLong(customerId));
                if (customer.getMoney() - computer.getPrice() >= 0) {
                        computerFacade.edit(computer);
                        customer.setMoney(customer.getMoney() - computer.getPrice());
                        customerFacade.edit(customer);
                        History history = new History();
                        history.setComputer(computer);
                        history.setCustomer(customer);
                        history.setComputergiven(new Date());
                        historyFacade.create(history);
                        request.setAttribute("info", "Компьютер куплен клиентом"+ " " + customer.getFirstname() + " " + customer.getLastname());
                    } else {
                        request.setAttribute("info", "Недостаточно средств");
                    }
                 request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/boughtComputer":
                List<History> listHistories = historyFacade.findBoughtComputer();
                request.setAttribute("listHistories", listHistories);
                request.getRequestDispatcher("/WEB-INF/boughtComputer.jsp").forward(request, response);
                break; 
            case "/boughtProduct":
                String historyId = request.getParameter("historyId");
                History history = historyFacade.find(Long.parseLong(historyId));
                history.setComputergiven(new Date());
                historyFacade.edit(history);
                request.setAttribute("info",
                            "Компьюьютер \""
                            + history.getComputer().getManufacturer()
                            + " " + history.getComputer().getModel()
                            + "\" продан покупателю: "
                            + history.getCustomer().getFirstname()
                            + " " + history.getCustomer().getLastname()
                );
                request.getRequestDispatcher("/index.jsp")
                            .forward(request, response);
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
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

*/