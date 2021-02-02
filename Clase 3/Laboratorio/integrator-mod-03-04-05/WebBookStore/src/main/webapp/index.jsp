<%@page import="java.util.List"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>WebBook</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/coming-soon.min.css" rel="stylesheet">

    </head>

    <body>
        <div class="masthead">
            <div class="masthead-bg">
            </div>
            <div class="container h-100">
                <div class="row h-100">
                    <div class="col-12 my-auto">
                        <div class="masthead-content text-white py-5 py-md-0">
                            <h1 class="mb-3">WebBookStore</h1>
                            <form action="Servlet" method="post">
                                <div class="input-group input-group-newsletter">
                                    <input type="text" class="form-control" placeholder="Search a book using id..." aria-label="Busca un Libro..." aria-describedby="submit-button" name="searchInput">
                                    <div class="input-group-append">
                                        <button class="btn btn-secondary" type="submit" name="act" value="search">Search</button>
                                    </div>
                                </div>
                                <br/>
                                <div class="input-group input-group-newsletter">
                                    <input type="text" class="form-control" placeholder="Delete a book using id..." aria-label="Borra un Libro..." aria-describedby="submit-button" name="deleteInput">
                                    <div class="input-group-append">
                                        <button class="btn btn-secondary" type="submit" name="act" value="delete">Delete</button>
                                    </div>
                                </div>
                                <br/>
                                <div class="input-group input-group-newsletter">
                                    <input type="text" class="form-control" placeholder="Update a book using author,title,price" aria-label="Actualiza un Libro..." aria-describedby="submit-button" name="updateInput">
                                    <div class="input-group-append">
                                        <button class="btn btn-secondary" type="submit" name="act" value="update">Update</button>
                                    </div>
                                    <br/>
                                </div>
                                <br/>
                                <div class="input-group input-group-newsletter">
                                    <input type="text" class="form-control" placeholder="Insert a book using author,title,price" aria-label="Inserta un Libro..." aria-describedby="submit-button" name="insertInput">
                                    <div class="input-group-append">
                                        <button class="btn btn-secondary" type="submit" name="act" value="insert">Insert</button>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container" style="width: 40%; position: absolute; right: 5em;top: 4em" id="tabla">
        <table class="table table-dark table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
            </thead>
            <tbody>
                <%List<Book> books = (List<Book>) session.getAttribute("books");%>
                <%if(books != null){%>
                <%for(Book book : books){%>
                <tr>
                    <th scope="row"><%=book.getId()%></th>
                    <td><%=book.getTitle()%></td>
                    <td><%=book.getAuthor()%></td>
                    <td><%=book.getPrice()%></td>
                    <%}%>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>

    <script src="js/coming-soon.js"></script>

</body>

</html>
