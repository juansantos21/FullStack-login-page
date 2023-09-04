document.getElementById('registro-form').addEventListener('submit', function (event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const registroData = {
        nome: nome,
        email: email,
        senha: senha
    };

    fetch('https://seuservidor.com/api/registrar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(registroData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Registro bem-sucedido!');
        } else {
            alert('Erro ao registrar: ' + data.message);
        }
    })
    .catch(error => {
        console.error('Erro na solicitação Fetch:', error);
    });
});
