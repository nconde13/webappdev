document.addEventListener('DOMContentLoaded', function() {
    var loginType = document.getElementById('loginType');
    var urlParams = new URLSearchParams(window.location.search);
    var type = urlParams.get('type');

    if (type === 'admin') {
        loginType.textContent = 'Admin Login';
        document.getElementById('student-link').style.display = 'block';
    } else {
        loginType.textContent = 'Student Login';
        document.getElementById('admin-link').style.display = 'block';
    }
    
    // Redirect to home page after login
    if (window.location.pathname === '/login') {
        window.location.href = '/home-page.html';
    }
});
