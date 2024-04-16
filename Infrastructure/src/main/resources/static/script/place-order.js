document.addEventListener('DOMContentLoaded', function() {
    const selectedItemName = sessionStorage.getItem('selectedItemName');
    const selectedItemPrice = sessionStorage.getItem('selectedItemPrice');
    const selectedItemImage = sessionStorage.getItem('selectedItemImage');

    document.getElementById('selected-item-image').src = selectedItemImage;
    document.getElementById('selected-item-name').textContent = selectedItemName;
    document.getElementById('selected-item-price').textContent = `$${selectedItemPrice}`;

    sessionStorage.setItem('selectedItemName', selectedItemName);
    sessionStorage.setItem('selectedItemPrice', selectedItemPrice);
    sessionStorage.setItem('selectedItemImage', selectedItemImage);
});

function placeOrder() {
    const paymentMethod = document.querySelector('input[name="paymentMethod"]:checked').value;
    const selectedItemName = sessionStorage.getItem('selectedItemName');
    const selectedItemPrice = sessionStorage.getItem('selectedItemPrice');
    
    alert(`You selected ${paymentMethod}. Proceeding with payment for ${selectedItemName} at $${selectedItemPrice}.`);

    sessionStorage.removeItem('selectedItemName');
    sessionStorage.removeItem('selectedItemPrice');
    sessionStorage.removeItem('selectedItemImage');

}
