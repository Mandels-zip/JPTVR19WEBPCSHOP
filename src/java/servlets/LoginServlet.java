/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import entity.Computer;
import entity.Customer;
import entity.Role;
import entity.User;
import entity.UserRoles;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ComputerFacade;
import session.CustomerFacade;
import session.RoleFacade;
import session.UserFacade;
import session.UserRolesFacade;
import tools.EncryptPassword;

/**
 *
 * @author jvm
 */
@WebServlet(name = "LoginServlet", loadOnStartup = 1, urlPatterns = {
    "/loginForm",
    "/login",
    "/logout",
    "/registrationForm",
    "/createUser",
    "/listComputers",
})
public class LoginServlet extends HttpServlet {
@EJB
    private UserFacade userFacade;
@EJB private RoleFacade roleFacade;
@EJB private CustomerFacade customerFacade;
@EJB private ComputerFacade computerFacade;
@EJB private UserRolesFacade userRolesFacade;

@Inject private EncryptPassword encryptPassword;

public static final ResourceBundle pathToFile = ResourceBundle.getBundle("property.pathToFile");
        
    @Override
    public void init() throws ServletException {
        
       if(userFacade.findAll().size()>0) return;
        String salt = encryptPassword.createSalt();
        String password = encryptPassword.createHash("12345", salt);
        Customer customer = new Customer("Ilya", "Gurov", "56223324", "Gurov@gmail.com", 500);
        customerFacade.create(customer);
        User user = new User("admin", password,customer, salt);
        userFacade.create(user);
        Role role = new Role("ADMIN");
        roleFacade.create(role);
        UserRoles userRoles = new UserRoles(user, role);
        userRolesFacade.create(userRoles);
        role = new Role("MANAGER");
        roleFacade.create(role);
        userRoles = new UserRoles(user,role);
        userRolesFacade.create(userRoles);
        role = new Role("CUSTOMER");
        roleFacade.create(role);
        userRoles = new UserRoles(user,role);
        userRolesFacade.create(userRoles);
        
    }



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
        
        String path = request.getServletPath();
        switch (path) {
            case "/loginForm":
                request.setAttribute("activeLogin", "true");
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("login")).forward(request, response);
                break;
            case "/login":
                HttpSession session = request.getSession(true);
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if("".equals(login) || login == null
                       || "".equals(password) || password == null){
                    request.setAttribute("info","Заполните все поля");
                    request.getRequestDispatcher("/loginForm").forward(request, response);
                    break;
                }
                User user = userFacade.findByLogin(login);
                if(user == null){
                    request.setAttribute("info","Нет такого пользователя");
                    request.getRequestDispatcher("/loginForm").forward(request, response);
                    break;
                }
                String salt = user.getSalt();
                String encryptPwd = encryptPassword.createHash(password, salt);
                 if(user.getPassword().equals(encryptPwd)){
                    session = request.getSession(true);
                    session.setAttribute("user", user);
                    request.setAttribute("info","Вы вошли как "+ user.getLogin());
                    request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);   
                } else {
                    request.setAttribute("info","Неверный пароль!");
                    request.getRequestDispatcher("/loginForm").forward(request, response);
                    break;
                }
                
                break;
            case "/logout":
                session = request.getSession(false);
                if(session != null){
                   session.invalidate();
                }
                request.setAttribute("info", "Вы вышли");
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;
            case "/registrationForm":
                request.setAttribute("activeRegistration", "true");
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("registration")).forward(request, response);
                break;
            case "/createUser":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String money = request.getParameter("money");
                login = request.getParameter("login");
                password = request.getParameter("password");
                if("".equals(firstname) || firstname == null
                       || "".equals(lastname) || lastname == null
                       || "".equals(phone) || phone == null
                       || "".equals(email) || email == null
                       || "".equals(login) || login == null
                       || "".equals(password) || password == null){
                    request.setAttribute("info","Заполните все поля");
                    request.getRequestDispatcher("/registrationForm").forward(request, response);
                    break;
                }
                
                Customer customer = new Customer(firstname, lastname, phone, email, 1500);
                customerFacade.create(customer);
                salt = encryptPassword.createSalt();
                encryptPwd = encryptPassword.createHash(password, salt);
                user = new User(login, encryptPwd, customer,salt);
                userFacade.create(user);
                //Здесь добавим роль пользователю.
                Role roleCustomer = roleFacade.findByName("CUSTOMER");
                UserRoles userRoles = new UserRoles(user, roleCustomer);
                userRolesFacade.create(userRoles);
                request.setAttribute("info", 
                        "Читатель "+user.getLogin()+" добавлен"     
                );
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;  
            case "/listComputers":
                request.setAttribute("activeListComputers", "true");
                List<Computer> listComputers = computerFacade.findAll();
                request.setAttribute("listComputers", listComputers);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("listComputers")).forward(request, response);
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
