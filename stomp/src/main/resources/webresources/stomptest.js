// Stomp via SockJS
jQuery(document).ready(function() {

	WebSocketStompMock = SockJS;
	client = Stomp.client('http://' + window.location.hostname + ':55674/stomp');
	client.debug = function(x) { console.debug(x); };

	client.connect('guest', 'guest', function(x) {
		client.subscribe("/topic/notify", function(d) {
			$('#notify-container').notify('create', JSON.parse(d.body));
		});

		client.subscribe("/topic/main.menu", function(d) {
		});
	
		client.subscribe("/topic/product_category", function(d) {
			var message = JSON.parse(d.body);
			console.debug('product_category push', message);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				productCategories.add(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionUpdate') {
				productCategories.get(message.entryId).set(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				productCategories.remove(message.entryId);
			}
		});
		
		client.subscribe("/topic/product", function(d) {
			var message = JSON.parse(d.body);
			console.debug('product push', message);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				featuredProducts.add(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionUpdate') {
				featuredProducts.get(message.entryId).set(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				featuredProducts.remove(message.entryId);
			}
		});
		
	});

});
