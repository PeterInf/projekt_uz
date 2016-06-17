<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value="/"/>" role="button" class="btn btn-default"><span class="glyphicon glyphicon-circle-arrow-left"></span> Powrót do kalendarza</a>
            <a href="<c:url value="/removeEvent/${calendarEvent.id}"/>" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Usuń wydarzenie</a>
            <h2><span class="glyphicon glyphicon-star"></span> Wpis z kalendarza</h2>
            <ul class="list-group">
                <li class="list-group-item"><span class="glyphicon glyphicon-flag"></span> <strong>Nazwa wydarzenia:</strong> ${calendarEvent.title}</li>
                <li class="list-group-item"><span class="glyphicon glyphicon-calendar"></span> <strong>Data rozpoczęcia:</strong>  ${calendarEvent.startDate.toString("yyyy-MM-dd HH:mm:ss")}</li>
                <li class="list-group-item"><span class="glyphicon glyphicon-calendar"></span> <strong>Data zakończenia:</strong>  ${calendarEvent.endDate.toString("yyyy-MM-dd HH:mm:ss")}</li>
                <li class="list-group-item"><span class="glyphicon glyphicon-map-marker"></span> <strong>Strefa czasowa:</strong>  ${calendarEvent.timeZone.getDisplayName(false, 0)}</li>
                <li class="list-group-item"><span class="glyphicon glyphicon-pencil"></span> <strong>Opis:</strong>  ${calendarEvent.description}</li>
                <li class="list-group-item"><span class="glyphicon glyphicon-tag"> </span><strong>Tagi:</strong>  ${calendarEvent.tag}</li>
            </ul>
        </div>
    </div>
</div>

