<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr>

<footer>
    <p>&copy; ProjectUZ 2016</p>
</footer>

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
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>