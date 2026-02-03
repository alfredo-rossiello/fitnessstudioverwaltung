const startSeite = 'FitnessStudio-Startseite.html';

const weiter_button_1 = document.getElementById('Registrierung_weiter_1');
const weiter_button_2 = document.getElementById('Registrierung_weiter_2');
const weiter_button_3 = document.getElementById('Registrierung_weiter_3');

const formular_1 = document.getElementById('Registrierung_Formular_1');
const formular_2 = document.getElementById('Registrierung_Formular_2');
const formular_3 = document.getElementById('Registrierung_Formular_3');


const container1 = document.getElementById('Registrierung_Formular_1_Container');
const container2 = document.getElementById('Registrierung_Formular_2_Container');
const container3 = document.getElementById('Registrierung_Formular_3_Container');



weiter_button_1.addEventListener('click', (event) => {
        // Verhindert, dass das Formular abgeschickt wird
        event.preventDefault();

        // Prüft ob alle Pflichtfelder ausgefüllt worden sind
        if (formular_1.checkValidity()) {
            container1.style.display = 'none';  // Container 1 wird ausgeblendet
            container2.style.display = 'block'; // Container 2 wird angezeigt
        } else{
            formular_1.reportValidity("Unbekannter Fehler"); // Fehlermeldungen anzeigen
        }
    }
);

// Vorgang wiederholt sich wie davor nur diesmal mit dem 2ten Formular
weiter_button_2.addEventListener('click', (event) =>{
    event.preventDefault();

    if(formular_2.checkValidity()){
        container2.style.display = "none";
        container3.style.display = "block";
    } else{
        formular_2.reportValidity();
    }
});


// Gleicher Vorgang nur diesmal wird die Registrierung beendet und man landet wieder auf der Startseite
weiter_button_3.addEventListener('click', (event) =>{
    event.preventDefault();

    if(formular_3.checkValidity()){
        container3.style.display = "none";
        alert("Registrierung erfolgreich!");
        window.location.href = startSeite;
    } else{
        formular_2.reportValidity();
    }
});



