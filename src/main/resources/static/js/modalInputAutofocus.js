const exampleModal = document.getElementById('registerModal');
  exampleModal.addEventListener('shown.bs.modal', function () {
    const inputField = document.getElementById('reg_username');
    inputField.focus();
 });