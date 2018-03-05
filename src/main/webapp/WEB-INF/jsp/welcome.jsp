<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>Carpooling | Home</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.min.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Carpooling</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-user">Registration</a></li>
                <li><a href="about">About</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login-user">Login</a></li>
            </ul>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <span style="color: green;">
            <c:if test="${blad == 'DELETE'}">
                <c:out value="${'Account deleted correctly'}"></c:out>
            </c:if>
            </span>
            <div class="jumbotron text-center">
                <h1>Welcome to CarpoolingApp</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_TASKS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>My Tasks</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Date Created</th>
                        <th>Finished</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="task" items="${tasks}">
                        <tr>
                            <td>${task.id}</td>
                            <td>${task.name}</td>
                            <td>${task.description}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${task.dateCreated}"/></td>
                            <td>${task.finished}</td>
                            <td><a href="update-task?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="delete-task?id=${task.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
        <div class="container text-center">
            <h3>Create Account</h3>
            <hr>
            <span style="color: red;">
            <c:if test="${mail == 'BAD'}">
                <c:out value="${'Invalid email address or existing'}"></c:out>
            </c:if>
            </span>
            <form class="form-horizontal" method="POST" action="save-user">

                <input type="hidden" name="id" value="${user.id}"/>
                <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="name" value="${user.name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Username</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="nickname" value="${role.nickname}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Surname</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="surname" value="${user.surname}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Phone</label>
                    <div class="col-md-7">
                        <input type="tel" class="form-control" name="phone" value="${user.phone}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Gender</label>
                    <div class="col-md-7">
                        <select type="text" class="form-control" name="gender" value="${user.gender}">
                            <option>Man</option>
                            <option>Woman</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Born year</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="bornyear" value="${user.bornyear}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Mail</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="mail" value="${user.mail}"/>

                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Password</label>
                    <div class="col-md-7">
                        <input type="password" class="form-control" name="password" value="${role.password}"/>
                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>

            </form>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_LOGIN'}">
        <div class="container text-center">
            <span style="color: red;">
        <c:if test="${password == 'BAD'}">
            <c:out value="${'Invalid password '}"></c:out>
        </c:if>
            </span>
            <span style="color: red;">
        <c:if test="${mail == 'BAD'}">
            <c:out value="${'Invalid email address or no existing'}"></c:out>
        </c:if>
            </span>
            <span style="color: red;">
        <c:if test="${register == 'BAD'}">
            <c:out value="${'You are not sign in.Please sign in or create new account'}"></c:out>
        </c:if>
            </span>
            <span style="color: green;">
            <c:if test="${good == 'GOOD'}">
                <c:out value="${'Account created'}"></c:out>
            </c:if>
            </span>
        <form class="form-horizontal" method="POST" action="check-user">
            <div class="form-group">
                <label class="control-label col-md-3">Mail</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" name="mail" value="${user.mail}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">Password</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" name="password" value="${role.password}"/>
                </div>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Login"/>
            </div>
        </form>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_ABOUT'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>CarpoolingApp</h1>
            </div>
            <div class="jumbotron text-center">
                <p><strong>Carpooling</strong> is the sharing of car journeys so that more than one person travels in a car, and prevents the need for others to have to drive to a location themselves.
                </p>
            </div>
        </div>
    </c:when>
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>