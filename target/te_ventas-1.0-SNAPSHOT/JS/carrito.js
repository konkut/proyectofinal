'use strict'

let numero = 0;
const contador = document.querySelector(".contador");
const boton1 = document.querySelector('#boton1');
boton1.addEventListener("click", (e) => {
    e.preventDefault();
    boton1.setAttribute("disabled", "true");
    numero = numero + 1;
    contador.textContent = numero;

});
const boton2 = document.querySelector('#boton2');
boton2.addEventListener("click", (e) => {
    e.preventDefault();
    boton2.setAttribute("disabled", "true");

    numero = numero + 1;
    contador.textContent = numero;


});
const boton3 = document.querySelector('#boton3');
boton3.addEventListener("click", (e) => {
    e.preventDefault();
    boton3.setAttribute("disabled", "true");
    numero = numero + 1;
    contador.textContent = numero;


});
const boton4 = document.querySelector('#boton4');
boton4.addEventListener("click", (e) => {
    e.preventDefault();
    boton4.setAttribute("disabled", "true");
    numero = numero + 1;
    contador.textContent = numero;


});
const boton5 = document.querySelector('#boton5');
boton5.addEventListener("click", (e) => {
    e.preventDefault();
    boton5.setAttribute("disabled", "true");
    numero = numero + 1;
    contador.textContent = numero;


});
const boton6 = document.querySelector('#boton6');
boton6.addEventListener("click", (e) => {
    e.preventDefault();
    boton6.setAttribute("disabled", "true");
    numero = numero + 1;
    contador.textContent = numero;


});




