var selectedColor = null;
var selectedLlanta = null;

function changeImage(buttonId) {
    var image = document.getElementById('myImage');
    var imageUrl = '';
    var nombreColor = '';
    var nombreLlanta = '';

    switch (buttonId) {
        case 'white':
            imageUrl = '/img/BaseBox.jpg';
            nombreColor = 'Blanco';
            break;
        case 'red':
            imageUrl = '/img/RojoBox.jpg';
            nombreColor = 'Rojo Guardia';
            break;
        case 'green':
            imageUrl = '/img/VerdeBox.jpg';
            nombreColor = 'Verde Aventurine Metalizado';
            break;
        case 'blue':
            imageUrl = '/img/AzulBox.jpg';
            nombreColor = 'Azul Gentian Metalizado';
            break;
        case 'black':
            imageUrl = '/img/NegroBox.jpg';
            nombreColor = 'Negro Metalizadio';
            break;
        case 'rin-normal':
            imageUrl = '/img/RinBaseBox.jpg';
            nombreLlanta = 'Cayman basico';
            break;
        case 'rin-lujo':
            imageUrl = '/img/RinDeLujoBox.jpg';
            nombreLlanta = '911 Lux';
            break;
        default:
            imageUrl = '/img/Basebox.jpg'; // Imagen predeterminada
            break;
    }

    if (nombreColor !== '') {
        selectedColor = nombreColor;
    }

    if (nombreLlanta !== '') {
        selectedLlanta = nombreLlanta;
    }

    // Cambiar el src de la imagen
    image.src = imageUrl;

    // Realizar las solicitudes fetch para obtener los precios del color y de la llanta
    Promise.all([
        fetch(`/getPrecioColor?nombreColor=${selectedColor?selectedColor:"Blanco"}`).then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener el precio del color');
            }
            return response.text();
        }),
        fetch(`/getPrecioLlanta?nombreLlanta=${selectedLlanta?selectedLlanta:"Cayman basico"}`).then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener el precio de la llanta');
            }
            return response.text();
        })
    ])
        .then(([precioColor, precioLlanta]) => {
            // Convertir los precios a números
            const precioColorNum = parseFloat(precioColor);
            const precioLlantaNum = parseFloat(precioLlanta);

            // Verificar si ambos precios son válidos
            if (!isNaN(precioColorNum) && !isNaN(precioLlantaNum)) {
                // Mostrar los precios en el HTML
                document.getElementById('precioColor').textContent = `Precio Color = ${precioColor}`;
                document.getElementById('precioLlanta').textContent = `Precio Rin = ${precioLlanta}`;

                // Calcular y mostrar la suma total
                calcularSumaTotal(precioColorNum, precioLlantaNum);
            } else {
                // Mostrar un mensaje de error si alguno de los precios no es válido
                document.getElementById('sumaTotal').textContent = "Precio Total = Error: Al menos uno de los precios no es válido";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });

    function calcularSumaTotal(precioColor, precioLlanta) {
        // Realizar la suma aritmética
        var sumaTotal = 77500.00 + precioColor + precioLlanta;

        // Mostrar la suma total en el HTML
        document.getElementById('sumaTotal').textContent = `Precio Total = ${sumaTotal}`;
    }
}
 $(document).ready(function() {
    // Hacer la solicitud AJAX al controlador para obtener la información adicional
    $.ajax({
        url: '/informacionAdicional', // La ruta del controlador
        method: 'GET',
        data: { modelo: '718 Boxster' }, // El modelo deseado
        success: function(data) {
            // Manipular los datos devueltos y mostrarlos en la página
            $('#informacion').html(`
                        <p>Pwmotor: ${data.pwmotor}</p>
                        <p>Velocidad Máxima: ${data.velocidadMax}</p>
                        <p>Cilindrada: ${data.cilindrara}</p>
                    `);
        },
        error: function(xhr, status, error) {
            // Manejar errores de la solicitud AJAX
            console.error('Error en la solicitud AJAX:', error);
        }
    });
});
