window.onload=()=>{
    $(document).ready(function() {
        $('.card').click(function() {
            var titulo = $(this).find('h2').text();
            // Enviar el título al controlador mediante una petición AJAX
            $.ajax({
                type: 'POST',
                url: 'cochescontroller',
                contentType: 'text/plain', // Especifica el tipo de contenido como texto plano
                data: titulo,
                success: function(response) {
                    // Redirigir a la página deseada (suponiendo que 'response' contiene la URL)
                    window.location.href = response;
                },
                error: function() {
                    alert('Error al enviar el título al controlador.');
                }
            });
        });
    });

}