import { useState } from 'react'

import './App.css'
import Nav from './components/Nav'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeList from './components/EmployeeList'
import AddEmployee from './components/AddEmployee'
import UpdateEmployee from './components/UpdateEmployee'

function App() {


  return (
    
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route index element={<EmployeeList/>}/>
        <Route path='/' element={<EmployeeList/>}/>
        <Route path='/addEmployee' element={<AddEmployee/>}/>
        <Route path='/editEmployee/:id' element={<UpdateEmployee/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
