/*
 *
 * Date.addLocale(<code>) adds this locale to Sugar.
 * To set the locale globally, simply call:
 *
 * Date.setLocale('id');
 *
 * var locale = Date.getLocale(<code>) will return this object, which
 * can be tweaked to change the behavior of parsing/formatting in the locales.
 *
 * locale.addFormat adds a date format (see this file for examples).
 * Special tokens in the date format will be parsed out into regex tokens:
 *
 * {0} is a reference to an entry in locale.optionals. Output: (?:the)?
 * {unit} is a reference to all units. Output: (day|week|month|...)
 * {unit3} is a reference to a specific unit. Output: (hour)
 * {unit3-5} is a reference to a subset of the units array. Output: (hour|day|week)
 * {unit?} "?" makes that token optional. Output: (day|week|month)?
 *
 * {day} Any reference to tokens in the modifiers array will include all with the same name. Output: (yesterday|today|tomorrow)
 *
 * All spaces are optional and will be converted to "\s*"
 *
 * Locale arrays months, weekdays, units, numbers, as well as the "src" field for
 * all entries in the modifiers array follow a special format indicated by a colon:
 *
 * minute:|s  = minute|minutes
 * thicke:n|r = thicken|thicker
 *
 * Additionally in the months, weekdays, units, and numbers array these will be added at indexes that are multiples
 * of the relevant number for retrieval. For example having "sunday:|s" in the units array will result in:
 *
 * units: ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sundays']
 *
 * When matched, the index will be found using:
 *
 * units.indexOf(match) % 7;
 *
 * Resulting in the correct index with any number of alternates for that entry.
 *
 */

Date.addLocale('id', {
    'plural':     false,
    'timeMarker': 'pada',
    'ampm':       'AM,PM',
    'months':     'Januari,Februari,Maret,April,Mei,Juni,Juli,Agustus,September,Oktober,November,Desember',
    'weekdays':   'Minggu,Senin,Selasa,Rabu,Kamis,Jumat,Sabtu',
    'units':      'milidetik:|,detik:|,menit:|,jam:|,hari:|,minggu:|,bulan:|,tahun:|',
    'numbers':    'satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,sepuluh',
    'articles':   'sebuah,sebuah,sebuah',
    'optionals':  ',|||,dari',
    'short':      '{d} {Month} {yyyy}',
    'long':       '{d} {Month} {yyyy} {HH}.{mm}',
    'full':       '{Weekday} {d} {Month} {yyyy} {HH}.{mm}.{ss}',
    'past':       '{num} {unit} {sign}',
    'future':     '{num} {unit} {sign}',
    'duration':   '{num} {unit}',
    'modifiers': [
      { 'name': 'day',   'src': 'kemarin', 'value': -1 },
      { 'name': 'day',   'src': 'hari ini', 'value': 0 },
      { 'name': 'day',   'src': 'besok', 'value': 1 },
      { 'name': 'sign',  'src': 'lalu|lalu', 'value': -1 },
      { 'name': 'sign',  'src': 'dari sekarang|setelah|dari|dalam', 'value': 1 },
      { 'name': 'edge',  'src': 'last day', 'value': -2 },
      { 'name': 'edge',  'src': 'end', 'value': -1 },
      { 'name': 'edge',  'src': 'first day|beginning', 'value': 1 },
      { 'name': 'shift', 'src': 'last', 'value': -1 },
      { 'name': 'shift', 'src': 'the|this', 'value': 0 },
      { 'name': 'shift', 'src': 'next', 'value': 1 }
    ],
    'dateParse': [
      '{num} {unit} {sign}',
      '{sign} {num} {unit}',
      '{num} {unit=4-5} {sign} {day}',
      '{month} {year}',
      '{shift} {unit=5-7}',
      '{0} {edge} of {shift?} {unit=4-7?}{month?}{year?}'
    ],
    'timeParse': [
      '{0} {num}{1} {day} of {month} {year?}',
      '{weekday?} {month} {date}{1} {year?}',
      '{date} {month} {year}',
      '{shift} {weekday}',
      '{shift} week {weekday}',
      '{weekday} {2} {shift} week',
      '{0} {date}{1} of {month}',
      '{0}{month?} {date?}{1} of {shift} {unit=6-7}'
    ]
  });
