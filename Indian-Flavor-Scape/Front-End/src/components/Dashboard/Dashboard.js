import React, { useState, useEffect } from "react";
import "./Dashboard.css";
import { useNavigate, createSearchParams } from "react-router-dom";
import { getMainDishesFood } from "../Functions/APIFunctions.js";
import Navbar from "../Navbar/NavBar.js";

function Dashboard() {
  const navigate = useNavigate();
  const [dish, setDish] = useState({});

  const getDish = () => {
    getMainDishesFood(setDish);
  };

  useEffect((e) => {
    getDish();
  }, []);

  const handleDish = (id) => {
    navigate({
      pathname: "/ChickenBiryaniPage",
      search: createSearchParams({
        mainDishId: id,
      }).toString(),
    });
  };

  return (
    <>
      <div className="absol" style={{ position: "sticky" }}>
        <div className="top-div"></div>
        <Navbar />
      </div>
      <div className="dashboard-container">
        {Object.keys(dish).map((key, i) => (
          <React.Fragment key={i}>
            <div
              className="dashboard-button"
              onClick={() => {
                handleDish(dish[key]["id"]);
              }}
            >
              <img src={dish[key]["urlImage"]} alt={dish[key]["name"]} />
              {dish[key]["name"]}
            </div>
          </React.Fragment>
        ))}
      </div>
    </>
  );
}

export default Dashboard;
