export const TOKEN_KEY = "@squad5-Token";
export const isAuthenticated = () => sessionStorage.getItem(TOKEN_KEY) !== null;
export const getToken = () => sessionStorage.getItem(TOKEN_KEY);
export const getEmail = () => sessionStorage.getItem('email'); 

export const login = token => {
  sessionStorage.setItem(TOKEN_KEY, token);
};

export const logout = () => {
  sessionStorage.removeItem(TOKEN_KEY);
  sessionStorage.removeItem('email');
};

export const saveEmail = email =>{
  sessionStorage.setItem('email', email);
}
