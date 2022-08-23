import React from "react";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';

const NavBar = () =>{

    const handleLink = () => {
        const windowLink = window.open('about:blank');
        windowLink.location.href = "https://www.techcareer.net/"
    }

    return(
        <NavBar>
            <Container>
                <Navbar.Brand>

                <img
                alt="Techcareer"
                src={require(`../images/techcareer.svg`).default}
                width="100"
                height="30"
                className="d-inline-block align-top"
                onClick={handleLink}/>

                </Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link href="/books">Books</Nav.Link>
                    <Nav.Link href="/authors">Authors</Nav.Link>
                    <Nav.Link href="/rentals">Rentals</Nav.Link>
                </Nav>
            </Container>
        </NavBar>
    )

}


export default NavBar;