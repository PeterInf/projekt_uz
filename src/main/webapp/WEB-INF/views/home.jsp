<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>iCal Generator</title>
</head>
<body>
    <h1>iCal Generator</h1>

    <form:form action="/addEvent" method="post" modelAttribute="calendarEvent">
        Title:<br>
        <form:input path="title" type="text"/><br>

        Start time:<br>
        <input title="startDate" type="text"><br>

        End time:<br>
        <input title="endDate" type="text"><br>

        Tag:<br>
        <form:input path="tag" type="text"/><br>

        Time zone:<br>
        <select title="timeZone">
            <option value="GMT +1:00">GMT +1:00</option>
            <option value="GMT +2:00">GMT +2:00</option>
        </select><br>

        Description:<br>
        <form:input path="description" type="text"/><br>

        <input title="addEvent" type="submit" value="Add event">
        <input title="reset" type="reset" value="Reset">
    </form:form>

    <br>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Start time</th>
            <th>End time</th>
            <th>Tag</th>
            <th>Time zone</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${calendarEvents}" var="calendarEvent">
            <tr>
                <td>${calendarEvent.title}</td>
                <td></td>
                <td></td>
                <td>${calendarEvent.tag}</td>
                <td></td>
                <td>${calendarEvent.description}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <input title="removeEvent" type="button" value="Remove">
    <input title="clearEvents" type="button" value="Clear"><br><br>

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
</body>
</html>