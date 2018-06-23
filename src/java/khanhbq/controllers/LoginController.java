package khanhbq.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanhbq.daos.AvengerDAO;
import khanhbq.dtos.AvengerDTO;
import khanhbq.dtos.AvengerError;

public class LoginController extends HttpServlet {

    private static final String ERROR = "index.jsp";
    private static final String ADMIN = "admin/index.jsp";
    private static final String USER = "user/index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        try {
            String loginName = request.getParameter("txtLoginName");
            String password = request.getParameter("txtPassword");

            //  Validations
            boolean isValid = true;
            AvengerError err = new AvengerError();

            if (loginName.length() == 0) {
                err.setLoginName("Login name can't be empty");
                isValid = false;
            }
            if (password.length() == 0) {
                err.setPassword("Password can't be empty");
                isValid = false;
            }

            if (isValid) {
                //  Start login
                AvengerDAO dao = new AvengerDAO();
                AvengerDTO dto = dao.checkLogin(loginName, password);
                if (dto != null) {
                    switch (dto.getRole()) {
                        case "admin":
                            session.setAttribute("USER_INFO", dto);
                            url = ADMIN;
                            break;
                        case "user":
                            session.setAttribute("USER_INFO", dto);
                            url = USER;
                            break;
                        default:
                            request.setAttribute("RESULT_ERROR", "Your account is invalid");
                            break;
                    }
                } else {
                    request.setAttribute("RESULT_ERROR", "Invalid username or password");
                }
            } else {
                request.setAttribute("VALIDATE_ERROR", err);
            }

        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
