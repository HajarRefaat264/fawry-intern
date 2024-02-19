package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repos.ProductRepository;

import java.io.IOException;
import java.util.List;


@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {


    private ProductRepository productRepository= new ProductRepository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Check if the user is authenticated
        if (session.getAttribute("authenticated") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Retrieve the product id to be deleted
        int productId = Integer.parseInt(request.getParameter("id"));


        if (productRepository == null) {
            // Redirect to the products page if the repository is not available
            response.sendRedirect(request.getContextPath() + "/products");
            return;
        }

        // Delete the product with the specified id
        boolean productDeleted = productRepository.deleteProduct(productId);

        if (productDeleted) {
            // Redirect to the products page if the product was successfully deleted
            response.sendRedirect(request.getContextPath() + "/products");
        }
}
}