<h1>Color picker app: [Reto individual Àlex Cassi de la Viuda]</h1>

Es una aplicacion para dispositivos Android que te permite generar una paleta de colores de manera totalmente aleatoria (en el caso de que introduzcas un espacio) o a partir
de un color que haya introducido el usuario de manera manual. En el caso de que el codigo de color hexadecimal que el usuario haya introducido sea invalido (como por ejemplo
" # abcdef ", que es un color que no existe), la aplicacion lanzara un mensaje de error.

La app esta creada con Java y Android Studio. Cada cuadrado es un linearLayout con weight 1 (estan todos dentro de un LinearLayout con orientacion vertical) para que ocupen 
lo mismo en la pantalla sea la pantalla que sea. No tiene ningun boton, sino que el Edit Text que sirve como input tiene un listener que autodetecta cuando un color valido es
introducido.

<h1>Capturas de pantalla</h1>

[!Funcionamiento normal](func_normal.jpg) /
[!Introduciendo un espacio](espacio.jpg) /
[!Con un color invalido](color_invalido.jpg)

<h1>Desarrollo:</h1>

Primero visualizé el diseño basico y puse cada elemento en su sitio:

[!Diseño basico](diseno.jpg)

Después (siempre empiezo haciendo el diseño de la aplicacion, y una vez lo tengo acabado me centro en la programacion) , me hice un pequeño esquema mental de las funciones 
que necesitaba para llevar a cabo lo que me pedian, separando cada parte en su funcion:

[!Esquema visual representativo](esquema.jpg)

Una vez tenia la parte de la programacion hecha y me habia asegurado de que la app funcionaba como debia, la subí al repositiorio con git bash.

