import React from "react";
import search from '../../shared/assets/icons/search.png';
import './Search.css';

const Search = () => {
    return (
        <div className="search">
            <img src={search} alt="search-logo" className="search-logo"/>
            <div className="search-bar">
                <input type="text" placeholder="Search for Groups, Users, and Files" />
            </div>
            <button className="search-button">Search..</button>
        </div>
    )
}
export default Search;
