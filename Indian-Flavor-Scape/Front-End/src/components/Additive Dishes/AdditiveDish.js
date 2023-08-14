import React, { useState, useEffect } from "react";
import {
  useNavigate,
  createSearchParams,
  useSearchParams,
} from "react-router-dom";
import { getSideDishesFood } from "../Functions/APIFunctions.js";
import Navbar from "../Navbar/NavBar.js";

function AdditiveDish() {
  const navigate = useNavigate();
  const [dish, setDish] = useState({});
  const [searchparams] = useSearchParams();
  const id = searchparams.get("mainDishId");
  const idAdd = searchparams.get("additiveId");

  const getDish = () => {
    getSideDishesFood(id, setDish);
  };

  useEffect((e) => {
    getDish();
  }, []);

  const handleDish = (idSide) => {
    navigate({
      pathname: "/SideDish",
      search: createSearchParams({
        mainDishId: id,
        additiveId: idAdd,
        sideId: idSide,
      }).toString(),
    });
  };
  return (
    <>
      <div className="absol" style={{ position: "sticky" }}>
        <div className="top-div"></div>
        <Navbar />
      </div>
      <div className="Additive-container">
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

export default AdditiveDish;
