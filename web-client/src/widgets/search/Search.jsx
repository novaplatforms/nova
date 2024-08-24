import React from "react";
import search from '../../shared/assets/icons/search.png';
import './Search.css';

const Search = () => {
    const [searchQuery, setSearchQuery] = React.useState('');

    const handleButtonClick = () => {
        console.log('Search Query:', searchQuery);
    }

    return (
        <div className="search">
            <img src={search} alt="search-logo" className="search-logo"/>
            <div className="search-bar">
                <input
                    type="text"
                    placeholder="Search for Groups, Users, and Files"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
            </div>
            <button className="search-button" onClick={handleButtonClick}>Search</button>
        </div>
    )
}

export default Search;
