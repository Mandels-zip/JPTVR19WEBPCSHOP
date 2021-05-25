package servlets; 
import entity.Computer;
import entity.Customer;
import entity.History;
import entity.User;
import java.io.IOException;
import java.util.Date;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {
    "/showBuyComputer",
    "/buyComputer"
})
public class CustomerServlet extends HttpServlet {
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
        if (user == null){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        boolean isRole = userRolesFacade.isRole("CUSTOMER",user);
        if(!isRole){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите с соответствующими правами!");
            request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {
           case "/showBuyComputer":
                List<Computer> listComputers = computerFacade.findAll();
                List<Customer> listCustomers = customerFacade.findAll();
                request.setAttribute("listComputers", listComputers);
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("showBuyComputer")).forward(request, response);
                break;
            case "/buyComputer":
                Customer customer = user.getCustomer();
                String computerId = request.getParameter("computerId");
                Computer computer = computerFacade.find(Long.parseLong(computerId));
                if(computer.getQuantity() >=0) {
                 if (customer.getMoney() - computer.getPrice() >= 0) {
                        computer.setQuantity(computer.getQuantity()-1);
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
                }else{
                     request.setAttribute("info", "Недостаточное кол-во товара");
                }
                 
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