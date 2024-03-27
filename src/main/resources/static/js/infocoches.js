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

    // Verificar si se ha seleccionado tanto un color como una llanta
    if (selectedColor !== null && selectedLlanta !== null) {
        // Realizar una solicitud AJAX para obtener el precio total
        fetch(`/getPrecio?nombreColor=${selectedColor}&nombreLlanta=${selectedLlanta}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al obtener el precio');
                }
                return response.text();
            })
            .then(data => {
                // Manejar la respuesta recibida
                console.log(data); // Aquí puedes hacer lo que necesites con la respuesta, como mostrarla en la interfaz de usuario
            })
            .catch(error => {
                console.error('Error:', error);
            });

        // Reiniciar la selección de color y llanta
        selectedColor = null;
        selectedLlanta = null;
    }
}
