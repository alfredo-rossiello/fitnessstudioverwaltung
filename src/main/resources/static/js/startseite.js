//Kurwa klappt einfach nicht

const bildAnzeigeWechsel = document.querySelectorAll('.slides img');
let durchgang = 0;

function NaechstesBild(){
    bildAnzeigeWechsel[durchgang].classList.remove('active');
    durchgang = (durchgang + 1) % bildAnzeigeWechsel.length;
    bildAnzeigeWechsel[durchgang].classList.add('active');
} setInterval(NaechstesBild, 8000);