<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<<<<<<< HEAD
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="stylesheet" href="<c:url value="/resources/css/fullcalendar.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/mCal.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.css"/>">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/mCal.js"/>"></script>
    <script src="<c:url value="/resources/js/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/js/fullcalendar.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js"/>"></script>

    <title>mCal - Online Calendar</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <script>
        $(document).ready(function() {

            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,basicWeek,basicDay'
                },
                editable: false,
                eventLimit: true, // allow "more" link when too many events
                events: [
                        <c:forEach items="${calendarEvents}" var="calendarEvent">
                            {
                                id: ${calendarEvent.id},
                                title: '${calendarEvent.title}',
                                start: '${calendarEvent.startDate.toString("yyyy-MM-dd'T'HH:mm:ss")}',
                                end: '${calendarEvent.endDate.toString("yyyy-MM-dd'T'HH:mm:ss")}',
                            },
                        </c:forEach>
                ]
            });

        });

    </script>
    <script type="text/javascript">
        $(function () {
            $('#startDate').datetimepicker();
            $('#startDate').data("DateTimePicker").format("DD-MM-YYYY HH:mm:ss");
            $('#endDate').datetimepicker();
            $('#endDate').data("DateTimePicker").format("DD-MM-YYYY HH:mm:ss");
        });
    </script>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>iCal Generator</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/error.css"/>" rel="stylesheet">

    <style type="text/css">
        .marginBottom-0 {margin-bottom:0;}
        .dropdown-submenu{position:relative;}
        .dropdown-submenu>.dropdown-menu{top:0;left:100%;margin-top:-6px;margin-left:-1px;-webkit-border-radius:0 6px 6px 6px;-moz-border-radius:0 6px 6px 6px;border-radius:0 6px 6px 6px;}
        .dropdown-submenu>a:after{display:block;content:" ";float:right;width:0;height:0;border-color:transparent;border-style:solid;border-width:5px 0 5px 5px;border-left-color:#cccccc;margin-top:5px;margin-right:-10px;}
        .dropdown-submenu:hover>a:after{border-left-color:#555;}
        .dropdown-submenu.pull-left{float:none;}.dropdown-submenu.pull-left>.dropdown-menu{left:-100%;margin-left:10px;-webkit-border-radius:6px 0 6px 6px;-moz-border-radius:6px 0 6px 6px;border-radius:6px 0 6px 6px;}
    </style>

>>>>>>> 2172ff30be23e202d8ca13ed6d7bddbdfcbfd0c5
</head>

<body>
<<<<<<< HEAD

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="../" class="navbar-brand">mCal - Online calendar</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav">
                <li>
                    <a onclick="location.href='updateDatabase'" title="updateDatabase" data-toggle="modal" data-target="#update-database-modal">Aktualizacja planu</a>
                </li>
                <li>
                    <a href="#">Dokumentacja</a>
                </li>
            </ul>
        </div>
=======
    <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type='text/javascript' src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script type='text/javascript'>
        (function($){
            $(document).ready(function(){
                $('ul.dropdown-menu [data-toggle=dropdown]').on('click', function(event) {
                    event.preventDefault();
                    event.stopPropagation();
                    $(this).parent().siblings().removeClass('open');
                    $(this).parent().toggleClass('open');
                });
            });
        })(jQuery);
    </script>

    <div class="page-header text-center">
        <h1>iCal Generator</h1>
        <p>Import from XML, CSV, iCal and Plan UZ</p>
>>>>>>> 2172ff30be23e202d8ca13ed6d7bddbdfcbfd0c5
    </div>
</div>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">Witaj na mCal</h1>
        <p>Aplikacja jest rezultatem pracy stworzonej przez studentów II roku informatyki w składzie: Sebastian Sobierajski,<br> Piotr Różański, Kamil Kiliszek, Robert Koziołek, Bartosz Śledź, Krystian Dziędzioła, Bartosz Nowotyński, Bartosz Stępień</p>
    </div>
</div>

<div class="container">
    <!-- Row for errors -->
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-3">
            <h2>Dodaj wpis</h2>
            <p>Aby dodać wpis skorzystaj z poniższego formularza:</p>
            <form:form action="addEvent" method="post" modelAttribute="calendarEvent">
                <fieldset class="form-group">
                    <form:label path="title" cssErrorClass="error">Nazwa wydarzenia:</form:label>
                    <form:errors path="title" cssClass="alert alert-danger" role="alert" element="div"/>
                    <div class='input-group' >
                        <form:input path="title" type="text" cssClass="form-control" cssErrorClass="form-control error"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-flag"></span>
                    </span>
                    </div>
                    <form:label path="tag" cssErrorClass="error">Tagi:</form:label>
                    <form:errors path="tag" cssClass="alert alert-danger" role="alert" element="div"/>
                    <div class='input-group' >
                        <form:input path="tag" type="text" cssClass="form-control" cssErrorClass="form-control error"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-tag"></span>
                    </span>
                    </div>
                    <form:label path="startDate" cssErrorClass="error">Data rozpoczęcia:</form:label>
                    <form:errors path="startDate" cssClass="alert alert-danger" role="alert" element="div"/>
                    <div class='input-group date' >
                        <form:input path="startDate" type="text" cssClass="form-control" cssErrorClass="form-control error"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                    <form:label path="endDate" cssErrorClass="error">Data zakończenia:</form:label>
                    <form:errors path="startDate" cssClass="alert alert-danger" role="alert" element="div"/>
                    <div class='input-group date' >
                        <form:input path="endDate" type="text" cssClass="form-control" cssErrorClass="form-control error"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                    <form:label path="timeZone" cssErrorClass="form-control error">Strefa czasowa:</form:label>
                    <form:errors path="timeZone" cssClass="alert alert-danger" role="alert" element="div"/>
                    <div class='input-group' >
                       <form:select path="timeZone" class="form-control" cssErrorClass="form-control error" value="">
                           <c:forEach var="zone" items="<%=java.util.TimeZone.getAvailableIDs(3600000)%>">
                               <option value="${zone}">${zone}</option>
                           </c:forEach>
                       </form:select>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-map-marker"></span>
                    </span>
                    </div>
                    <form:label path="description" cssErrorClass="error">Opis:</form:label>
                    <form:errors path="description" cssClass="alert alert-danger" role="alert" element="div"/>
                    <div class='input-group date' >
                        <form:input path="description" cssClass="form-control" type="text" cssErrorClass="form-control error"/><br>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </span>
                    </div>
                </fieldset>
                <fieldset class="form-group">
                    <div class="form-group buttons">
                        <button type="reset" class="btn btn-secondary">Reset</button>
                        <button type="submit" class="btn btn-primary">Dodaj</button>
                    </div>
                </fieldset>
            </form:form>
            <h2>Importery</h2>
            <form:form id="command" method="POST" action="importFromFile" enctype="multipart/form-data">
                <fieldset class="form-group">
                    <label class>Importuj wydarzenia z pliku:</label>
                    <p>Możliwy import z formatu: iCal, XML, CSV</p>
                    <input type="file" name="file"><br>
<<<<<<< HEAD
                    <button class="btn btn-primary" type="submit" data-toggle="modal" data-target="#file-import-modal">Import</button>
                </fieldset>
            </form:form>

            <h3>Import z planu UZ</h3>
            <p>Wybierz plan, który chcesz zaimportować:</p>
=======
                    <input type="submit" value="Import">
                </form:form><br><br><br>

                <label>Import from Plan UZ:</label><br>

                <div class="collapse navbar-collapse" id="navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Select group <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <c:forEach items="${departmentsList}" var="department">
                                    <li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${department.name}</a>
                                        <ul class="dropdown-menu">
                                            <c:forEach items="${department.studyBranchList}" var="studyBranch">
                                                <li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${studyBranch.name}</a>
                                                <ul class="dropdown-menu">
                                                    <c:forEach items="${studyBranch.groupTimetablesList}" var="groupTimetable">
                                                        <li><a href="importGroup/${groupTimetable.name}">${groupTimetable.name}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                </div>

                <br><br>
                <input onclick="location.href='updateDatabase'" title="updateDatabase" type="button" value="Update database">

            </div>
        </div>
>>>>>>> 2172ff30be23e202d8ca13ed6d7bddbdfcbfd0c5

            <!-- Start PlanUZ -->
            <div class="collapse navbar-collapse" id="navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Select group <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${departmentsList}" var="department">
                                a
                                <li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${department.name}</a>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${department.studyBranchList}" var="studyBranch">
                                        <li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${studyBranch.name}</a>
                                            <ul class="dropdown-menu">
                                                <c:forEach items="${studyBranch.groupTimetablesList}" var="groupTimetable">
                                                    <li><a href="importGroup/${groupTimetable.name}">${groupTimetable.name}</a></li>
                                                </c:forEach>
                                            </ul>
                                            </c:forEach>
                                    </ul>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>


            <!-- Import modal window -->
            <div id="file-import-modal" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Import pliku</h4>
                        </div>
                        <div class="modal-body">
                            <p>Trwa importowanie pliku. To może potrwać chwilę. Proszę czekać...  <img src="<c:url value="/resources/img/gears.svg"/>"/></p>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <!-- Update database modal window -->
            <div id="update-database-modal" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Aktualizacja planu UZ</h4>
                        </div>
                        <div class="modal-body">
                            <p>Trwa aktualizowanie planu UZ. To może potrwać chwilę. Proszę czekać...  <img src="<c:url value="/resources/img/gears.svg"/>"/></p>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

        </div>
        <div class="col-md-9">
            <div id="calendar"></div>
        </div>
    </div>
    <hr>

    <footer>
        <p>&copy; ProjectUZ 2016</p>
    </footer>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>