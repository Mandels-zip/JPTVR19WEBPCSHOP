/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Customer;
import entity.Role;
import entity.User;
import entity.UserRoles;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import session.RoleFacade;
import session.UserFacade;
import session.UserRolesFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "AdminServlet", urlPatterns = {
    "/listCustomers",
    "/adminPanel",
    "/setRole",
})
public class AdminServlet extends HttpServlet {
    @EJB
    private ComputerFacade computerFacade;
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private HistoryFacade historyFacade;
    @EJB
    private UserFacade userFacade;
    @EJB private UserRolesFacade userRolesFacade;
    @EJB private RoleFacade roleFacade;
    
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
        boolean isRole = userRolesFacade.isRole("ADMIN",user);
        if(!isRole){
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите с соответствующими правами!");
            request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        
        String path = request.getServletPath();
        switch (path) {
            case "/listCustomers":
                List<Customer> listCustomers = customerFacade.findAll();
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("listCustomers")).forward(request, response);
                break;
            case "/adminPanel":
                List<Role> listRoles = roleFacade.findAll();
                request.setAttribute("listRoles", listRoles);
                Map<User,String> usersMap = new HashMap<>();
                List<User> listUsers = userFacade.findAll();
                for(int i = 0; i < listUsers.size(); i++){
                    usersMap.put(listUsers.get(i), userRolesFacade.getTopRoleForUser(listUsers.get(i)));
                }
                request.setAttribute("usersMap", usersMap);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("adminPanel")).forward(request, response);
                break;
            case "/setRole":
                String userId = request.getParameter("userId");
                String roleId = request.getParameter("roleId");
                if("".equals(userId) || userId == null
                        || "".equals(roleId) || roleId == null){
                    request.setAttribute("userId", userId);
                    request.setAttribute("roleId", roleId);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/adminPanel").forward(request, response);
                    break;
                }
                user = userFacade.find(Long.parseLong(userId));
                Role role = roleFacade.find(Long.parseLong(roleId));
                UserRoles userRoles = new UserRoles(user, role);
                if(!"admin".equals(user.getLogin())){
                    userRolesFacade.setNewRole(userRoles);
                    request.setAttribute("info", "Роль изменена");
                }else{
                    request.setAttribute("userId", userId);
                    request.setAttribute("roleId", roleId);
                    request.setAttribute("info", "Изменить роль невозможно");
                }
                request.getRequestDispatcher("/adminPanel").forward(request, response);
                break;
            case  "/editUser":
                userId = request.getParameter("userId");
                User editUser = userFacade.find(Long.parseLong(userId));
                request.setAttribute("user", editUser);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("editUserForm")).forward(request, response);
                break;
            case "/changeUser":
                userId = request.getParameter("userId");
                User pUser = userFacade.find(Long.parseLong(userId));
                if("admin".equals(pUser.getLogin()) && !"admin".equals(user.getLogin())){
                    request.setAttribute("info", "Вы не имеете прав на изменение данных этого пользователя");
                    request.getRequestDispatcher("/editUser").forward(request, response);
                    break;
                }
                Customer pCustomer = customerFacade.find(pUser.getCustomer().getId());
                String firstname = request.getParameter("firstname");
                if(pCustomer != null && !"".equals(firstname)) pCustomer.setFirstname(firstname);
                String lastname = request.getParameter("lastname");
                if(pCustomer != null && !"".equals(lastname)) pCustomer.setLastname(lastname);
                String phone = request.getParameter("phone");
                if(pCustomer != null && !"".equals(phone)) pCustomer.setPhone(phone);
                String money = request.getParameter("money");
                if(pCustomer != null && !"". equals(money)) pCustomer.setMoney(money);
//                String login = request.getParameter("login");
//                if(pUser != null && !"".equals(login)) pUser.setLogin(login);
                String password = request.getParameter("password");
                if(pUser != null && !"".equals(password)){
                    //здесь шифруем пароль и получаем соль
                    pUser.setPassword(password);
                    //user.setSalt(salt);
                    
                }
                customerFacade.edit(pCustomer);
                pUser.setCustomer(pCustomer);
                userFacade.edit(pUser);
                request.setAttribute("user", pUser);
                request.setAttribute("info", "Данные пользователя изменены");
                request.getRequestDispatcher("/editUser").forward(request, response);
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
