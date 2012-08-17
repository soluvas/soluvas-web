requirejs.config({
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
    }
});

// Start the main app logic.
//requirejs(['jquery', 'canvas', 'app/sub'],
//function   ($,        canvas,   sub) {
//    //jQuery, canvas and the app/sub module are all
//    //loaded and can be used here now.
//});

requirejs(['jquery'],
		function($) {
			alert('woy');
		    //jQuery, canvas and the app/sub module are all
		    //loaded and can be used here now.
		});
