# GuessNumberFragment
Este proyecto se trata de un juego codificado en java, pensado para usarse como aplicación Android en dispositivos móviles en la cual muestra debemos adivinar un número del 1 al 100 en el núemero de intentos que nosotros veamos oportuno.

## Features
* **DataBinding** - *Enlace de la vista con los datos*
* **ViewBinding** - *Enlace de la vista con el código*
* **SaveInstanceState** 

Antes de girar la pantalla la respuesta que previamente ha seleccionado
ha de ser guardada para que se mantenga la respuesta del usuario aunque
la actividad se elimine y se reanude. Para ello se utiliza el método
`onSaveInstanceState` que recibe por parámetro un objeto Bundle donde se
guardará toda la información: 

``` java
   @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("answerPosition", adapter.answerPosition);

    }
```
* **AboutUs** - *En un menu, nos permite ver la información del creador de la aplicación*
* **Uso de fragments** - *Se usa un componente navigation para moverse a traves de los fragments*
* **Uso de la interfaz MenuHost y MenuProvider** - *Se usa estas interfaces debido a que android ha ajustado su API recientmente*
* **App internacionalizada** - *Disponible en ingles y español*

## Output
![IMG_20221030_184811](https://user-images.githubusercontent.com/114143275/198893474-d13cbdd5-cc38-439b-8a55-b2029c1f8e1e.jpg)
![IMG_20221030_184837](https://user-images.githubusercontent.com/114143275/198893480-c408bd33-d012-4dfb-9525-15272f841584.jpg)
![IMG_20221030_184855](https://user-images.githubusercontent.com/114143275/198893495-1996cf5d-5738-4a1e-8b99-beff00bfa87f.jpg)
![IMG_20221030_184914](https://user-images.githubusercontent.com/114143275/198893503-2987a579-0ed5-4123-8f8d-c534b3b6dcd6.jpg)

## Comenzando 🚀
### Pre-requisitos 📋

```
Tener un disposivo móvil físico o virtual al que instalar esta aplicación
(Opcional)Disponer de Android Studio para probar la aplicación en mejor medida.
```

### Instalación 🔧

```
Asociar el dispositivo móvil al PC
Instalar el fichero apk en dicho dispositivo
```
## Construido con 🛠️


* [Android Studio](https://developer.android.com/studio?hl=es&gclid=Cj0KCQjwsrWZBhC4ARIsAGGUJurGAdx-oPvuyAU9ddQ2TA83jo1hjQ6ikda6c51NJQlYTCQwH56ulDMaAtcxEALw_wcB&gclsrc=aw.ds) - El SDK + IDE usado

## Autores ✒️

* **Fernando Escaño Martín** - *Trabajo Inicial*
* **Fernando Escaño Martín** - *Documentación*

## Licencia 📄

