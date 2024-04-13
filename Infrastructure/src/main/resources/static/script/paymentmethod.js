function selectPaymentOption(option) {
    const creditCardOption = document.getElementById('creditCardOption');
    const giftCardOption = document.getElementById('giftCardOption');

    if (option === 'creditCard') {
        creditCardOption.classList.add('selected');
        giftCardOption.classList.remove('selected');
    } else if (option === 'giftCard') {
        giftCardOption.classList.add('selected');
        creditCardOption.classList.remove('selected');
    }

    document.getElementById('continueButton').disabled = false;
}

function continueToCheckout() {
    const selectedPaymentOption = document.querySelector('.payment-option.selected');

    if (!selectedPaymentOption) {
        alert('Please select a payment option.');
        return;
    }

    const paymentType = selectedPaymentOption.id === 'creditCardOption' ? 'Debit/Credit Card' : 'Gift Card';

    sendPaymentType(paymentType);
}

function sendPaymentType(paymentType) {
    const orderId = 123; 

    const orderAmountElement = document.getElementById('orderAmount');
    const orderAmount = parseFloat(orderAmountElement.getAttribute('data-amount'));

    const data = {
        orderId: orderId,
        orderAmount: orderAmount,
        paymentType: paymentType
    };

    fetch('/api/payments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to send payment type.');
        }
        return response.json();
    })
    .then(data => {
        console.log('Payment type sent successfully:', data);
    })
    .catch(error => {
        console.error('Error sending payment type:', error);
    });
}

function goBackToIndex() {
    window.location.href = '/index.html';
}