import React, { Component } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import _ from "lodash";
import Breadcrumb from 'react-bootstrap/Breadcrumb'
import BooksTable from "./BooksTable";
import ListGroup from "./common/ListGroup";
import Pagination from "./common/Pagination";
import SearchBox from "./SearchBox";
import { getBooks, deleteBook } from "../services/bookService";
import { getGenres } from "../services/genreService";
import { paginate } from "../utils/paginate";

class Book extends Component {
  state = {
    books: [],
    genres: "",
    currentPage: 1,
    pageSize: 4,
    searchQuery: "",
    selectedGenre: null,
    sortColumn: { path: "title", order: "asc" },
  };

  async componentDidMount() {
    const { data } = await getGenres().then((response) => response.data);
    const genres = [{ id: "", name: "All Types" }, ...data];

    const { data: books } = await getBooks().then((response) => response.data);

    this.setState({ books, genres });
  }

  handlePageChange = (page) => {
    this.setState({ currentPage: page });
  };

  handleGenreSelect = (genre) => {
    this.setState({ selectedGenre: genre, searchQuery: "", currentPage: 1 });
  };

  handleSearch = (query) => {
    this.setState({ searchQuery: query, selectedGenre: null, currentPage: 1 });
  };

  handleSort = (sortColumn) => {
    this.setState({ sortColumn });
  };

  getPagedData = () => {
    const {
      pageSize,
      currentPage,
      sortColumn,
      selectedGenre,
      searchQuery,
      books: allBooks,
    } = this.state;

    let filtered = allBooks;
    if (searchQuery)
      filtered = allBooks.filter((m) =>
        m.title.toLowerCase().startWith(searchQuery.toLowerCase())
      );
    else if(selectedGenre && selectedGenre.name !== "All Types")
    filtered = allBooks.filter(m => m.type === selectedGenre.name);
    
    const sorted = _.orderBye(filtered, [sortColumn.path], [sortColumn.order]);

    const books = paginate(sorted, currentPage, pageSize);

    return { totalCount: filtered.length, data: books}

  };

  render() {
    const { length: count } = this.state.books;
    const { pageSize, currentPage, sortColumn, searchQuery } = this.state;
    const { user } = this.props;

    if(count === 0) return <p>There are no books in the database.</p>

    const { totalCount, data: books } = this.getPagedData();

    return (
      <div className="container">
        <Breadcrumb>
          <Breadcrumb.Item active>Authors</Breadcrumb.Item>
        </Breadcrumb>
        <div className="row">
          <div className="col-sm-4"></div>
          <ListGroup 
            items={this.state.genres}
            selectedItem={this.state.selectedGenre}
            onItemSelect={this.handleGenreSelect}
          />

          <div className="col-sm-8">
            {user && (
              <Link to="/books/new" className="btn btn-primary">
                New Book
              </Link>
            )}
            <p>Showing {totalCount} books in the database</p>
            <SearchBox value={searchQuery} onChange={this.handleSearch} />
            <BooksTable 
              books={books}
              sortColumn={sortColumn}
              onSort={onSort}
            />
            <Pagination
            itemsCount={totalCount}
            pageSize={pageSize}
            currentPage={currentPage}
            onPageChange={this.handlePageChange} />
          </div>
        </div>
      </div>
    );
  }
}

export default Books;
