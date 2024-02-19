<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }

       .form-container {
                           width: 300px;
                           margin: 50px auto;
                           padding: 20px;
                           border: 1px solid #ccc;
                           border-radius: 5px;
                           background-color: #f9f9f9;
                           box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                       }

                       /* Style for labels */
                       label {
                           display: block;
                           margin-bottom: 8px;
                           font-weight: bold;
                       }

                       /* Style for input fields */
                       input {
                           width: 100%;
                           padding: 10px;
                           margin-bottom: 15px;
                           box-sizing: border-box;
                           border: 1px solid #ccc;
                           border-radius: 4px;
                       }

                       /* Style for submit button */
                       input[type="submit"] {
                           background-color: #4CAF50;
                           color: white;
                           padding: 10px 15px;
                           border: none;
                           border-radius: 4px;
                           cursor: pointer;
                       }

                       /* Hover effect for submit button */
                       input[type="submit"]:hover {
                           background-color: #45a049;
                       }
        .logo {
                    width: 200px;
                    height: 200px;
                    margin-bottom: 20px;
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
    </style>
</head>
<body>

<h2>Update Product</h2>
</br>

<img src="images/pro.jpg" alt="Logo" class="logo">
</br><

<div class="form-container">
    <form action="updateProduct" method="post">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <label for="name">Name</label>
        <input type="text" id="name" name="name"  value="<%= request.getParameter("name") %>" required><br>

        <label for="price">Price</label>
        <input type="number" id="price" name="price" step="0.01"  value="<%= request.getParameter("price") %>" required><br>

        <input type="submit" value="Update Product" >
    </form>
    <a href="products" class="button-link">Back >> </a>
</div>



</body>
</html>
