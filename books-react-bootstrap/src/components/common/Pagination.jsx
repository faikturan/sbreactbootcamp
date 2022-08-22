import React from "react";
import PropTypes from "prop-types";
import _ from "lodash";

const Pagination = ({ itemCount, pageSize, currentPage, onPageChange }) => {
  const pagesCount = Math.ceil(itemsCount / pageSize);
  if (pagesCount === 1) return null;
  const page = _.range(1, pagesCount + 1);
  return (
    <nav>
      <ul className="pagination">
          {pages.map(page => (
              <li
              key={page}
              className={page === currentPage ? "page-item active" : "page-item"}>
                <a className="page-link" href="#" onClick={() => onPageChange(page)}>
                    {page}
                </a>
              </li>
          ))}
      </ul>
    </nav>
  );
};

export default Pagination;
