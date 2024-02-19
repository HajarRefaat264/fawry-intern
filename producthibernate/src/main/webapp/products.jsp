<%@ page import="org.eclipse.jakarta.hello.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                margin: 20px;
            }

            .button-link {
                        display: inline-block;
                        padding: 10px 20px;
                        font-size: 16px;
                        text-align: center;
                        text-decoration: none;
                        background-color: #4CAF50;
                        color: white;
                        border: none;
                        border-radius: 5px;
                        cursor: pointer;

                    }

                    /* Hover effect */
                    .button-link:hover {
                        background-color: #45a049;
                    }
                    table {
                                width: 80%;
                                border-collapse: collapse;

                            }

                            th, td {
                                border: 1px solid #ddd;
                                padding: 8px;
                                text-align: left;
                            }

                            th {
                                background-color: #4CAF50;
                                color: white;
                            }

                            /* Alternate row colors */
                            tr:nth-child(even) {
                                background-color: #f2f2f2;
                            }




        </style>
</head>
<body>

<%
    // Check if the user is authenticated
    Boolean authenticated = (Boolean) request.getSession().getAttribute("authenticated");

    if (authenticated != null && authenticated) {
        // If authenticated, display the products
        List<Product> products = (List<Product>) request.getAttribute("products");
%>
        <h2>Products</h2>
<%-- Display an error message if product deletion fails --%>
    <c:if test="${param.error == 'deleteError'}">
        <div style="color: red;">Product deletion failed. Please try again.</div>
    </c:if>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Delete</th>
                 <th>Update</th>
            </tr>
            <% for (Product product : products) { %>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td>

                        <form action="deleteProduct" method="get" style="display:inline;">
                            <input type="hidden" name="id" value="<%= product.getId() %>">
                            <input type="submit" class="button-link" value="Delete">
                        </form>
                    </td>
                    <td>
                    <a href="updateProduct.jsp?id=<%= product.getId() %>&name=<%= product.getName() %>&price=<%= product.getPrice() %>"
                                                                   class="button-link">Update</a>
                                        </td>
                </tr>
            <% } %>
        </table></br></br>

        <a href="addProduct.jsp" class="button-link">Add New Product</a>
<%
    } else {
        // If not authenticated, display a message or redirect to the login page
        response.sendRedirect("login.jsp");
    }
%>

</body>
</html>
