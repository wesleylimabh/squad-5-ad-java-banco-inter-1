import React, { useState, useEffect } from "react";
import {Navbar, NavDropdown} from 'react-bootstrap'

import logo from "../../assets/logo1.png"
import userIcon from "../../assets/user.png"
import "./Header.css"

import api from "../../services/api"
import {logout, getEmail} from "../../services/auth"


export default function Header() {

  const [user, setUser] = useState('Usuario')
  const [userToken, setUserToken] = useState('----')

  useEffect(() => {
  async function fetchData(){
    const email = encodeURIComponent(getEmail());
    const response = await api.get('/usuarios/'+email);

    setUser(response.data.nome);
    setUserToken(response.data.token);
  }
  fetchData();
}, []);

return (
  <Navbar className="container-navbar" fixed="top" expand="sm" variant="dark" >
    <Navbar.Brand href="/main">
      <img
        src={logo} className="align-top logo-img" alt="logo"
      />
    </Navbar.Brand>
    <Navbar.Text>Bem vindo {user}. Seu Token é: {userToken} </Navbar.Text>
    <NavDropdown title={
          <img className="icon-image" 
          src={userIcon} 
          alt="user pic"
          />
    }>
        <NavDropdown.Item href="/" onClick={logout}>Logout</NavDropdown.Item>
    </NavDropdown>
  </Navbar>
);
}