<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>iCal Generator</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/error.css"/>" rel="stylesheet">
    <meta charset="utf-8">
</head>
<body>
    <div class="page-header text-center">
        <h1>iCal Generator</h1>
        <p>Import from XML, CSV, iCal and Plan UZ</p>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <div class="container">
                <form:form action="addEvent" method="post" modelAttribute="calendarEvent">
                    <form:label path="title" cssErrorClass="error">Title:</form:label><br>
                    <form:input path="title" type="text" cssErrorClass="error"/><br>
                    <form:errors path="title" cssClass="error"/><br>

                    <form:label path="startDate" cssErrorClass="error">Start time:</form:label><br>
                    <form:input path="startDate" type="text" placeholder="dd-mm-yyyy hh:mm:ss"
                                cssErrorClass="error"/><br>
                    <form:errors path="startDate"/><br>

                    <form:label path="endDate" cssErrorClass="error">End time:</form:label><br>
                    <form:input path="endDate" type="text" placeholder="dd-mm-yyyy hh:mm:ss"
                                cssErrorClass="error"/><br>
                    <form:errors path="endDate"/><br>

                    <form:label path="tag" cssErrorClass="error">Tag:</form:label><br>
                    <form:input path="tag" type="text" cssErrorClass="error"/><br>
                    <form:errors path="tag"/><br>

                    <form:label path="timeZone">Time zone:</form:label><br>
                    <form:select path="timeZone">
                        <option value="Europe/Warsaw">Europe/Warsaw</option>
                        <option value="America/Mexico_City">America/Mexico_City</option>
                    </form:select><br><br>

                    <form:label path="description" cssErrorClass="error">Description:</form:label><br>
                    <form:input path="description" type="text" cssErrorClass="error"/><br>
                    <form:errors path="description"/><br><br>

                    <input title="addEvent" type="submit" value="Add event">
                    <input title="clear" type="reset" value="Clear">
                </form:form>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="container">
                <table class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Start time</th>
                        <th>End time</th>
                        <th>Tag</th>
                        <th>Time zone</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${calendarEvents}" var="calendarEvent">
                        <tr>
                            <td></td>
                            <td>${calendarEvent.title}</td>
                            <td>${calendarEvent.startDate}</td>
                            <td>${calendarEvent.endDate}</td>
                            <td>${calendarEvent.tag}</td>
                            <td>${calendarEvent.timeZone.ID}</td>
                            <td>${calendarEvent.description}</td>
                        </tr>
                    </c:forEach>
                </table>

                <br>
                <input title="removeEvent" type="button" value="Remove">
                <input onclick="location.href='clearEvents'" title="clearEvents" type="button" value="Clear"><br><br>
            </div>
        </div>
    </div>

    <br><br><br><br><br>
    <div class="container">
        <select title="fileType">
            <option selected="true" style="display:none;">From file...</option>
            <option value="csv">*.csv</option>
            <option value="xml">*.xml</option>
        </select>
        <input title="importFromFile" type="button" value="Import">

        <select title="planUz">
            <option selected="true" style="display:none;">Plan UZ</option>
            <option value="23">23 Inf-SP</option>
            <option value="24">24 Inf-SP</option>
        </select>
        <input title="importFromPlanUz" type="button" value="Import"><br><br>

        <input title="generateICal" type="button" value="Generate iCal">
        <input title="generateCsv" type="button" value="Generate CSV">
    </div>
</body>
</html>