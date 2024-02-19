package servlets;

import entity.ProductEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repos.ProductRepository;

import java.io.IOException;
import java.util.List;
@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private ProductRepository productRepository= new ProductRepository();
    // Creating a shared instance of ProductRepository
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Check if the user is authenticated
        if (session.getAttribute("authenticated") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Retrieve or create a ProductRepository instance and store it in the session
        ProductRepository productRepository = (ProductRepository) session.getAttribute("productRepository");
        if (productRepository == null) {
            productRepository = new ProductRepository();
            session.setAttribute("productRepository", productRepository);
        }

        // Retrieve products from ProductRepository
        List<ProductEntity> products = productRepository.findProducts();

        // Set products in the request attribute
        request.setAttribute("products", products);

        // Forward to products.jsp
        request.getRequestDispatcher("/products.jsp").forward(request, response);
    }


}