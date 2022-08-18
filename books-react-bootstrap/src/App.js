import React, {Component} from 'react';
import { ToastContainer } from 'react-toastify';
import NavBar from './components/NavBar';
import { Routes, Route } from "react-router-dom";
import BooksCard from "./components/BooksCard";
import BookDetails from "./components/BookDetails";
import AuthorDetails from "./components/AuthorDetails";
import Authors from "./components/Authors";
import Rentals from "./components/Rentals";
import "react-toastify/dist/ReactToastify.css";
import "./App.css";

class App extends Component {
  state = {};
  render(){
  return (
   <React.Fragment>
   <ToastContainer />

   <NavBar />
   <main className="container">
   <Routes>
       <Route path="/" component={App} />
   <Route path="/books/:id" component={BookDetails} />
            <Route path="/authors/:id" component={AuthorDetails} />
            <Route
              path="/books"
              render={props => <BooksCard {...props} />}
            />
            <Route path="/authors" render={props => 
                <Authors {...props} />}
            />
            <Route path="/rentals" component={Rentals} />

      </Routes>

      </main>

   </React.Fragment>
  );
}
}

export default App;
