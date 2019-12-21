import React,{ useEffect, useState } from "react";
import BootstrapTable from 'react-bootstrap-table-next';
import paginationFactory from 'react-bootstrap-table2-paginator';
import Link, { Route } from 'react-router-dom'

import "./Table.css";

import api from "../../services/api";

export default function Table(props) {

  const [data, setData] = useState([]);
  const [sizePerPage, setSizePerPage] = useState(10);
  const [page, setPage] = useState(1);
  const [fildSort, setFildSort] = useState('id');
  const [directionSort, setDirectionSort] = useState('asc');
  const [totalSize, setTotalSize] = useState(0);
  const [environments, setEnvironments] = useState('Produção')
  const [search, setSearch] = useState('')
  const [searchBy, setSearchBy] = useState('')
  
  useEffect(() => {
    async function fetchData(){
    const queryString = new URLSearchParams({
      "page" : page-1 , 
      "ambiente": environments,
      "size" : sizePerPage,
      "sort" : [fildSort, directionSort]
    });
    const response = await api.get("/erros/?"+queryString);
    setData(response.data.content);
    setTotalSize(response.data.totalElements);
    // setSizePerPage(response.data.pageable.pagesize)
    // setPage(response.data.pageable.pagenumber)
    // // setFildSort(response.data)
    // // setDirectionSort(response.data)
  }
  fetchData();
  }, [sizePerPage, page, totalSize, environments, fildSort]);

  function cellFormatter(cell, row) {
    return (
      <div>
        <div>{row.descricao}</div>
        <div>{row.origem}</div>
        <div>{row.data_hora}</div>
      </div>
    );
  }

  const columns = [
    {
      dataField: "id",
      text: "Id",
      sort: true,
      searchable: false,
      hidden: true
    },
    {
      dataField: "level",
      text: "Level",
      sort: true
    },
    {
      dataField: "descricao",
      text: "Log",
      formatter: cellFormatter
    },
    {
      dataField: "eventos",
      text: "Eventos"
    }
  ];

  function handleGetSelectedData() {
    return props.selectionContext.selected;
  }

  function handleTableChange (type, { page, sizePerPage }) {
    setPage(page);
    setSizePerPage(sizePerPage);
  }

  function handleArchiveErrors(){
    async function archiveErrors(){
      const queryString = new URLSearchParams({
        ids:handleGetSelectedData()
      });
      const response = await api.post("/erros/arquivar/?"+queryString);
      if(response.status === 200){
        setTotalSize(totalSize-handleGetSelectedData().length)
      }
    }
    archiveErrors();
  }

  function handleDeleteErrors(){
    async function deleteErrors(){
      const queryString = new URLSearchParams({
        ids:handleGetSelectedData()
      });
      const response = await api.delete("/erros/?"+queryString);
      if(response.status === 200){
        setTotalSize(totalSize-handleGetSelectedData().length)
      }
    }
    deleteErrors();
  }
  
  function handleSearch(event){
    event.preventDefault();
    console.log("Realizar busca com os dados " + search)
    setData([{"id":1, "level":"Error"}])
  }

  function handleSetEnvironments(event) {
    setEnvironments(event.target.value);
  }

  function handleSetFildSort(event) {
    if(event.target.value !== 'orderby'){
      setFildSort(event.target.value);
    
    
    async function orderBy(){
      setDirectionSort('desc')
      const queryString = new URLSearchParams({
        "ambiente": environments,
        "sort" : [fildSort, directionSort]
      });
      const response = await api.get("/erros/?"+queryString);
    }
    orderBy();
  }
  }

  function handleSetSearchBy(event) {
    setSearchBy(event.target.value);
  }

  const rowEvents = {
    onClick: (e, row) => {
      console.log("Redirecionar para página do erro "+ row.id)
    }
 };

  const selectRow = {
    mode: "checkbox",
    clickToSelect: false,
    bgColor: "lightgray"
  };

 const SearchBar = () => (
  <div>
    <div className='container-search-bar'>
      <select name='ambiente' id='ambiente' value={environments} onChange={handleSetEnvironments}>
          <option value='Produção'>Produção</option>
          <option value='Homologação'>Homologação</option>
          <option value='Desenvolvimento'>Desenvolvimento</option>
      </select>
  
      <select name='orderBy' id='orderBy' value={fildSort} onChange={handleSetFildSort}>
          <option value='orderby'>Ordernar por</option>
          <option value='level'>Level</option>
          <option value='eventos'>Frequência</option>
      </select>
  
      <select name='searchBy' id='searchBy' value={searchBy} onChange={handleSetSearchBy}>
          <option value='findby'>Buscar por</option>
          <option value='level'>Level</option>
          <option value='descricao'>Descrição</option>
          <option value='origem'>Origem</option>    
      </select>
  
      <form className='searchBar' onSubmit={handleSearch}>
        <input type="text" 
        placeholder="Buscar..."
        value={search}
        onChange={e => setSearch(e.target.value)}/>
        <button type="submit" >Enviar</button>
      </form>
    </div>
  
    <div className="container-btns">
      <button onClick={ () => handleArchiveErrors() }>
            Arquivar
      </button>
      <button onClick={ () => handleDeleteErrors() }>
            Apagar
      </button>
    </div>
  
  </div> 
    );

 
  return (
    
    <div className="container-table">
      <SearchBar />

      <BootstrapTable
        ref={n => (props = n)}
        keyField="id"
        remote
        data={data}
        columns={columns}
        selectRow={ selectRow }
        rowEvents={ rowEvents }
        page={ page }
        sizePerPage={ sizePerPage }
        totalSize={ totalSize }
        pagination={ paginationFactory({ page, sizePerPage, totalSize }) }
        onTableChange={ handleTableChange }
        bordered={ false }
        hover
        noDataIndication="Tabela vazia" 
      />
    </div>
  );
}
