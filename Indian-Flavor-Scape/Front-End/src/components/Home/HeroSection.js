import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Button from "react-bootstrap/Button";
import "./HeroSection.css";
import { useNavigate } from "react-router-dom";
import { email } from "../Functions/CommonScripts.js";
import { customer } from "../Functions/CommonScripts.js";

function HeroSection() {
  const navigate = useNavigate();
  const check = (e) => {
    email !== undefined
      ? customer === "admin"
        ? navigate("/UpdateOrders")
        : navigate("/Dashboard")
      : navigate("/CustomerLogin");
  };

  const checkOrders = (e) => {
    email !== undefined
      ? customer === "admin"
        ? navigate("/UpdateOrders")
        : navigate("/Orders")
      : navigate("/CustomerLogin");
  };

  return (
    <div className="hero-container">
      <img className="img-home" src="./images/Home.jpg" alt="Home_Image" />
      <h1 className="card-head ital-rem">Indian Flavor Scape</h1>
      <p className="p-home">get started to explore a universe of flavors</p>
      <div>
        <Button
          className="btn btn-secondary btn-lg btn-acc-home"
          onClick={(e) => {
            check(e);
          }}
        >
          GET STARTED
        </Button>
        <div style={{ padding: '10px' }}></div>
        
         {(email !== undefined && customer !== "admin") && (<Button
          className="btn btn-secondary btn-lg btn-acc-home"
          onClick={(e) => {
            checkOrders(e);
          }}
        >
          My Orders
        </Button>

        )}
        
      </div>
    </div>
  );
}

export default HeroSection;
