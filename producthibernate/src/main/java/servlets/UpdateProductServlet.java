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

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    private ProductRepository productRepository= new ProductRepository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Check if the user is authenticated
        if (session.getAttribute("authenticated") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Retrieve or create a ProductRepository instance and store it in the session

        if (productRepository == null) {
            productRepository = new ProductRepository();
            session.setAttribute("productRepository", productRepository);
        }

        // Forward to updateProduct.jsp
        request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Check if the user is authenticated
        if (session.getAttribute("authenticated") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Retrieve form data
        int productId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        // Retrieve or create a ProductRepository instance and store it in the session


        // Retrieve products from ProductRepository
        List<ProductEntity> products = productRepository.findProducts();

        // Update the existing product
        for (ProductEntity product : products) {
            if (product.getId() == productId) {
                product.setName(name);
                product.setPrice(price);
                break;
            }
        }

        // Redirect to the products page
        response.sendRedirect(request.getContextPath() + "/products");
    }
}