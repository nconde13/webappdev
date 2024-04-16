function redirectToOrder(itemName) {
    // Redirect to place-order.html with item name as query parameter
    window.location.href = `place-order.html?item=${encodeURIComponent(itemName)}`;
}

window.onload = function() {
    // Retrieve item name from query parameter
    const params = new URLSearchParams(window.location.search);
    const itemName = params.get('item');

    // Set item details on the page
    const itemImage = document.getElementById('ordered-item-image');
    const itemNameElement = document.getElementById('ordered-item-name');
    const itemPriceElement = document.getElementById('ordered-item-price');

    itemImage.src = `../static/images/food/${itemName.toLowerCase().replace(' ', '_')}.png`;
    itemNameElement.textContent = itemName;
    
    // Assuming you have a mapping of item names to prices
    const itemPrices = {
        'Big Mac Combo': '$13.49',
        'Caramel Frappe': '$2.99'
    };
    
    itemPriceElement.textContent = itemPrices[itemName];
}

function placeOrder() {
    // Handle placing the order logic
    alert('Order placed successfully!');
}
