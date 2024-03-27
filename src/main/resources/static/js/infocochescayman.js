var selectedColor = null;
var selectedLlanta = null;

function changeImage(buttonId) {
    var image = document.getElementById('myImage');
    var imageUrl = '';
    var nombreColor = '';
    var nombreLlanta = '';

    switch (buttonId) {
        case 'white':
            imageUrl = '/img/BaseCay.jpg';
            nombreColor = 'Blanco';
            break;
        case 'red':
            imageUrl = '/img/RojoCay.jpg';
            nombreColor = 'Rojo Guardia';
            break;
        case 'green':
            imageUrl = '/img/VerdeCay.jpg';
            nombreColor = 'Verde Aventurine Metalizado';
            break;
        case 'blue':
            imageUrl = '/img/AzulCay.jpg';
            nombreColor = 'Azul Gentian Metalizado';
            break;
        case 'black':
            imageUrl = '/img/NegroCay.jpg';
            nombreColor = 'Negro Metalizadio';
            break;
        case 'rin-normal':
            imageUrl = '/img/RinBaseCay.jpg';
            nombreLlanta = 'Cayman basico';
            break;
        case 'rin-lujo':
            imageUrl = '/img/RinDeLujoCay.jpg';
            nombreLlanta = '911 Lux';
            break;
        default:
            imageUrl = '/img/BaseCay.jpg'; // Imagen predeterminada
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
        var sumaTotal = 75000.00 + precioColor + precioLlanta;

        // Mostrar la suma total en el HTML
        document.getElementById('sumaTotal').textContent = `Precio Total = ${sumaTotal}`;
    }
}
