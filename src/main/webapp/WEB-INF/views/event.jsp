<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendar event (ID: ${calendarEvent.id}</title>
</head>
<body>
    <label>ID: ${calendarEvent.id}</label><br>
    <label>Title: ${calendarEvent.title}</label><br>
    <label>Start date:
        ${calendarEvent.startDate.dayOfMonth}-${calendarEvent.startDate.monthOfYear}-${calendarEvent.startDate.year}
        ${calendarEvent.startDate.hourOfDay}:${calendarEvent.startDate.minuteOfHour}:${calendarEvent.startDate.secondOfMinute}</label><br>
    <label>End date:
        ${calendarEvent.endDate.dayOfMonth}-${calendarEvent.endDate.monthOfYear}-${calendarEvent.endDate.year}
        ${calendarEvent.endDate.hourOfDay}:${calendarEvent.endDate.minuteOfHour}:${calendarEvent.endDate.secondOfMinute}</label><br>
    <label>Tag: ${calendarEvent.tag}</label><br>
    <label>Timezone: ${calendarEvent.idTimeZone}</label><br>
    <label>Description: ${calendarEvent.description}</label>
</body>
</html>
