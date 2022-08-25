import React, { Component } from 'react'
import { ToastContainer } from 'react-toastify'
import NavBar from './components/NavBar'
import { Route, Navigate, Routes, BrowserRouter } from 'react-router-dom'
import BooksCard from './components/BooksCard'
import BookDetails from './components/BookDetails'
import AuthorDetails from './components/AuthorDetails'
import Authors from './components/Authors'
import Rentals from './components/Rentals'
import 'react-toastify/dist/ReactToastify.css'
import LoginForm from './components/LoginForm'
import RegisterForm from './components/RegisterForm'
import Logout from './components/Logout'
import NotFound from './components/NotFound'
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css'
const App = () => {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/register" element={<RegisterForm />} />
          <Route path="/login" element={<LoginForm />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="/books/:id" element={<BookDetails />} />
          <Route path="/authors/:id" element={<AuthorDetails />} />
          <Route path="/books" element={<BooksCard />} />
          <Route path="/authors" element={<Authors />} />
          <Route path="/rentals" element={<Rentals />} />
          <Route path="/not-found" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
