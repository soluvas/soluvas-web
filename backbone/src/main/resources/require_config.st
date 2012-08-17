var require = {
    //By default load any module IDs from
    baseUrl: '/static',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
    paths: {
        //app: '../app'
    	jquery: 'jquery/jquery-1.7.2',
    	bootstrap: 'bootstrap/js',
    	underscore: 'backbone/underscore-1.3.3',
    	backbone: 'backbone/backbone-0.9.2',
    	sugar: 'backbone/sugar-1.3.min',
    	mustache: 'backbone/mustache-0.5.2',
    	'jquery.dataTables': 'jquery-ui/datatables/js/jquery.dataTables',
    	
    	sugar_id: 'backbone/sugar_id',

    	'app.locale': 'salesorder/js/app.locale',
    	
    	'salesorder.list': 'salesorder/js/salesorder.list',
    	salesorder: 'salesorder/js/salesorder',
    },
    shim: {
    	'underscore': {
    		exports: '_'
    	},
    	'backbone': {
    		deps: ['underscore', 'jquery'],
    		exports: 'Backbone'
    	},
    	'sugar': {
    		exports: 'Date',
    	},
    	'sugar_id': {
    		deps: ['sugar'],
    	},
    	'jquery.dataTables': {
	    	deps: ['jquery'],
		}
    }

};
