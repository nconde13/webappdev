document.addEventListener('DOMContentLoaded', function() {
    const searchBar = document.querySelector('.search-bar');
    const restaurantList = document.querySelector('.restaurant-list');

    // Mock data for restaurants (replace with actual data fetched from the database)
    const restaurants = [
        'barBURRITO',
        'Amaya Express Bramalea City Center',
        'Mandarin Restaurant',
        'East Side Mario\'s',
        'KIBO Sushi House - Humber',
        'Osmow\'s Shawarma',
        'McDonald\'s',
        'Jimmy the Greek',
        'Tim Hortons',
        'Subway'
    ];

    // Function to update the restaurant list based on search input
    function updateRestaurantList(input) {
        const filteredRestaurants = restaurants.filter(restaurant => restaurant.toLowerCase().includes(input.toLowerCase()));
        const sortedRestaurants = filteredRestaurants.sort((a, b) => a.toLowerCase().indexOf(input.toLowerCase()) - b.toLowerCase().indexOf(input.toLowerCase()));

        // Clear previous list
        restaurantList.innerHTML = '';

        // Populate the restaurant list
        sortedRestaurants.forEach(restaurant => {
            const listItem = document.createElement('li');
            listItem.textContent = restaurant;
            listItem.style.color = 'black'; // Set font color to black
            listItem.style.cursor = 'pointer'; // Set cursor to pointer
            listItem.addEventListener('click', function() {
                window.location.href = restaurant.toLowerCase().replace(/ /g, '-') + '.html'; // Redirect to restaurant page
            });
            restaurantList.appendChild(listItem);
        });
    }

    // Event listener for search input changes
    searchBar.addEventListener('input', function(event) {
        const searchInput = event.target.value.trim();
        updateRestaurantList(searchInput);
    });

    // Initial update of restaurant list
    updateRestaurantList('');
});
