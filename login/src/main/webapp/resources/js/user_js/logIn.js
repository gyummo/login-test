document.getElementById('loginButton').addEventListener('click', function() {
    const userId = document.getElementById('userId').value;
    const userPwd = document.getElementById('userPwd').value;
    const data = {
        userId: userId,
        userPwd: userPwd
    };

    fetch('loginFetch.u', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            document.getElementById('message').className = 'success-msg';
            document.getElementById('message').textContent = '로그인 성공';
        } else {
            document.getElementById('message').className = 'error-msg';
            document.getElementById('message').textContent = '로그인 실패';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('message').className = 'error-msg';
        document.getElementById('message').textContent = '서버 오류';
    });
});
