import React, { Component } from 'react'
import { ToastContainer } from 'react-toastify'
import NavBar from './components/NavBar'
import { Routes, Route } from 'react-router-dom'
import BooksCard from './components/BooksCard'
import BookDetails from './components/BookDetails'
import AuthorDetails from './components/AuthorDetails'
import Authors from './components/Authors'
import Rentals from './components/Rentals'
import 'react-toastify/dist/ReactToastify.css'
import './App.css'

const App = () => {
  return (
    <>
      <NavBar />
    </>
  )
}

export default App
