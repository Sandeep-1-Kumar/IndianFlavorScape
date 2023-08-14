import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./NavBar.css";
import { Nav, Navbar, Container, Button, DropdownButton, Dropdown } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import { email, cookieslog } from "../Functions/CommonScripts.js";

function NavBar() {
  const logout = () => {
    cookieslog.remove("user");
    cookieslog.remove("customer");
    window.location.href = "/CustomerLogin";
  };

  return (
    <Navbar bg="light" expand="lg" className="navbar-main">
      <Container className="cont">
        <Navbar.Brand href="/Home" className="brand-name">
          Indian Flavor Scape
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="justify-content-end flex-grow-1 pe-3">
            <Button className="btn-nav link">
              <NavLink to="/Home" className="active">
                HOME
              </NavLink>
            </Button>

            
            <Button className="btn-nav link">
              <NavLink to="/ContactUs" className="active">
                CONTACT US
              </NavLink>
            </Button>

            <Button className="btn-nav link">
              <NavLink to="/About" className="active">
                ABOUT
              </NavLink>
            </Button>
            {email === undefined && (
              <div className="btn-nav link-sign">
                <DropdownButton style={{ display: "inline" }} title="LOGIN/SIGNUP">
                  <Dropdown.Item>
                    <NavLink to="/EmployeeLogin" className="active link removeLine">
                      Employee
                    </NavLink>
                  </Dropdown.Item>
                  <Dropdown.Item>
                    <NavLink to="/CustomerLogin" className="active link removeLine">
                      Customer
                    </NavLink>
                  </Dropdown.Item>
                </DropdownButton>
              </div>
            )}
            {email !== undefined && (
              <DropdownButton
                id="dropdown-basic-button"
                className="btn-nav link-sign-two"
                title={email.split("@")[0].toUpperCase()}
              >
                <Dropdown.Item onClick={logout}>Logout</Dropdown.Item>
              </DropdownButton>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavBar;
