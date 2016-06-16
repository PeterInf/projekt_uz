(function($){
    $(document).ready(function(){
        $('ul.dropdown-menu [data-toggle=dropdown]').on('click', function(event) {
            event.preventDefault();
            event.stopPropagation();
            $(this).parent().siblings().removeClass('open');
            $(this).parent().toggleClass('open');
        });

        $("body").on("click", "#export-button", function(){
            window.location.href = 'generate/' + $("#export-select").val();
        });
    });
})(jQuery);
