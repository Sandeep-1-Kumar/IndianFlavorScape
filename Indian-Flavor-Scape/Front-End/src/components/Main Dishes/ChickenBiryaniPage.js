import React, { useState, useEffect } from "react";
import "./Main.css";
import {
  useNavigate,
  createSearchParams,
  useSearchParams,
} from "react-router-dom";
import { getAdditiveDishesFood } from "../Functions/APIFunctions.js";
import Navbar from "../Navbar/NavBar.js";

function ChickenBiryaniPage() {
  const navigate = useNavigate();
  const [dish, setDish] = useState({});
  const [searchparams] = useSearchParams();
  const id = searchparams.get("mainDishId");

  const getDish = () => {
    getAdditiveDishesFood(id, setDish);
  };

  useEffect((e) => {
    getDish();
  }, []);

  const handleDish = (idAdd) => {
    navigate({
      pathname: "/AdditiveDish",
      search: createSearchParams({
        mainDishId: id,
        additiveId: idAdd,
      }).toString(),
    });
  };

  return (
    <>
      <div className="absol" style={{ position: "sticky" }}>
        <div className="top-div"></div>
        <Navbar />
      </div>
      <div className="Main-container">
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

export default ChickenBiryaniPage;
