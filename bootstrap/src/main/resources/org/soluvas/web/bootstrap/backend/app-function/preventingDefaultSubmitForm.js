console.log("mencoba mencegah form submit default");
jQuery("document").on("keypress", 'form', function (e) {
	 console.log('ini dipanggil gak sih');
     var code = e.keyCode || e.which;
     if (code == 13) {
    	 alert("lier uy");
         e.preventDefault();
         return false;
     }
 });
