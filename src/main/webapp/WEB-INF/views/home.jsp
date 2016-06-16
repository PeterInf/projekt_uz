<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
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
                    <p>Dozwolone formaty: .ics, .xml, .csv</p>
                    <input type="file" name="file"><br>
                    <button class="btn btn-primary" type="submit" data-toggle="modal" data-target="#file-import-modal">Import</button>
                </fieldset>
            </form:form>

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
        </div>
        <div class="col-md-9">
            <div id="calendar"></div>
            <div class="row">
                <h3>Eksport do pliku</h3>
                <form class="form-inline">
                    <fieldset>
                        <label>Wybierz format do eksportu:</label>
                        <select id="export-select" class="form-control">
                            <option value="csv">CSV</option>
                            <option value="ics">ICS</option>
                        </select>
                        <a role="button" id="export-button" class="btn btn-primary">Eksportuj</a>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
