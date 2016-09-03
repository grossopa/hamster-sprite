requirejs.config({
  paths : {
    angular : 'libs/node_modules/angular/angular',
    backbone : 'libs/node_modules/backbone/backbone',
    bootstrap : 'libs/node_modules/bootstrap/dist/js/bootstrap',
    jquery : 'libs/node_modules/jquery/dist/jquery',
    underscore : 'libs/node_modules/underscore/underscore',
    moment : 'libs/node_modules/moment/moment',
    Q : 'libs/node_modules/q/q'
  },
  shim : {
    backbone : {
      deps : [ 'jquery', 'underscore' ],
      exports : 'Backbone'
    }
  }
});

define([ 'backbone', 'jquery', 'moment', 'underscore', 'Q'], function(backbone, $, moment, _, Q) {
  // expose to global variables for ease to use
  window.$ = $;
  window._ = _;
  window.Q = Q;
});