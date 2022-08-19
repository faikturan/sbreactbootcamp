import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import NavDropdown from 'react-bootstrap/NavDropdown'

const NavBar = () => {
  const handleLink = () => {
    const windowLink = window.open('about:blank')
    windowLink.location.href = 'https://www.techcareer.net/'
  }
  return (
    <>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand>
            <img
              alt="Techcareer"
              src={require(`../images/techcareer.svg`).default}
              width="100"
              height="30"
              className="d-inline-block align-top"
              onClick={handleLink}
            />
          </Navbar.Brand>
          <Nav>
            <Nav.Link href="/books">Books</Nav.Link>
            <Nav.Link href="/authors">Authors</Nav.Link>
            <Nav.Link href="/rentals">Rentals</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  )
}

export default NavBar
