
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

public class ForgotPasswordServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        return;
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AccountService serve = new AccountService();
        String path = getServletContext().getRealPath("/WEB-INF");
        String email = (String) request.getParameter("email");
        Boolean sent;
        
        sent = serve.forgotPassword(email, path);
        request.setAttribute("message", "If the address you entered is valid, you will receive an email very soon. Please check your email for your password.");
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        return;
    }

}
