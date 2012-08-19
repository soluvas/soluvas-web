define(['sugar', 'sugar_id'],
		function(sugar, sugar_id) {

// 1. Locale defaults (TODO: should be global)
Date.setLocale('id');

var PrefLocale = {
	formatMoney: function(currencyCode, amount) {
		var doubleAmount = typeof(amount) == 'string' ? amount.toNumber() : amount;
		return currencyCode + ' ' + doubleAmount.format(0, '.', ',');
	},
	formatUnit: function(measurementUnit, amount) {
		var unitStr = '';
		switch (measurementUnit) {
		case 'piece':
			unitStr = amount >= 2 ? 'pcs' : 'pc';
			break;
		}
		return amount + ' ' + unitStr;
	}
}

return PrefLocale;

});
