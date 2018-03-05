<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="user-home" class="navbar-brand">Carpooling</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="user-reserv">My Reservation</a></li>
                <li><a href="my-offers">My Offers</a></li>
                <li><a href="driver">Driver Mode</a></li>
                <li><a href="new-offer">Add Offer</a></li>
                <li><a href="all-users">Give Opinion</a></li>
                <li><a href="get-reserv">Make Reservation</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="update-user">Account</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
<div>

</div>
<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
             <span style="color: red;">
            <c:if test="${blad == 'DRIVER_ERROR'}">
                <c:out value="${'You already create driver account'}"></c:out>
            </c:if>
            </span>
            <span style="color: red;">
            <c:if test="${blad == 'DELETE'}">
                <c:out value="${'Complete your all offers before delete account'}"></c:out>
            </c:if>
            </span>
            <div class="jumbotron text-center">
                <h1>Welcome to CarpoolingApp</h1>
                <h1>${nickname.nickname}</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_NEW_CAR'}">
        <div class="container text-center">
            <h3>Create Driver</h3>
            <h3>Register Your Car</h3>
            <hr>
            <span style="color: red;">
            <c:if test="${blad == 'DRIVER'}">
                <c:out value="${'You are not driver.Create driver licence'}"></c:out>
            </c:if>
            </span>
            <form class="form-horizontal" method="POST" action="car-new">
                <input type="hidden" name="id" value="${car.id}"/>
                <div class="form-group">
                    <label class="control-label col-md-3">Brand</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="brand" value="${car.brand}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Model</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="model" value="${car.model}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Rejestration Number</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="rejestrationNumber"
                               value="${car.rejestrationNumber}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Sits Number</label>
                    <div class="col-md-7">
                        <select type="tel" class="form-control" name="sitsNumber" value="${car.sitsNumber}">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_OFFER'}">
        <div class="container text-center">
            <h3>Drive Offer</h3>
            <hr>
            <span style="color: red;">
            <c:if test="${blad == 'BAD'}">
                <c:out value="${'Invalid email address or existing'}"></c:out>
            </c:if>
            </span>
            <form class="form-horizontal" method="POST" action="check-offer">
                <div class="form-group">
                    <label class="control-label col-md-3">Begin Nation</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="beginNation" value="${route.beginNation}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Begin City</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="beginCity" value="${route.beginCity}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">End Nation</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="endNation" value="${route.endNation}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">End City</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="endCity" value="${route.endCity}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3">Date</label>
                    <div class="col-md-7">
                        <input type="date" class="form-control" name="date" value="value="${offer.date}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Cost</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="cost" value="${offer.cost}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Sits Number</label>
                    <div class="col-md-7">
                        <select type="text" class="form-control" name="sitsNumber" value="${offer.sitsNumber}">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Smoke or not</label>
                    <div class="col-md-7">
                        <select type="tel" class="form-control" name="smokeOrNot" value="${preference.smokeOrNot}">
                            <option>Yes</option>
                            <option>No</option>
                            <option>Both</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Prefer gender</label>
                    <div class="col-md-7">
                        <select type="tel" class="form-control" name="preferGender" value="${preference.preferGender}">
                            <option>Man</option>
                            <option>Woman</option>
                            <option>Both</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Animal</label>
                    <div class="col-md-7">
                        <select type="tel" class="form-control" name="animalYesOrNot" value="${preference.animalYesOrNot}">
                            <option>Yes</option>
                            <option>No</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_OPINION'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Choose Users</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Phone</th>
                        <th>Mail</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.phone}</td>
                            <td>${user.mail}</td>
                            <td><a href="give-opinion?id=${user.id}"><span class="glyphicon glyphicon-star-empty"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_GIVEOPINION'}">
        <div class="container text-center">
            <h3>Give Opinion to ${user.name} </h3>
            <hr>
            <span style="color: red;">
            <c:if test="${blad == 'BAD'}">
                <c:out value="${'Invalid email address or existing'}"></c:out>
            </c:if>
            </span>
            <form class="form-horizontal" method="POST" action="check-opinion">
                <div class="form-group">
                    <label class="control-label col-md-3">Comment</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="comments" value="${opinion.comments}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Mark( 1(worst) -> 5(best) )</label>
                    <div class="col-md-7">
                        <select type="text" class="form-control" name="mark" value="${opinion.mark}">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_RESERVE'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Choose Travel</h3>
            <hr>
            <span style="color: red;">
            <c:if test="${blad == 'RESERVE'}">
                <c:out value="${'You do not have any reservation'}"></c:out>
            </c:if>
            </span>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Begin Nation</th>
                        <th>Begin City</th>
                        <th>Destination Nation</th>
                        <th>Destination City</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="offer" items="${offers}">
                        <tr>
                            <td>${offer.id}</td>
                            <td>${offer.beginNation}</td>
                            <td>${offer.beginCity}</td>
                            <td>${offer.endNation}</td>
                            <td>${offer.endCity}</td>
                            <td><a href="reserv-detail?id=${offer.id}"><span class="glyphicon glyphicon-plane"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_DETAIL'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Reserve Travel</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Begin Nation</th>
                        <th>Begin City</th>
                        <th>Destination Nation</th>
                        <th>Destination City</th>

                        <th>Date</th>
                        <th>Cost</th>
                        <th>Free Sits</th>

                        <th>Smoker</th>
                        <th>Prefer Gender</th>
                        <th>Animal</th>

                        <th>Driver</th>
                        <th>Phone</th>
                        <th>Mail</th>


                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${route.id}</td>
                        <td>${route.beginNation}</td>
                        <td>${route.beginCity}</td>
                        <td>${route.endNation}</td>
                        <td>${route.endCity}</td>
                        <td>${driveOffer.date}</td>
                        <td>${driveOffer.cost}</td>
                        <td>${driveOffer.sitsNumber}</td>
                        <td>${preference.smokeOrNot}</td>
                        <td>${preference.preferGender}</td>
                        <td>${preference.animalYesOrNot}</td>
                        <td>${user.name}</td>
                        <td>${user.phone}</td>
                        <td>${user.mail}</td>
                        <form class="form-horizontal" method="POST" action="save-reserv">

                        <td><div class="form-group">
                            <input type="hidden" name="id" value="${route.id}"/>
                            <input type="hidden" name="beginNation" value="${route.beginNation}"/>
                            <input type="hidden" name="beginCity" value="${route.beginCity}"/>
                            <input type="hidden" name="endNation" value="${route.endNation}"/>
                            <input type="hidden" name="endCity" value="${route.endCity}"/>
                            <input type="hidden" name="id" value="${driveOffer.id}"/>
                            <input type="hidden" name="date" value="${driveOffer.date}"/>
                            <input type="hidden" name="cost" value="${driveOffer.cost}"/>
                            <input type="hidden" name="sitsNumber" value="${driveOffer.sitsNumber}"/>
                            <input type="hidden" name="id" value="${preference.id}"/>
                            <input type="hidden" name="smokeOrNot" value="${preference.smokeOrNot}"/>
                            <input type="hidden" name="preferGender" value="${preference.preferGender}"/>
                            <input type="hidden" name="animalYesOrNot" value="${preference.animalYesOrNot}"/>
                            <input type="submit" class="btn btn-primary" value="Reserve"/>
                        </div></td>
                        </form>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_MY_RESERVE'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Choose Users</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Reservation Date</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="reserv" items="${reservs}">
                        <tr>
                            <td>${reserv.id}</td>
                            <td>${reserv.date}</td>
                            <td><a href="user-reserve-detail?id=${reserv.id}"><span class="glyphicon glyphicon-plane"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_MY_RESERVE_DETAIL'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Reserve Detail</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Reservation Id</th>

                        <th>Route Id</th>
                        <th>Begin Nation</th>
                        <th>Begin City</th>
                        <th>Destination Nation</th>
                        <th>Destination City</th>

                        <th>Date</th>
                        <th>Cost</th>
                        <th>Free Sits</th>

                        <th>Smoker</th>
                        <th>Prefer Gender</th>
                        <th>Animal</th>

                        <th>Driver</th>
                        <th>Phone</th>
                        <th>Mail</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${reservationDrive.id}</td>
                        <td>${route.id}</td>
                        <td>${route.beginNation}</td>
                        <td>${route.beginCity}</td>
                        <td>${route.endNation}</td>
                        <td>${route.endCity}</td>
                        <td>${driveOffer.date}</td>
                        <td>${driveOffer.cost}</td>
                        <td>${driveOffer.sitsNumber}</td>
                        <td>${preference.smokeOrNot}</td>
                        <td>${preference.preferGender}</td>
                        <td>${preference.animalYesOrNot}</td>
                        <td>${user.name}</td>
                        <td>${user.phone}</td>
                        <td>${user.mail}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_UPDATE'}">
        <div class="container text-center">
            <h3>User</h3>
            <hr>

            <form class="form-horizontal" method="POST" action="update-save">
                <%--<div class="form-group">--%>
                    <%--<label class="control-label col-md-3">Id</label>--%>
                    <%--<div class="col-md-7">--%>
                        <input type="hidden" class="form-control"  name="id" value="${user.id}" readonly/>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control"  name="name" value="${user.name}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Surname</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="surname" value="${user.surname}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Phone</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="phone" value="${user.phone}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Gender</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="gender" value="${user.gender}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Born year</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="bornyear" value="${user.bornyear}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Mail</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="mail" value="${user.mail}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Update"/>
                </div>
                <div class="form-group">
                    <a href="delete-user" class="btn btn-primary" role="button">Delete Account</a>
                </div>
            </form>

        </div>
    </c:when>
    <c:when test="${mode == 'MODE_MY_OFFERS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>My Travel Offers</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Cost</th>
                        <th>Free Sits Number</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="offer" items="${offers}">
                        <tr>
                            <td>${offer.id}</td>
                            <td>${offer.date}</td>
                            <td>${offer.cost}</td>
                            <td>${offer.sitsNumber}</td>
                            <td><a href="offer-detail?id=${offer.id}"><span class="glyphicon glyphicon-plane"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_OFFER_DETAIL'}">
        <div class="container text-center" id="tasksDiv">
            <h3>My offer detail</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Begin Nation</th>
                        <th>Begin City</th>
                        <th>Destination Nation</th>
                        <th>Destination City</th>

                        <th>Date</th>
                        <th>Cost</th>
                        <th>Free Sits</th>

                        <th>Smoker</th>
                        <th>Prefer Gender</th>
                        <th>Animal</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${route.id}</td>
                        <td>${route.beginNation}</td>
                        <td>${route.beginCity}</td>
                        <td>${route.endNation}</td>
                        <td>${route.endCity}</td>
                        <td>${driveOffer.date}</td>
                        <td>${driveOffer.cost}</td>
                        <td>${driveOffer.sitsNumber}</td>
                        <td>${preference.smokeOrNot}</td>
                        <td>${preference.preferGender}</td>
                        <td>${preference.animalYesOrNot}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>

</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>