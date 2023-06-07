// when the user inputs the search term, the function is called
// get the  value of the input and serch on all the options.value if it matches replace the fist option and give it selected


function search(stype,selectedType) {
    let input, filter, a, i, txtValue;
    input = document.getElementById(stype);
    filter = input.value.toUpperCase();
    div = document.getElementById(selectedType);
    a = div.getElementsByTagName('option');
    for (i = 1; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].selected = true;

        } else {
            a[0].value = filter+" n'existe pas";
            a[0].text = filter+" n'existe pas";
            a[0].selected = true;
        }
    }
}

document.getElementById('searchEtudiant').addEventListener('keyup', function() {
    search('searchEtudiant', 'etudiantsSelect');
});

document.getElementById('searchEnseignant').addEventListener('keyup', function() {
    search('searchEnseignant', 'enseignantsSelect');
});

document.getElementById('searchCadreAdministrateur').addEventListener('keyup', function() {
    search('searchCadreAdministrateur', 'cadreAdministrateursSelect');
});

function showToSelect() {
    let type = document.getElementById('choseAccountType').value;
    console.log(type);
    switch (type) {
        case 'Etudiant':
            document.getElementById('Type_Etudiant').style.display = 'block';
            document.getElementById('Type_Ensignant').style.display = 'none';
            document.getElementById('Type_Cadre_Administrateur').style.display = 'none';
            break;
        case 'Enseignant':
            document.getElementById('Type_Etudiant').style.display = 'none';
            document.getElementById('Type_Ensignant').style.display = 'block';
            document.getElementById('Type_Cadre_Administrateur').style.display = 'none';
            break;
        case 'CadreAdministrateur':
            document.getElementById('Type_Etudiant').style.display = 'none';
            document.getElementById('Type_Ensignant').style.display = 'none';
            document.getElementById('Type_Cadre_Administrateur').style.display = 'block';
            break;
    }
}
document.getElementById('choseAccountType').addEventListener('input', showToSelect);
document.getElementById('Type_Etudiant').style.display = 'block';
document.getElementById('Type_Ensignant').style.display = 'none';
document.getElementById('Type_Cadre_Administrateur').style.display = 'none';