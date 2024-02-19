package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repos.ProductRepository;

import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ProductRepository productRepository= new ProductRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (isValidUser(username, password)) {

            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);

            // Redirect to the products page
            response.sendRedirect(request.getContextPath() + "/products");
        } else {
            // If authentication fails, redirect back to login page
            response.sendRedirect(request.getContextPath() + "/login");
        }



    }

    private boolean isValidUser(String username, String password) {

        return "hajar".equals(username) && "hajar123".equals(password);
    }
}
