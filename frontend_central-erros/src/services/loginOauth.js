var qs = require('qs');
var axios = require('axios');

const consumerKey = `aceleradevSquad5`;
const consumerSecret = `aceleradevSquad5`;
const authHeader = Buffer.from(`${consumerKey}:${consumerSecret}`, `binary`).toString(`base64`);
// const authEndpoint = `https://central-erros-squad5.herokuapp.com`;
const authEndpoint = `http://localhost:8080`;

const api = axios.create({
    baseURL: authEndpoint
});

const config = {
    headers: {
        'Authorization': `Basic ${authHeader}`,
        'Content-Type': 'application/x-www-form-urlencoded',
        'Access-Control-Allow-Origin': '*'
    },
    timeout: 5000    
};

const loginOauth = async(email, pass) =>{
    const data = qs.stringify({
        grant_type: 'password',
        username: email,
        password: pass
    });

    const returnVal = await api.post('/oauth/token', data, config);
        if (returnVal) {
            if (returnVal.data && returnVal.data.access_token) {
                return returnVal;
            }
        }
}

export default loginOauth;