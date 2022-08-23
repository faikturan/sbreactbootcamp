import React, { Component } from 'react'
import { ToastContainer } from 'react-toastify'
import NavBar from './components/NavBar'
import { Route, Navigate, Routes } from 'react-router-dom'
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
import './App.css'

class App extends Component {
  state = {}
  render() {
    return (
      <React.Fragment>
        <ToastContainer />

        <NavBar />

        <Routes>
          <Route path="/register" component={RegisterForm} />
          <Route path="/login" component={LoginForm} />
          <Route path="/logout" component={Logout} />
          <Route path="/books/:id" component={BookDetails} />
          <Route path="/authors/:id" component={AuthorDetails} />
          <Route path="/books" render={(props) => <BooksCard {...props} />} />
          <Route path="/authors" render={(props) => <Authors {...props} />} />
          <Route path="/rentals" component={Rentals} />
          <Route path="/not-found" component={NotFound} />
        </Routes>
      </React.Fragment>
    )
  }
}

export default App
