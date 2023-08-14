import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Signup.css";
import Signup from "./Signup.js";
import Login from "./Login.js";
import Navbar from "../Navbar/NavBar.js";
import { useNavigate } from "react-router-dom";

function LogSign(props) {
  const navigate = useNavigate();

  return (
    <div>
      <div className="absol">
        <div className="top-div"></div>
        <Navbar />
      </div>
      <div className="row">
        <div className="first-div col-lg-6">
          <h2 className="h2-acc">Welcome</h2>
          <p className="p-acc">
            Discover the magic of Indian flavors, 
            where each bite transports you to a world of rich culinary traditions and the authentic taste of India.
          </p>
          <img className="img-acc" src="./images/icon.png" alt="icon"></img>
        </div>
        <div className="second-div col-lg-6">
          {props.active === "first" && <Login navigate={navigate} />}
          {props.active === "second" && <Signup />}
        </div>
      </div>
    </div>
  );
}

export default LogSign;
