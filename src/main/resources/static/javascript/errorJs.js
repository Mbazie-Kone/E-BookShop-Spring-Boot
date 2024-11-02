document.addEventListener('DOMContentLoaded', function () {
        if (document.querySelector('.modal.show')) {
            new bootstrap.Modal(document.getElementById('registrationModal')).show();
        }
    });