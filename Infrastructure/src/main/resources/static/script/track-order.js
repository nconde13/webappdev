document.addEventListener('DOMContentLoaded', function() {
    function generateDeliveryTime() {
        return Math.floor(Math.random() * (30 - 5 + 1)) + 5; 
    }

    function updateTimer() {
        var deliveryTime = generateDeliveryTime();
        var timerElement = document.getElementById('delivery-timer');
        timerElement.textContent = 'Time Remaining: ' + deliveryTime + ' minutes';

        sendDeliveryTime(deliveryTime);
    }

    function sendDeliveryTime(deliveryTime) {
        var xhr = new XMLHttpRequest();
        xhr.open('PUT', '/api/trackings/1/updateDeliveryTime', true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                console.log('Delivery time updated successfully!');
            }
        };

        var data = {
            deliveryTime: deliveryTime,
            orderStatus: 'Pending' 
        };

        xhr.send(JSON.stringify(data));
    }

    function markOrderReceived() {
        var xhr = new XMLHttpRequest();
        xhr.open('PUT', '/api/trackings/1/markReceived', true); 
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    console.log('Order status updated successfully!');
                } else {
                    console.error('Failed to update order status.');
                }
            }
        };
        xhr.send();
    }

    function cancelOrder() {
        var xhr = new XMLHttpRequest();
        xhr.open('PUT', '/api/trackings/1/cancelOrder', true); 
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    console.log('Order cancelled successfully!');
                } else {
                    console.error('Failed to cancel order.');
                }
            }
        };
        xhr.send();
    }

    updateTimer();

    setInterval(updateTimer, 60000); 
});
