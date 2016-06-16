<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                ],
                eventClick: function(calEvent, jsEvent, view) {
                    if(calEvent.id != null){
                        $(location).attr('href', 'event/' + calEvent.id);
                    }else{
                        alert("Cannot find event");
                    }
                }
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
</head>
<body>
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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Plan UZ <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                        <c:forEach items="${departmentsList}" var="department">
                            <li class="dropdown-submenu">
                                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" tabindex="-1" href="#">${department.name}</a>
                                <ul class="dropdown-menu">
                                    <c:forEach items="${department.studyBranchList}" var="studyBranch">
                                        <li class="dropdown-submenu">
                                            <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" href="#">${studyBranch.name}</a>
                                            <ul class="dropdown-menu">
                                                <c:forEach items="${studyBranch.groupTimetablesList}" var="groupTimetable">
                                                    <li><a href="importGroup/${groupTimetable.name}">${groupTimetable.name}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                        <li role="separator" class="divider"></li>
                        <li><a onclick="location.href='updateDatabase'" title="updateDatabase" data-toggle="modal" data-target="#update-database-modal">Aktualizacja planu</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dokumentacje <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/resources/docs/Dokumentacja_uzytkownika.pdf"/>">Dokumentacja użytkownika</a></li>
                        <li><a href="<c:url value="/resources/docs/Dziennik-Scrum-Mastera.pdf"/>">Dokumentacja Scrum Mastera</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">Witaj na mCal</h1>
        <p>Aplikacja jest rezultatem pracy stworzonej przez studentów II roku informatyki w składzie: Sebastian Sobierajski,<br> Piotr Różański, Kamil Kiliszek, Robert Koziołek, Bartosz Śledź, Krystian Dziędzioła, Bartosz Nowotyński, Bartosz Stępień</p>
    </div>
</div>