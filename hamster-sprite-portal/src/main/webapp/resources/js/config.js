requirejs.config({
  paths : {
    angular : 'libs/node_modules/angular/angular',
    backbone : 'libs/node_modules/backbone/backbone',
    bootstrap : 'libs/node_modules/bootstrap/dist/js/bootstrap',
    jquery : 'libs/node_modules/jquery/dist/jquery',
    underscore : 'libs/node_modules/underscore/underscore',
    moment : 'libs/node_modules/moment/moment',
  },
  shim : {
    backbone : {
      deps : [ 'jquery', 'underscore' ],
      exports : 'Backbone'
    }
  }
});

define([ 'backbone', 'jquery', 'moment', 'underscore' ], function(backbone, $, moment, _) {
  // expose to global variables for ease to use
  window.$ = $;
  window._ = _;
});