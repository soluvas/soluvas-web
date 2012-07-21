// Stomp via SockJS
jQuery(document).ready(function() {

	WebSocketStompMock = SockJS;
	client = Stomp.client('http://' + window.location.hostname + ':55674/stomp');
	client.debug = function(x) { console.debug(x); };
	
	// 1. Declare templates
	navbarMenuItemTemplate = ' \
		<a href="/<%= item.get("clientPath") %>"><i class="icon-<%- item.get("iconName") %> icon-white"></i> <%- item.get("label") %></a>'; 
	sidebarMenuItemTemplate = ' \
		<a href="/<%= item.get("clientPath") %>"><i class="icon-<%- item.get("iconName") %>"></i> <%- item.get("label") %></a>';
	processItemTemplate= '<span><i class="icon-<%- iconName %>"></i> <strong><a href="#"><%- name %></a></strong>. \
		<%- description %></span>';
	
	// 2. Declare Model & Collection classes
	MenuItem = Backbone.Model.extend({});
	MenuItemList = Backbone.Collection.extend({
		model: MenuItem,
		initialize: function() {
			_.bindAll(this);
		}
	});

	ProcessItem = Backbone.Model.extend({idAttribute: 'name'});
	ProcessItemList = Backbone.Collection.extend({
		model: ProcessItem,
		initialize: function() {
			_.bindAll(this);
		}
	});

	// 3. Declare View classes (for models & collections)
	NavbarMenuItemView = Backbone.View.extend({
		model: MenuItem,
		tagName: 'li',
		initialize: function() {
			_.bindAll(this);
			this.model.view = this; // code smell?
			this.model.on('remove', this.onRemove);
		},
		render: function() {
			this.$el.attr('id', 'navbar-item-' + this.model.id);
			this.$el.html(_.template(navbarMenuItemTemplate, {item: this.model}));
			return this;
		},
		onRemove: function(item, collection) {
			//this.$el.fadeOut('', this.remove);
			this.$el.css('height', this.$el.height() + 'px').css('overflow', 'hidden')
				.animate({width: 'hide', opacity: 'hide'}, this.remove);
		}
	});
	NavbarView = Backbone.View.extend({
		model: MenuItemList,
		initialize: function() {
			_.bindAll(this);
			this.model.on('reset', this.attachViews);
			this.model.on('add', this.addItemView);
		},
		attachViews: function() {
			this.model.each( function(item) {
				console.debug('attaching #navbar-item-', item.id);
				var view = new NavbarMenuItemView({model: item, el: $('#navbar-item-' + item.id)});
			});
		},
		addItemView: function(item, collection) {
			var view = new NavbarMenuItemView({model: item}).render();
			view.$el.hide();
			var newIndex = collection.indexOf(item);
			var nextItem = collection.at(newIndex + 1);
			if (nextItem == undefined) {
				this.$el.append(view.el);
			} else {
				nextItem.view.$el.before(view.el);
			}
			view.$el.fadeIn();
		},
	});
	
	SidebarMenuItemView = Backbone.View.extend({
		model: MenuItem,
		tagName: 'li',
		initialize: function() {
			_.bindAll(this);
			this.model.view = this; // code smell?
			this.model.on('remove', this.onRemove);
		},
		render: function() {
			this.$el.attr('id', 'sidebar-nav-item-' + this.model.id);
			this.$el.html(_.template(sidebarMenuItemTemplate, {item: this.model}));
			return this;
		},
		onRemove: function(item, collection) {
			this.$el.slideUp('', this.remove);
		}
	});
	SidebarNavView = Backbone.View.extend({
		model: MenuItemList,
		initialize: function() {
			_.bindAll(this);
			this.model.on('reset', this.attachViews);
			this.model.on('add', this.addItemView);
		},
		attachViews: function() {
			this.model.each( function(item) {
				console.debug('attaching #sidebar-nav-item-', item.id);
				var view = new SidebarMenuItemView({model: item, el: $('#sidebar-nav-item-' + item.id)});
			});
		},
		addItemView: function(item, collection) {
			var view = new SidebarMenuItemView({model: item}).render();
			view.$el.hide();
			var newIndex = collection.indexOf(item);
			var nextItem = collection.at(newIndex + 1);
			if (nextItem == undefined) {
				this.$el.append(view.el);
			} else {
				nextItem.view.$el.before(view.el);
			}
			view.$el.slideDown();
		},
	});

	ProcessItemView = Backbone.View.extend({
		model: ProcessItem,
		tagName: 'li',
		initialize: function() {
			_.bindAll(this);
			this.model.view = this; // code smell?
			this.model.on('remove', this.onRemove);
		},
		render: function() {
			this.$el.attr('id', 'process-item-' + this.model.id);
			this.$el.html(_.template(processItemTemplate, this.model.toJSON()));
			return this;
		},
		onRemove: function(item, collection) {
			this.$el.slideUp('', this.remove);
		}
	});
	ProcessListView = Backbone.View.extend({
		model: ProcessItemList,
		initialize: function() {
			_.bindAll(this);
			this.model.on('reset', this.attachViews);
			this.model.on('add', this.addItemView);
		},
		attachViews: function() {
			this.model.each( function(item) {
				console.debug('attaching #process-item-', item.id);
				var view = new ProcessItemView({model: item, el: $('#process-item-' + item.id)});
//				view.render();
			});
		},
		addItemView: function(item, collection) {
			var view = new ProcessItemView({model: item}).render();
			view.$el.hide();
			var newIndex = collection.indexOf(item);
			var nextItem = collection.at(newIndex + 1);
			if (nextItem == undefined) {
				this.$el.append(view.el);
			} else {
				nextItem.view.$el.before(view.el);
			}
			view.$el.slideDown('', function(){ $(this).css('display', 'list-item'); });
		},
	});

	// 4. Instantiate (empty) collections
	navbarMenuItems = new MenuItemList();
	sidebarMenuItems = new MenuItemList();
	processItems = new ProcessItemList();
	
	// 5. Instantiate Views for collections
	navbarView = new NavbarView({model: navbarMenuItems, el: $('.navbar .nav')});
	sidebarNavView = new SidebarNavView({model: sidebarMenuItems, el: $('.sidebar-nav .nav')});
	processListView = new ProcessListView({model: processItems, el: $('#process-list')});
	
	// 6. Reset collections and fill models with data
	// this must be AFTER the sidebarNavView is created
//	sidebarMenuItems.reset([{id: 'checkin', label: 'Checkin', 'iconName': 'check', 'clientPath': 'checkin/'},
//	                        {id: 'processList', label: 'Process List', 'iconName': 'cog', 'clientPath': 'process/'}]);

	client.connect('guest', 'guest', function(x) {
		client.subscribe("/topic/notify", function(d) {
			$('#notify-container').notify('create', JSON.parse(d.body));
		});

		client.subscribe("/topic/menu.main", function(d) {
			var message = JSON.parse(d.body);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				navbarMenuItems.add(message.entry, {at: message.position});
				sidebarMenuItems.add(message.entry, {at: message.position});
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				navbarMenuItems.remove(message.entryId);
				sidebarMenuItems.remove(message.entryId);
			}
		});
		
		client.subscribe("/topic/process", function(d) {
			var message = JSON.parse(d.body);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				processItems.add(message.entry, {at: message.position});
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				processItems.remove(message.entryId);
			}
		});
		
	});

});
