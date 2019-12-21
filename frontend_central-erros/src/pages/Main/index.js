import React from "react";

import 'bootstrap/dist/css/bootstrap.min.css';
import "./Main.css";

import Header from ".././../components/Header";
import Table from "../../components/Table";


export default function Main({ match }) {
  return (
    <div className="main-container">
      <Header />
      <Table />     
    </div>
  );
}
