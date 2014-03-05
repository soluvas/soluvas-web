var barcodesScanFailed = new Array();
		function doDelete(id) {
			barcodesScanFailed.splice(jQuery.inArray(id, barcodesScanFailed),1);
			jQuery("#delete_"+id).remove();
			return false;
		}
		
		jQuery('document').ready(function(){
// 			jQuery("#barcodeScanner").attr("disabled", "disabled");
// 			if (jQuery(".salesLineData").length) {
// 				jQuery("#barcodeScanner").removeAttr("disabled");
// 			}
			
			var totalScan = Number(0);
			jQuery("#barcodeScanner").on("keydown", function(event){
				var id = jQuery(this).val();
				if (id.length >= 11) {
					alert("Barcode tidak valid");
					return false;
				}
				if (id.length > 8) id = id.substr(0,8);
				console.log(id);
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if(keycode == '13') {
					if (jQuery("#"+id).length) {
						console.log("component have been founded");
						updateAmountOfScan(id);
						jQuery(this).val("");
					} else {
						console.log("component have not been founded");
						var barcodeIdx = jQuery.inArray(id, barcodesScanFailed); 
						if ( barcodeIdx == -1) {
							var amountArr = barcodesScanFailed.length;
							barcodesScanFailed[amountArr] = id;
							var scanFailed = "<li style=\"font-color : red;\" id=\"delete_"+ id +"\">"+ id +" - <a href=\"#\" onClick=\"doDelete('"+id+"')\">delete</a></li>";
							jQuery("#scanFailed").append(scanFailed);
						} 
						console.debug(barcodesScanFailed);
						jQuery("#barcodeScannerContainer").attr("class", "control-group error");
					}
					return false;
				}				
			});
			
			jQuery("#barcodeScanner").on("input", function(){
				var id = jQuery(this).val();
				if (id.length >= 11) {
					jQuery(".icon-remove").show();
					jQuery(".icon-ok").hide();
					jQuery("#barcodeScannerContainer").attr("class", "control-group error");
					return;
				}  
				if (id.length > 8) id = id.substr(0,8);
				
				if (isExist(id)) {
					jQuery(".icon-ok").show();
					jQuery(".icon-remove").hide();
					jQuery("#barcodeScannerContainer").attr("class", "control-group");
				} else {
					jQuery(".icon-ok").hide();
					jQuery(".icon-remove").show();
// 					jQuery("#barcodeScannerContainer").attr("class", "control-group error");
				}
			});
			
			function updateAmountOfScan(id) {
				var amountScan = jQuery("#"+id).attr("data-amount-scan");	
				var amountSalesQty = jQuery("#amountQty_"+id).attr("data-sales-qty");
				console.debug("amountScan "+ amountScan + " amountSalesQty "+ amountSalesQty);
				if (Number(amountScan) < Number(amountSalesQty)) {
					amountScan = Number(amountScan) + 1;
					totalScan += Number(amountScan);
				
					jQuery("#"+id).attr("data-amount-scan", amountScan).attr("class", "badge badge-info");
					jQuery("#"+id).text(amountScan);
					jQuery("#amountScaned").text(totalScan).attr("class", "badge badge-success");
				} else {
					alert("Jumlah scan melebihi salesQty");
				}
			}
			
			function isExist(id) {
				return jQuery("#"+id).length;
			}
		});