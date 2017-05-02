import fetch from 'isomorphic-fetch'

const queryParams = (params) => {
    return Object.keys(params)
        .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(params[k]))
        .join('&')
}

/* enable query params for requests */
const fetch2 = (url, options={}) => {
    if(options.queryParams) {
        url += (url.indexOf('?') === -1 ? '?' : '&') + queryParams(options.queryParams)
    }

    return fetch(url, options)
}

export default fetch2
