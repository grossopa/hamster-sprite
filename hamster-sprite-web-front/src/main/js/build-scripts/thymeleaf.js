const fs = require('fs');
const rimraf = require('rimraf');

const DIR_TEMPLATES = 'build/templates';
const DIR_TEMPLATES_HTML = DIR_TEMPLATES + '/html';
const FILE_INDEX_HTML = 'build/index.html';

const REG_CSS = new RegExp(/static\/css\/main.([A-Za-z0-9]+).css/);
const REG_JS = new RegExp(/static\/js\/main.([A-Za-z0-9]+).js/);

const THYMELEAF_TEMPLATE = (
  '<link th:fragment="react-css" th:href="${base_url} + \'/static/css/main.CSS_HASH.css\'" rel="stylesheet">\n' +
  '<script th:fragment="react-js" type="text/javascript" src="${base_url} + \'/static/js/main.JS_HASH.js\'"></script>'
);
const THYMELEAF_TEMPLATE_FILE = DIR_TEMPLATES_HTML + '/react.html';

function info(str) {
  console.log('[thymeleaf] ' + str);
}

function error(str) {
  console.error('[thymeleaf] ' + str);
  throw new Error(str);
}

info('Start to build thymeleaf template.');

if (!fs.existsSync(FILE_INDEX_HTML)) {
  error('Cannot find ' + FILE_INDEX_HTML);
}

if (fs.existsSync(DIR_TEMPLATES)) {
  info('Removing existing template path : ' + DIR_TEMPLATES);
  rimraf.sync(DIR_TEMPLATES);
}

info('Creating template directory : ' + DIR_TEMPLATES_HTML);
fs.mkdirSync(DIR_TEMPLATES);
fs.mkdirSync(DIR_TEMPLATES_HTML);

info('Opening generated index.html and find out the css and js hash.');
fs.readFile(FILE_INDEX_HTML, 'utf8', (err, data) => {
  if (err) {
    throw err;
  }

  const cssMatch = data.match(REG_CSS);
  if (cssMatch.length <= 1) {
    error('Failed to find css path from generated index.html file.');
  }
  const cssHash = cssMatch[1];
  info('CSS hash : ' + cssHash);

  const jsMatch = data.match(REG_JS);
  if (jsMatch.length <= 1) {
    error('Failed to find js path from generated index.html file.');
  }
  const jsHash = jsMatch[1];
  info('JS hash : ' + jsHash);

  const td = THYMELEAF_TEMPLATE.replace('CSS_HASH', cssHash).replace('JS_HASH', jsHash);

  fs.writeFile(THYMELEAF_TEMPLATE_FILE, td, (err) => {
    if (err) {
      error('Failed to write template file.');
    }
    info('Execution finished.');
  });
});
