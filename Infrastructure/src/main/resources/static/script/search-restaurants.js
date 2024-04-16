document.addEventListener('DOMContentLoaded', function() {
    const searchBar = document.querySelector('.search-bar');
    const restaurantList = document.querySelector('.restaurant-list');

    function fetchRestaurants(input = '') {
        fetch('/api/restaurants')
            .then(response => response.json())
            .then(data => {
                console.log("Received raw restaurants:", data);
                updateRestaurantList(data, input);
            })
            .catch(error => {
                console.error('Error fetching restaurants:', error);
            });
    }

    function updateRestaurantList(restaurants, input = '') {
        console.log("Received restaurants for filtering:", restaurants); 

        const filteredRestaurants = restaurants.filter(restaurant => 
            restaurant.name.toLowerCase().includes(input.toLowerCase())
        );

        console.log("Filtered restaurants:", filteredRestaurants);

        restaurantList.innerHTML = '';

        filteredRestaurants.forEach(restaurant => {
            const listItem = document.createElement('li');
            listItem.textContent = restaurant.name;
            listItem.style.color = 'black';
            listItem.style.cursor = 'pointer';
            listItem.addEventListener('click', function() {
                window.location.href = `/${restaurant.name.toLowerCase().replace(/ /g, '-')}.html`;
            });                                    
            restaurantList.appendChild(listItem);
        });
    }    

    searchBar.addEventListener('input', function(event) {
        const searchInput = event.target.value.trim();
        fetchRestaurants(searchInput); 
    });

    fetchRestaurants();
});
