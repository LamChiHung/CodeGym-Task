<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet"
          href="./asset/css/bootstrap-5.3.2-dist/css/bootstrap.css">
    <link rel="stylesheet"
          href="./asset/css/style.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col">
            <form action="login">
                <div class="mb-3">
                    <label for="inputUsername"
                           class="form-label">Username</label>
                    <input type="text"
                           class="form-control"
                           id="inputUsername"
                           aria-describedby="usernameHelp"
                           name="username">
                    <div id="usernameHelp"
                         class="form-text"
                    >
                    </div>
                </div>
                <div class="mb-3">
                    <label for="inputPassword"
                           class="form-label">Password</label>
                    <input type="password"
                           class="form-control"
                           id="inputPassword"
                           name="password">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox"
                           class="form-check-input"
                           id="checkBox"
                           name="checkbox"
                           required>
                    <label class="form-check-label"
                           for="checkBox">Agree
                        with term</label>
                </div>
                <button type="submit"
                        class="btn btn-primary">
                    Submit
                </button>
            </form>
        </div>
    </div>
</div>

</body>
</html>